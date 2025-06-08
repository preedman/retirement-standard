package com.reedmanit.retirement.standard.security;

import com.reedmanit.retirement.standard.service.MyUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration {

    MyUserDetailService myUserDetailService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        logger.info("Security Configuration !!!!!!!");

        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/login", "/error/**", "/logout").permitAll()
                        .requestMatchers("/WEB-INF/jsp/**").permitAll()
                        .requestMatchers("/create", "/edit/**", "/save").hasRole("ADMIN")
                        .requestMatchers("/budgetstandards/**", "/welcome/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                      //  .loginProcessingUrl("/login-process") // Changed to avoid conflict
                 //       .failureUrl("/login?error=true")
                        .failureUrl("/login")
                        .permitAll()
                        .defaultSuccessUrl("/budgetstandards", true) // Changed to false to prevent forced redirect
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                )
            //    .sessionManagement(session -> session
            //            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
           //             .invalidSessionUrl("/login")
           //             .maximumSessions(1)
           //             .maxSessionsPreventsLogin(true)
           //     )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
