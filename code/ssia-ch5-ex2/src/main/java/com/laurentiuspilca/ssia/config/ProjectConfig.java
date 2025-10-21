package com.laurentiuspilca.ssia.config;

import com.laurentiuspilca.ssia.filters.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {

    private final StaticKeyAuthenticationFilter filter;

    public ProjectConfig(StaticKeyAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http.addFilterAt(filter, BasicAuthenticationFilter.class)
            .authorizeHttpRequests(c -> c.anyRequest().permitAll());


        return http.build();
    }

}
