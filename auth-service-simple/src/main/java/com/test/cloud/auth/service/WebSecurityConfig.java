package com.test.cloud.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
//@Order(-1)
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jose").password("mypass").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .and()
                .exceptionHandling() .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
                /*.authenticated()*///.and().csrf().disable().httpBasic().disable();
        //.and()
        //.formLogin().permitAll();
                /*.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/user").hasRole("USER")
                .and()
                .httpBasic().disable()
                .anonymous().disable();*/
        //.anyRequest().authenticated();//.hasRole("read_users");//authenticated()
        //.and()
        //.authorizeRequests().antMatchers(HttpMethod.GET, "/user/**").access("#oauth2.hasScope('read_users')");
        //.and()
        //.httpBasic();
        /*.formLogin()
            .loginPage("/login").permitAll()*/
    }
}
