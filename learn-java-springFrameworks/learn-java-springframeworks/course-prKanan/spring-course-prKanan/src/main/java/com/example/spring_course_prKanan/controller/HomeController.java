package com.example.spring_course_prKanan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping
public String showHome() {
	return "home";
}
}
