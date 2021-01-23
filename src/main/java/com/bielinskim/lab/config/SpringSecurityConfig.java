package com.bielinskim.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        User.UserBuilder userBuilder = User.builder();

        UserDetails admin = userBuilder
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user = userBuilder
                .username("user")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();

        UserDetails employee = userBuilder
                .username("employee")
                .password(passwordEncoder.encode("employee123"))
                .roles("EMPLOYEE")
                .build();

        manager.createUser(admin);
        manager.createUser(user);
        manager.createUser(employee);

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/webjars/**", "/knowledgeBase", "/", "/knowledgeBase/**").permitAll()
                .antMatchers("/ticket").hasAnyRole("ADMIN", "USER", "EMPLOYEE")
                .antMatchers("/tickets","/editTicket").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/addTicket").hasAnyRole("ADMIN", "USER")
                .anyRequest()
                .authenticated();
        http
                .formLogin()
                .loginPage("/login")
                .permitAll();

        http.csrf().disable();

        http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());
    }

    public AccessDeniedHandler createAccessDeniedHandler(){
        AccessDeniedHandlerImpl impl = new AccessDeniedHandlerImpl();
        impl.setErrorPage("/error403");
        return impl;
    }

}

