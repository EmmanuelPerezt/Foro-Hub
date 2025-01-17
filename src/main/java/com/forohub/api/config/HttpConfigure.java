package com.forohub.api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.forohub.api.filter.SecurityFilter;


@Configuration
@EnableWebSecurity
public class HttpConfigure {
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
           .csrf(c -> c.disable())
           .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .authorizeHttpRequests(req ->{
            req.requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers( "/swagger-ui/**","/v3/api-docs/**",
            "/swagger-ui.html","/swagger-resources/**","/webjars/**","/swagger-html/**").permitAll();
            req.anyRequest().authenticated();
           })
           .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class)
           .build();
       
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //encriptador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }
    
}
