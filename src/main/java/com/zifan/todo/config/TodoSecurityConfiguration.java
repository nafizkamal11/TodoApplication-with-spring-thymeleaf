package com.zifan.todo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 2025, March 10, Monday, 6:12 AM
 */

@Configuration
public class TodoSecurityConfiguration {
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .passwordEncoder(password -> passwordEncoder().encode(password))
                        .username("nafiz")
                        .password("123")
                        .roles("USER", "ADMIN")
                        .build(),

                User.builder()
                        .passwordEncoder(password -> passwordEncoder().encode(password))
                        .username("kamal")
                        .password("123")
                        .roles("USER", "ADMIN")
                        .build()
        );
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
