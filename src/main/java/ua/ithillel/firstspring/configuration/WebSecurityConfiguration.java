package ua.ithillel.firstspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Value("${spring.security.admin.name}")
    private String adminName;

    @Value("${spring.security.admin.password}")
    private String adminPassword;

    @Bean   //configuration users
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername(adminName)
                .password(passwordEncoder.encode(adminPassword))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean   //configuration access
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/administration")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean   //coding-decoding passwords
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

}
