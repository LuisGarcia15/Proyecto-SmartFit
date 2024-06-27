package com.project.smartfit.security;

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
import com.project.smartfit.repositories.userRepository;

@Configuration
public class SecurityBeanInjector {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private userRepository userRepository;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {

        /*Inyecta la implementación de AutenticationManager, que sera ProviderManager*/
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    /*Un AuthenticationProvider es una interfaz que define una estrategia de
    * autenticación */
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
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        /*Inyecta la implementación de PasswordEncoder, siendo
        * BcryptPasswordEncoder*/
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return (user -> {
           return userRepository.findByUser(user).orElseThrow();
        });
    }
}
