package com.example.spring_core.Kanan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class DemoApplication {
	    public static void main(String[] args) {
	    	ConfigurableApplicationContext appContext=SpringApplication.run(DemoApplication.class, args);
	    	
	    	Employee been=appContext.getBean(Employee.class);
	    	 Employee2 e=appContext.getBean(Employee2.class);
	   	  System.out.println(e.id);
	   	  System.out.println(e.name);
	   	 System.out.println();
	   	 System.out.println(e.car.model+" ");
	   	 System.out.println(e.car.year);
	   	 
	    }
	 
	}

