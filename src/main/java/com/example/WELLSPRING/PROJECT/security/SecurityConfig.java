package com.example.WELLSPRING.PROJECT.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ✅ ENABLE CORS
            .cors(Customizer.withDefaults())

            // ❌ DISABLE CSRF (for REST APIs + frontend JS)
            .csrf(csrf -> csrf.disable())

            // 🔐 AUTHORIZATION RULES
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register").permitAll()
                .requestMatchers("/admin/create").hasRole("ADMIN")
                .requestMatchers("/diet/admin/**").hasRole("ADMIN")
                .requestMatchers("/health/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/diet/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )

            // 🔑 BASIC AUTH
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // ✅ GLOBAL CORS CONFIGURATION
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // ⚠ For learning: allow all
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
	  
}
