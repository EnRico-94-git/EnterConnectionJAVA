package br.com.enterconnection.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SegurancaConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity exceptionHandling2 = http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/register", "/login").permitAll()
                    .requestMatchers("/cliente/cadastro", "/cliente/atualizar/**", "/cliente/remover/**").hasAuthority("ROLE_ADMIN")
                    .requestMatchers("/empresa/cadastro", "/empresa/atualizar/**", "/empresa/remover/**").hasAuthority("ROLE_ADMIN")
                    .requestMatchers("/parceiro/cadastro", "/parceiro/atualizar/**", "/parceiro/remover/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/index", true)
                    .failureUrl("/login?falha=true")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            )
            .exceptionHandling(exceptionHandling ->
                exceptionHandling
                    .accessDeniedHandler((request, response, accessDeniedException) -> {
                        response.sendRedirect("/acesso_negado");
                    })
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
