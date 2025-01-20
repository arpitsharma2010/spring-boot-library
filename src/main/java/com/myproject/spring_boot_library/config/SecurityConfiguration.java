package com.myproject.spring_boot_library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Disable cross site request forgery
        http.csrf(AbstractHttpConfigurer::disable);

        //Protect endpoints at /api/<type>/secure
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                        "/api/books/secure/**",
                        "/api/reviews/secure/**")
                .authenticated()
                .anyRequest().permitAll()
        );

        // Enable OAuth2 Resource Server support and JWT validation
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        // Add CORS configuration
        http.cors(cors -> {});

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        // Configure custom 401 error response for OAuth2
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }

}
