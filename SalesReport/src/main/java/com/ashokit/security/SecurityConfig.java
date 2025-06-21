package com.ashokit.security;

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
	 SecurityFilterChain security(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/sales-reports/**").hasRole("ADMIN")  
	            .anyRequest().authenticated() 
	        )
	        .formLogin(form->form.disable()) 
	        .httpBasic(Customizer.withDefaults());

	    return http.build();
	}

	
}
