package com.example.spring_course_prKanan.controller;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_course_prKanan.entity.AdminModel;
import com.example.spring_course_prKanan.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path="/admin")
public class AdminController {

@Autowired
private UserService userService;
@PostMapping(path="/admin")
public String receiveAdminData(@Valid @ModelAttribute(name="admin")AdminModel admin,BindingResult br) {
	if(br.hasErrors()) {
		return "create-admin-account";
	}
	UUID u=UUID.randomUUID();
	
	userService.add(admin);
	return"redirect:/user/open-our-login";
}
}
