package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/attendance/mark").hasRole("EMPLOYEE")
                .requestMatchers("/api/attendance/report/**").hasRole("MANAGER")
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails emp = User.withDefaultPasswordEncoder()
            .username("employee")
            .password("password")
            .roles("EMPLOYEE")
            .build();

        UserDetails mgr = User.withDefaultPasswordEncoder()
            .username("manager")
            .password("password")
            .roles("MANAGER")
            .build();

        return new InMemoryUserDetailsManager(emp, mgr);
    }
}
