package com.Encommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author cesar
 */
@Configuration
@EnableWebSecurity
public class SpringUsuariosSecurity {

    @Autowired
    private UserDetailsService userDetailsServiceImp;
        
    
    
    @Bean
    AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration)throws Exception{
    
         return authenticationConfiguration.getAuthenticationManager();
                 
    }
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/administrador/**").hasRole("ADMIN")
                .requestMatchers("/productos/**").hasRole("ADMIN")
                .requestMatchers( "/css/**","/vendor/**").permitAll() 
                .anyRequest().authenticated())
                .formLogin(form -> form
                .loginPage("/usuario/login")
                .permitAll().defaultSuccessUrl("/usuario/accederUsuario")
                );

        return http.build();

    }
    
    @Bean
    public BCryptPasswordEncoder getEnecoder(){
    
        return new BCryptPasswordEncoder();
        
    }

}