package com.test.cloud.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    //@Qualifier("dataSource")
    /*@Autowired
    private DataSource dataSource;*/

    @Bean
    public TokenStore tokenStore() { ;
        //return new InMemoryTokenStore();
        //dataSource = applicationContext.getBean(DataSource.class);
        return new JdbcTokenStore(dataSource());
        //return new JdbcTokenStore(dataSource());
    }


    //HIKARI CP
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://192.168.100.5:5432/auth");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sa");
        return dataSource;
    }*/

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource());
                /*.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("refresh_token", "password")
                .authorities("ROLE_USER")
                .scopes("read_users")
                //.resourceIds("resource")
                .accessTokenValiditySeconds(600)
                .refreshTokenValiditySeconds(6000);*/
                //.autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        //security.checkTokenAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
    }
}
