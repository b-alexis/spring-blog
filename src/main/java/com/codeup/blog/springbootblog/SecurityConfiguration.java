package com.codeup.blog.springbootblog;

import com.codeup.blog.springbootblog.services.UserDetailsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration {
    private static SecurityConfiguration ourInstance = new SecurityConfiguration();

    public static SecurityConfiguration getInstance() {
        return ourInstance;
    }

    @Configuration
    @EnableWebSecurity
    public SecurityConfiguration extends WebSecurityConfigurerAdapter{
        @Autowired
        private UserDetailsLoader userDetails;

        @Bean
        public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();

    }

        @Override
        protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetails)//How to find users by username
                .passwordEncoder(passwordEncoder()) // encode/verify passwords
        ;
    }

        @Override
        protected void configure (HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index") // users home page
                .permitAll() // anyone can view
                .and()
                .authorizerequests()
                .antMatchers("/", "/logout", "/posts", "/register")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/posts/create",
                        "/posts/create",
                        "/ads/?/edit"
                )
                .authenticated();

    }
    }
}
