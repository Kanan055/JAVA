package com.example.spring_core.Kanan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
	@Bean
    public Employee employee() {
        return new Employee();
    }
    @Bean
    public Computer computer(Employee employee) {
        return new Computer(employee);
    }
}






    
