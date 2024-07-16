package br.com.healthhelper.customer.app.config.security;

import br.com.healthhelper.customer.app.config.security.jwt.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;

import java.io.IOException;
import java.util.Objects;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration implements Filter {

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if ((Objects.equals(httpRequest.getMethod(), HttpMethod.POST.name()) && Objects.equals(httpRequest.getServletPath(), "/user/create"))) {

            chain.doFilter(request, response);
        }
        if (null != httpRequest.getHeader("Authorization")) {

            String token = recoverToken(httpRequest);
            String userName = JWTUtil.getAllClaimsFromToken(token);
            httpRequest.setAttribute("userId", userName);
            chain.doFilter(httpRequest, response);
        } else {
            throw new RuntimeException("Token is necessary");
        }
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
