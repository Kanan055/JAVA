package com.example.spring_course_prKanan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
    private DataSource dataSource;
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	http
	.csrf().disable()
	.authorizeRequests()
	.requestMatchers(HttpMethod.GET,"/user/create-admin-account").permitAll()
	.requestMatchers(HttpMethod.POST,"/admin/add").permitAll()
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/user/open-our-login")
	.loginProcessingUrl("/authenticate-user")
	.permitAll()
	.and()
	.logout().permitAll();
	return http.build();
}
@Bean

public UserDetailsService userDetailsService(DataSource ds) {
	JdbcUserDetailsManager userDetailsManager=new JdbcUserDetailsManager();
	userDetailsManager.setDataSource(dataSource);
	userDetailsManager.setUsersByUsernameQuery("SELECT username,password,enabled FROM user WHERE username=?");
	userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username,authority FROM authorities WHERE username=?");
	return userDetailsManager;
}
}
