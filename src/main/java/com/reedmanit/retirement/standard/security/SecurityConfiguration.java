package com.reedmanit.retirement.standard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Define public URLs
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/sw.js").permitAll()
                        .requestMatchers("/", "/home", "/about", "/welcome").permitAll()

                        // Secure budget-related URLs
                        .requestMatchers("/budgetstandards/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/create", "/edit/**", "/save").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
             //   .formLogin((form) -> form
             //           .loginPage("/login")
             //           .permitAll()
             //           .defaultSuccessUrl("/budgetstandards", true)
            //    )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                )


                .csrf(csrf -> csrf.disable()); // Enable this in production
        http.formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("userpass"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("adminpass"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

