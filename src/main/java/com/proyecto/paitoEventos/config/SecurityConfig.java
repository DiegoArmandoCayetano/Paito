package com.proyecto.paitoEventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desactivamos CSRF para que permita métodos POST, PUT y DELETE sin problemas
            .csrf(csrf -> csrf.disable())
            
            // 2. Configuramos el acceso libre para tus endpoints de desarrollo
            .authorizeHttpRequests(auth -> auth
                // Le decimos al sistema que todo lo que empiece con /api/ tiene PERMISO TOTAL
                .requestMatchers("/api/**").permitAll() 
                // Cualquier otra ruta fuera de /api/ (si existiera) sí requerirá estar autenticado
                .anyRequest().authenticated()
            );
            
            // Nota: Quitamos .httpBasic() porque ya no queremos usar autenticación básica en desarrollo

        return http.build();
    }
}