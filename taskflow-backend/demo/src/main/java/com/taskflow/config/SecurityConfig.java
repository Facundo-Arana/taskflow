package com.taskflow.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/h2-console/**").permitAll() // permite H2 console
//                .anyRequest().authenticated() // todo lo demás requiere login
//            )
//            .csrf(csrf -> csrf.disable()) // necesario para H2
//            .headers(headers -> headers.frameOptions(frame -> frame.disable())); // habilita frames
//
//        return http.build();
//    }
}