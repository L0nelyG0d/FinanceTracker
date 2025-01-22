package com.example.financetracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/expenses", "/expenses/add", "/expenses/getallexpenses").authenticated() // Protect these endpoints
                        .anyRequest().permitAll() // Allow access to other endpoints
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/expenses", true) // Redirect to /expenses after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Redirect to /login after logout
                        .permitAll()
                );
        return http.build();
    }
}