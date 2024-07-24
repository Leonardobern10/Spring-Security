package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                // Método usado para definir regras de autorização para as requisições HTTP.
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                // Define padrões de url e permissões associadas
                                .requestMatchers("/", "/home").permitAll()
                                .anyRequest().authenticated()
                )
                // Configura o formulário de login e define a página de login personalizada
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                // Configuera as opções de logout
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
