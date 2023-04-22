package ru.tolmachev.buyandsell.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.tolmachev.buyandsell.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final CustomUserDetailsService detailsService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
                http
                .authorizeHttpRequests(auth ->
                    auth
                            .requestMatchers("/", "/product/**", "/images/**", "/registration/**")
                            .permitAll()
                            .anyRequest().authenticated()
                            .and())
                            .formLogin()
                            .loginPage("/login")
                            .permitAll()
                            .and()
                            .logout()
                            .permitAll();
                return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }
}
