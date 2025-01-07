package az.developia.comp_shop_Kanan_Alizade.config;



import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
            .csrf().disable()
            .authorizeRequests()
          
            .requestMatchers(HttpMethod.GET, "/", "/login", "/register", "/products", "/products/details/*").permitAll()
            .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
            // URLs accessible only by logged-in user
            .requestMatchers(HttpMethod.GET, "/seller/**").hasRole("SELLER")
            .requestMatchers(HttpMethod.POST, "/seller/**").hasRole("SELLER")
            .requestMatchers(HttpMethod.PUT, "/seller/**").hasRole("SELLER")
            .requestMatchers(HttpMethod.DELETE, "/seller/**").hasRole("SELLER")
            .requestMatchers(HttpMethod.GET, "/buyer/**").hasRole("BUYER")
          
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll();
        
        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select username, password, enabled from users where username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "select username, authority from authorities where username = ?");
        return jdbcUserDetailsManager;
    }
}








