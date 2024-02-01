package com.d209.childmade._common.config;

import com.d209.childmade._common.jwt.JwtAuthorizationFilter;
import com.d209.childmade._common.jwt.JwtExceptionFilter;
import com.d209.childmade._common.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.d209.childmade._common.oauth2.handler.OAuth2AuthenticationFailureHandler;
import com.d209.childmade._common.oauth2.handler.OAuth2AuthenticationSuccessHandler;
import com.d209.childmade._common.oauth2.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final JwtExceptionFilter jwtExceptionFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/user/**").authenticated()
//                        .requestMatchers("/api/auth/**").permitAll()
//                        .anyRequest().authenticated())
                        .anyRequest().permitAll())
                .sessionManagement(sessions -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(configure ->
                        configure.authorizationEndpoint(config -> config.authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository))
                                .userInfoEndpoint(config -> config.userService(customOAuth2UserService))
                                .successHandler(oAuth2AuthenticationSuccessHandler)
                                .failureHandler(oAuth2AuthenticationFailureHandler)
                )
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthorizationFilter.class);

        return http.build();
    }
}
