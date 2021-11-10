/*
 *  @author Jorge M.
 *  10-11-2021
 */

package com.chilesource.Forowebspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/post/delete**").hasRole("MANAGER")
                    .antMatchers("/new-post").hasRole("USER")
                    .antMatchers("/edit**").hasRole("USER")
//                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        // Usando defaultPasswordEncoder como test, no pasar a producción
        // Hardcode users
        UserDetails adminUser = User.withDefaultPasswordEncoder()
                .username("esteban")
                .password("abcdef")
                .roles("USER", "MANAGER")
                .build();

        UserDetails adminUser_2 = User.withDefaultPasswordEncoder()
                .username("jorge")
                .password("spring boot learning")
                .roles("USER", "MANAGER")
                .build();

        UserDetails adminUser_3 = User.withDefaultPasswordEncoder()
                .username("administrador")
                .password("chilesource admin")
                .roles("USER", "MANAGER")
                .build();

        UserDetails basicUser = User.withDefaultPasswordEncoder()
                .username("chilesource_user")
                .password("chilesource_user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(adminUser, adminUser_2, adminUser_3, basicUser);
    }
}
