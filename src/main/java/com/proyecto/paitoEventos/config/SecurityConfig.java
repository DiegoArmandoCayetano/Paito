package com.proyecto.paitoEventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desactivamos CSRF para que permita métodos POST, PUT y DELETE desde Postman
            .csrf(csrf -> csrf.disable())
            
            // 2. Protegemos las rutas, pero exigimos autenticación básica (el usuario y contraseña)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            
            // 3. Activamos la ventana/alerta de autenticación básica
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}