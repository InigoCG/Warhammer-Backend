package warhammer.aos.inigo.com.warhammerbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import warhammer.aos.inigo.com.warhammerbackend.enums.Roles;
import warhammer.aos.inigo.com.warhammerbackend.security.filter.JwtAuthenticationFilter;
import warhammer.aos.inigo.com.warhammerbackend.security.filter.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

        @Autowired
        private AuthenticationConfiguration authenticationConfiguration;

        @Bean
        AuthenticationManager authenticationManager() throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                return http.authorizeHttpRequests(
                                (authz) -> authz
                                                .requestMatchers(HttpMethod.GET, "/users").permitAll()
                                                .requestMatchers(HttpMethod.POST, "/users/register").permitAll()
                                                .requestMatchers(HttpMethod.POST, "/users").hasRole(Roles.ADMIN.name())
                                                .requestMatchers(HttpMethod.POST, "/role").hasRole(Roles.ADMIN.name())
                                                .requestMatchers(HttpMethod.GET, "/role").hasRole(Roles.ADMIN.name())
                                                .requestMatchers(
                                                                HttpMethod.POST,
                                                                "/api/grand-alliance",
                                                                "/api/alliance",
                                                                "/api/unit",
                                                                "/api/ability",
                                                                "/api/key-name",
                                                                "/api/unit-kit",
                                                                "/api/weapon")
                                                .hasRole(Roles.ADMIN.name())
                                                .requestMatchers(HttpMethod.PUT,
                                                                "/api/grand-alliance/{id}",
                                                                "/api/alliance/{id}",
                                                                "/api/unit/{id}",
                                                                "/api/ability/{id}",
                                                                "/api/key-name/{id}",
                                                                "/api/unit-kit/{id}",
                                                                "/api/weapon/{id}")
                                                .hasRole(Roles.ADMIN.name())
                                                .requestMatchers(HttpMethod.DELETE,
                                                                "/api/grand-alliance/{id}",
                                                                "/api/alliance/{id}",
                                                                "/api/unit/{id}",
                                                                "/api/ability/{id}",
                                                                "/api/key-name/{id}",
                                                                "/api/unit-kit/{id}",
                                                                "/api/weapon/{id}")
                                                .hasRole(Roles.ADMIN.name())
                                                .requestMatchers(HttpMethod.GET,
                                                                "/api/grand-alliance/{id}",
                                                                "/api/alliance/{id}",
                                                                "/api/unit/{id}",
                                                                "/api/ability/{id}",
                                                                "/api/key-name/{id}",
                                                                "/api/unit-kit/{id}",
                                                                "/api/weapon/{id}",
                                                                "/api/grand-alliance",
                                                                "/api/alliance",
                                                                "/api/unit",
                                                                "/api/ability",
                                                                "/api/key-name",
                                                                "/api/unit-kit",
                                                                "/api/weapon",
                                                                "/api/unit/complete",
                                                                "/api/unit/complete/{id}")
                                                .hasAnyRole(Roles.ADMIN.name(), Roles.USER.name())
                                                .anyRequest()
                                                .authenticated())
                                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                                .addFilter(new JwtValidationFilter(authenticationManager()))
                                .csrf(config -> config.disable())
                                .sessionManagement(management -> management
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .build();
        }

}

// TODO: Para la conexión con el Frontend mirar vídeo 215 de CORS