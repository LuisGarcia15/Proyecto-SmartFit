package com.project.smartfit.security;

import com.project.smartfit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeanInjector {

    /*Clase que se encarga de inyectar Spring Security para proveer la configuración de,
    * autenticación, tales como obtener el AuthenticationManager que el la interfaz que
    * provee el método de Login*/
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        /*Inyecta la implementación de AutenticationManager, que sera ProviderManager*/
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    /*Un AuthenticationProvider es una interfaz que define una estrategia de
    * autenticación. Es la clase a la cual llamara el AuthenticationManager
    * para login */
    public AuthenticationProvider authenticationProvider(){

        /*Un DaoAuthenticationProvider es una de las implemetaciones de AuthenticationProvider
        * para autenticar un usuario de con contraseña de la Base de Datos.*/
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
        /*Un DaoAuthenticationProvider necestia un PasswordEncoder para validar la contraseña en bruto
        * desde el front con la contraseña codificada y permitir la autorización*/
        authenticationStrategy.setPasswordEncoder(this.passwordEncoder());
        /*Un DaoAuthenticationProvider necesita un UserDetailsServie para obtener el usuario de la BD
        * y validar la contraseña con PassWordEncoder*/
        authenticationStrategy.setUserDetailsService(this.userDetailsService());

        return authenticationStrategy;
        /*DaoAuthenticationProvider es una clase que permite autenticar usuarios almacenados en
        * una base de datos*/
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        /*Inyecta la implementación de PasswordEncoder, siendo
        * BcryptPasswordEncoder*/
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return userRepository.findByUser(username).orElseThrow();
        };
        /*Es posible retornar una Entity de User pues esta implementa
        * la interfaz UserDetailsService*/
    }

}
