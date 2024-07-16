package io.ooruda.allclimb.user.security.config;


import io.ooruda.allclimb.user.security.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .oauth2Login(
                        httpSecurityOAuth2LoginConfigurer ->
                                httpSecurityOAuth2LoginConfigurer
                                        .userInfoEndpoint(
                                                userInfoEndpointConfig ->
                                                        userInfoEndpointConfig.userService(customOAuth2UserService)
                                        )
//                                        .successHandler()
//                                        .failureHandler()
                );

//        http.csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
//                .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
//                .anyRequest().authenticated()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService);

        return http.build();
    }
}
