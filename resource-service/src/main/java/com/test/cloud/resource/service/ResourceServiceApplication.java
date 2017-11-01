package com.test.cloud.resource.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
public class ResourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}

	/*@Configuration
	@EnableWebSecurity
	@EnableAutoConfiguration(exclude = {
			org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
	})
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/login").hasRole("USER")
					.antMatchers("/user").hasRole("SSUSER")
					.antMatchers("/**").access("#oauth2.clientHasRole('LOBSTER')");
		}
	}*/
}
