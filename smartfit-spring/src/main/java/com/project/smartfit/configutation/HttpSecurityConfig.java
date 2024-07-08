package com.project.smartfit.configutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity/*Anotación que permite encontrar una clase de configuración
y aplicar la configuración de seguridad a toda la app. Tambien activa y configura
ciertos componentes como la configuración de AuthenticationConfiguration ya que
permite inyectar aquellos componentes para configurar la seguridad por HTTP request*/
@EnableMethodSecurity(prePostEnabled = true)/*Anotación que permite intectar componentes para configurar
la seguridad por métodos basado en OAP. Sus anotaciones pueden ser aplicadas a un Controller o derivados
(como Service o  Repository). Ya que no distingue, solo debe ser un Controller*/
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider daoAuthenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    /*La cadenas de filtros se construiran a partir de un builder de
    * un objeto HttpSecurity. Permite gestionar y proteger las solicitudes
    * HTTP. Permite gestionar y proteger endpoints
    * Los objetos HttoSecurity permiten configurar la seguridad web de
    * basada en peticiones especificas*/
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        /*TODOS LOS MÉTODOS DE HTTPSECURITY NO SON FILTROS, SON CONFIGURACIONES DE
        * SEGURIDAD HTTP ASI COMO DE LOS ENDPOINS, PERO PODEMOS AGREGAR FILTROS DE
        * SEGURIDAD CON ADDFILTERBEFORE() O ADDFILTERAFTER() PARA AGREGAR UN FILTRO
        * A LA CADENA DE FILTROS DE SEGURIDAD*/
       SecurityFilterChain filterChain = httpSecurity
               .securityMatcher("/login", "/register")
               /*Se está agregando un filtro de seguridad pero que se ejecutará antes del
               * filtro de seguridad de UssernamePasswordAuthentication*/
               .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrfConfig -> csrfConfig.disable())
                /*Seguridad llamada CrossSideRequestForgery, habilita
                seguridad contra este tipo de ataques. Usa intercambio de
                Tokens. Es usada en sesiones StateFul. Como usamos JWT no
                es necesario. La expresion Lambda toma un objeto de configuración
                y lo desabiita*/
                .sessionManagement(sesisionConfig ->
                sesisionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                /*Define el tipo de sesión de la app. En este caso Stateless pues
                * usamos JWT para la seguridad. Recibe una enum que representa diferentes
                * politicas para la creación de sesiones web de SPRING SECURITY. Cada
                * constante define una politica especifica para la creación de una sesión*/
                .authenticationProvider(daoAuthenticationProvider)
                /*Colocamos la estrategis de autenticación que usaremos,
                * en este caso una implementacipón de un auuthenticationProvider
                * que sera un daoAuthenticationProvider para usar tokens de JWT*/
                /*------------------------------------------------------------*/
                /*Configurarmos las rutas publicas y protegidas*/
                .authorizeHttpRequests(authReqConfig -> {
                    authReqConfig.requestMatchers(HttpMethod.POST,"/login/auth").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.POST,"/register").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.GET,"/login/token").permitAll();
                    /*Definimos las rutas publicas y los métodos que podemos
                    * utilizar sin login*/
                    //authReqConfig.requestMatchers(HttpMethod.POST,"/prueba/**").permitAll();
                    /*ES NECESARIO DEFINIR LOS ENDPOINTS PRIVADOS, aún ya se
                    * hayan definido los endpoints publicos, en este caso, todos aquellos
                    * andpoints que no sean los publicos, a continuación: -->*/
                    authReqConfig.anyRequest().authenticated();

                })
                .build();
                return filterChain;
    }
}
