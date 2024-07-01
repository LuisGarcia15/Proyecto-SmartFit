package com.project.smartfit.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIATION_IN_MINUTES;

    private SecretKey sign;

    /*Método que se encargara de generar el token
    * los extraclaims son data que contendra el paylot en forma de JSON,
    * pero que no estan difinidos por el JWT, por lo que son opcionales,
    * sin embargo, existen claims definidos por el JWT, incluso con sus
    * propios métodos para setearlos sin el uso del método claims()*/
    public String generateToken(UserDetails user, Map<String, Object> extraClaims){
        Date issuedAt = new Date(System.currentTimeMillis()); //Obtiene la fecha actual en milisegundos
        /*para la fecha de creación del Token*/
        Date expiration = new Date((EXPIATION_IN_MINUTES) * 60 * 1000 + issuedAt.getTime());
        /*Define la fecha de expiración del token para colocarlo en el*/
        String jwt = Jwts.builder()
                .claims(extraClaims) //Propiedades adiconales del paylot
                //Propiedades especificas del paylot
                .subject(user.getUsername())//Propietario del JWT
                .issuedAt(issuedAt)//Fecha de creación del Token
                .expiration(expiration)//Fecha de expiración
                //Propiedades del header
                .header()
                .type("JWT") //Coloca el tipo de token
                .and()//Regresa al contructyo de Jwst
                .signWith(generateKey())
                //Se firma con una llave una firma criptográfica
                .compact(); //Devuelve el token serializado en un String compacto y seguro

        return jwt;
    }

    private SecretKey generateKey() {
        /*Crea una llave segura gracias a un constructor propio de JWT*/
        if(this.sign == null){
            this.sign = Jwts.SIG.HS256.key().build();
        }
        return this.sign;
    }

    public String extractUser(String jwt) {
        /*Extraemos lo claims para retornar el user*/
        return extractAllClaims(jwt).getSubject();
    }

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
    }
}
