package com.bikerunner.springsecuritytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig
{
    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
            throws Exception {
        var user = User.withUsername("max")
                       .password("mops")
                       .authorities("read")
                       .build();
        var userDetailsService = new InMemoryUserDetailsManager(user);

        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(
//                c -> c.anyRequest().permitAll()
                c -> c.anyRequest().authenticated()
        );
        http.userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean()
    PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
