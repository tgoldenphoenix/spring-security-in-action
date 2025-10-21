package com.laurentiuspilca.ssia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// The @Configuration annotation marks the class as a configuration class
@Configuration
public class ProjectConfig {

    // The @Bean annotation instructs Spring to add the returned value as a bean in the Spring context.
    @Bean
    UserDetailsService userDetailsService() {
        var user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /* When  using  the  default UserDetailsService, a PasswordEncoder  is  also  auto-configured.
      Because  we  overrode UserDetailsService,  we  also  have  to  declare a PasswordEncoder.
      We declare it as a bean & add it to the application context
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        /* The NoOpPasswordEncoder instance  treats  passwords  as  plain  text.  It doesn’t encrypt or hash them. */
        return NoOpPasswordEncoder.getInstance();
    }
}
