package com.springprojects.virtualbookstore.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.Arrays;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("Adwaith", "12345678");
		UserDetails userDetails2 = createNewUser("Mark", "mark123");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}
	
	// All URLs are protected
	// A login form is shown for unauthorized requests
	// CSRF disable
	// Frames

	@Bean
	@PostMapping("/basicAuth")
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.cors(cors->cors.disable()).csrf(csrf->csrf.disable())
		.authorizeHttpRequests(
				auth -> auth.requestMatchers("/basicAuth").authenticated()  // Specify the endpoint that needs authentication
	            .anyRequest().permitAll())
	            .httpBasic(withDefaults())
		.formLogin(withDefaults());

		http.headers(headers->headers.frameOptions(frameOptions->frameOptions.disable()));

		return http.build();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type","Access-Control-Allow-Origin"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
