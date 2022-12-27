package com.proj.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig   {
//	
//	 @Bean
//	    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//
//	        // Permit All Requests inside the Web Application
//	            http.authorizeRequests().anyRequest().permitAll().
//	                    and().formLogin()
//	                    .and().httpBasic();
//
//	        // Deny All Requests inside the Web Application
//	            /*http.authorizeRequests().anyRequest().denyAll().
//	                    and().formLogin()
//	                    .and().httpBasic();*/
//	        
//	            return http.build();
	

	
//
//	    }
	@Bean
	SecurityFilterChain	defaultSecurityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}
}
