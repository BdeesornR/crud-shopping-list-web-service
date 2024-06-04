package com.bdeesorn_r.shopping_list.common.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(authz -> authz.ignoringRequestMatchers("**"))
            .authorizeHttpRequests(
                    authz -> authz.requestMatchers("**").permitAll().anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults());
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain corsFilterChain(HttpSecurity http) throws Exception {
    //     http.cors(Customizer.withDefaults());
    //     http.addFilterBefore(null, UsernamePasswordAuthenticationFilter.class)
    //     return http.build();
    // }
}
