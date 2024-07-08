package com.project.smartfit.configutation;

import com.project.smartfit.entities.JwtToken;
import com.project.smartfit.entities.User;
import com.project.smartfit.repositories.JwtTokenRepository;
import com.project.smartfit.services.JwtService;
import com.project.smartfit.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

/*Clase que extiende de OncePerRequestFilet, que a su vez entiende de
* GenericBeanFilter que asu vez extiende de Filter, por lo que en esencia,
* es un Filter*/
@Controller
/*Se le coloca @Component para poder inyectarlo en HttpSecuryConfig, ya que para
* inyectar algo, debe ser un componente o derivados*/
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /*Inyectamos el servico de JWT para obtener el user de un jwt*/
    @Autowired
    private JwtService jwtService;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    private UserService userService;

    /*Método que tiene la petición, la respuesta y la cadena de filtros de Jakarta,
    * NO ES la cadena de seguridad, es la cadena de Filtros de Jakarta*/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1-.Obtener Authorization de header
        //2-. Obtener JWT
        String jwt = this.jwtService.extractJwtFromRequest(request);
        if(jwt == null || jwt.isEmpty()){
            /*Verificamos que la variable JWT tenga, en efecto, el JWT, si lo tiene
            * hacemos que la cadena de filtros siga ejecutandose*/
            filterChain.doFilter(request, response);
            /*Si bien el método es void, se coloca return para devolver el control de
             * ejecución a quien llamo al método*/
            return;
        }
        //2.5-. Obtener token no expirado y valido desde base de datos
        Optional<JwtToken> token = this.jwtTokenRepository.findByJwt(jwt);
        /*Se obtiene el token en la BD y validamos que sea valido el token*/
        boolean isValid = validateToken(token);
        if(!isValid){
            /*hacemos que la cadena de filtros siga ejecutandose*/
            filterChain.doFilter(request, response);
            /*Si bien el método es void, se coloca return para devolver el control de
             * ejecución a quien llamo al método*/
            return;
        }
        //3-. Obtener el subject/username desde el token, con esto tambíen
        // se vañida el formato del token, la firma y fecha de expiración
        String user = jwtService.extractSubject(jwt);

        //4-. Setear objeto Authentication dentro del SecurityContext que este
        /*Obtenemos el User a partir de subject obtenido en el JWT para
        * obtener los Authorities*/
        User userDetails = userService.findByUser(user).get();
        // a su vez se encuentra en el SecurityContext. Un objeto Authentication
        //tiene un princial, un credentials y unas authorities
        /*UsernamePasswordAuthenticationToken extiende de AbstractAuthenticationToker, asu vez extiende
        * de Authentication, por lo que podemos colocar este objeto en el SecurityContextHolder*/
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user, null, userDetails.getAuthorities()
        );
        /*La clase UsernamePasswordAuthenticationToken tiene el método setDetails, el cual provee la
        * posibilidad de almacenar detalles de una request de authenticación. Le pasamos como
        * parámetro un WebAuthenticationDetails que es una clase que envuelve una request relacionada
        * con un proceso de authenticación. Esto se hace para mero información*/
        authToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        //5-. Ejecutar el restro de Filters
        filterChain.doFilter(request,response);
        /*Si el header de Authorization NO tiene el JWT, le indicamos a la cadena de
         * filtros que siga ejecutando los filtros restantes*/
        return;
        /*Si bien el método es void, se coloca return para devolver el control de
         * ejecución a quien llamo al método*/
    }

    private boolean validateToken(Optional<JwtToken> optionalJwtToken) {
        /*Si el optional es vacio, retornamos false*/
        if(optionalJwtToken.isEmpty()){
            return false;
        }
        /*Obtenmos el JWT*/
        JwtToken token = optionalJwtToken.get();
        Date now = new Date(System.currentTimeMillis());
        /*Verificamos que el token tenga su atributo como valido
        * y que la fecha de expiración sea valdia*/
        boolean isValid = token.isValid() && token.getExpiration().after(now);

        /*Si el token no es valido, lo actualizamos en la BD*/
        if(!isValid){
            this.updateTokenStatus(token);
        }

        return isValid;
    }

    private void updateTokenStatus(JwtToken token) {
        /*Como el token ya no es valido, seteamos su
        * valor a false*/
        token.setValid(false);
        /*Actualizamos el valor de Valid en la BD*/
        this.jwtTokenRepository.save(token);
    }
}
