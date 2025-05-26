package com.reedmanit.retirement.standard.security;

import com.reedmanit.retirement.standard.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    MyUserDetailService MyUserDetailService;

    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.MyUserDetailService = myUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Define public URLs
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/sw.js").permitAll()
                        .requestMatchers("/").permitAll()

                        // Secure budget-related URLs
                        .requestMatchers("/budgetstandards/**", "/welcome/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/create", "/edit/**", "/save").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
             //   .formLogin((form) -> form
             //           .loginPage("/login")
             //           .permitAll()
             //           .defaultSuccessUrl("/budgetstandards", true)
            //    )
            //    .logout((logout) -> logout
            //            .permitAll()
            //            .logoutSuccessUrl("/")
            //    )


                .csrf(csrf -> csrf.disable()); // Enable this in production
        http.formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return MyUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(MyUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
/**
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
    */
}

