package com.todocodeacademy.clinica_veterinaria.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.todocodeacademy.clinica_veterinaria.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    //esta configuración es para proteger las rutas de la aplicación, para que solo puedan ser acc
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/produto/**").permitAll()
                        .requestMatchers("/api/v1/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(sessionManager -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
