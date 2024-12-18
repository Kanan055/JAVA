package com.example.spring_course_prKanan.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(path="/manager")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Manager {
	
		@GetMapping
		@PreAuthorize(value="hasAuthority('ROLE MANAGER')")
		public String showManager() {
			return "manager";
		}
		
		}


