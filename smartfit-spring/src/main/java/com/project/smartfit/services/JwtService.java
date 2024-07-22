package com.project.smartfit.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class
JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIATION_IN_MINUTES;

    @Value("${security.jwt.password-decoded}")
    private String SECRET_KEY;

    /*Método que se encargara de generar el token
    * los extraclaims son data que contendra el paylot en forma de JSON,
    * pero que no estan difinidos por el JWT, por lo que son opcionales,
    * sin embargo, existen claims definidos por el JWT, incluso con sus
    * propios métodos para setearlos sin el uso del método claims()
    *
    *
    * CREA EL JWT PARA UN USUARIO NUEVO*/
    public String generateJWT(UserDetails user, Map<String, Object> extraClaims){
        Date issuedAt = new Date(System.currentTimeMillis()); //Obtiene la fecha actual en milisegundos
        /*para la fecha de creación del Token*/
        Date expiration = new Date((EXPIATION_IN_MINUTES) * 60 * 1000 + issuedAt.getTime());
        /*Define la fecha de expiración del token para colocarlo en el*/
        String jwt = Jwts.builder()
                .claims(extraClaims) //Propiedades adiconales del paylot
                /*LOS EXTRACLIAMS SE REFIEREN A TODA LA DATA QUE AÑADIREMOS
                * AL PAYLOT, EN ESTE CASO: EL USER, EL ROL Y LAS AUTORIDADES*/

                //Propiedades especificas del paylot - 3 almenos obligatorio
                .subject(user.getUsername())//Propietario del JWT
                .issuedAt(issuedAt)//Fecha de creación del Token
                .expiration(expiration)//Fecha de expiración
                //Propiedades del header
                .header()
                .type("JWT") //Coloca el tipo de token
                .and()//Regresa al contructyo de Jwst
                .signWith(generateKey(), Jwts.SIG.HS256)//FIRMA
                //Se firma con una llave una firma criptográfica
                .compact(); //Devuelve el token serializado en un String compacto y seguro

        return jwt;/*CONTRUCCIÓN DE JWT*/
    }

    private SecretKey generateKey() {
        /*Crea una llave segura gracias a una llave de un archivo
        * properties*/
        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(passwordDecoded);
        /*OBTENIENDO LA CLAVE CIFRADA BAJO LA FUNCIÓN STANDARD EN jwt.io*/
    }

    /*MÉTODO DE VALIDACIÓN DE TOKEN*/
    public String extractSubject(String jwt) {
        /*Extraemos lo claims para retornar el user. Si es posible
        * extraer el subject con el JWT que enviamos, retornará el
        * subject, sino, retornará una excepción*/
        return extractAllClaims(jwt).getSubject();
    }

    /*MÉTODO DE VALIDACIÓN DE TOKEN*/
    /*Devulve un objeto de tipo Claims para que,de ese objeto
    * obtengamos el subjet del actual dueño del jwt*/
    private Claims extractAllClaims(String jwt) {
        /*Si cualquiera de las siguientes opcines en invalida:
         * El formato del token es correcto, que su JSON es valido
         * La firma debe coincidir
         * La expiracion del token
         * Se genera una exepción pues el jwt es incorrecto*/
        return Jwts.parser().verifyWith(this.generateKey()).build()
                .parseSignedClaims(jwt).getPayload();
        /*Extraemos lo claims para retornar el user. Si es posible
         * extraer el subject con el JWT que enviamos, retornará el
         * subject, sino, retornará una excepción. Verifica que el JWT
         * este correctamente firmado con la clave original*/
    }

    public String extractJwtFromRequest(HttpServletRequest request) {

        //1-.Obtener encabezado http llamado Authorization
        String authorizationHeader = request.getHeader("Authorization");//Bearer JWT
        if( authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            /*Si el header de Authorization NO tiene el JWT, retornamos null*/
            return null;
        }
        //2-. Obtener JWT desde el encabezado
        String jwt = authorizationHeader.split(" ")[1];
        return jwt;
    }

    public Date extractExpiration(String jwt) {
        return this.extractAllClaims(jwt).getExpiration();
    }
}
