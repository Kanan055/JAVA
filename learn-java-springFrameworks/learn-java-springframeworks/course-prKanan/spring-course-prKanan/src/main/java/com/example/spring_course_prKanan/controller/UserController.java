package com.example.spring_course_prKanan.controller;

import java.util.Random;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_course_prKanan.entity.AdminModel;
import com.example.spring_course_prKanan.entity.UserModel;

import org.springframework.ui.Model;

@Controller
@RequestMapping(path="/user")

public class UserController {
@GetMapping(path="/open-our-login")
public String showOutLogin() {
	return "out-login";
}
@GetMapping(path="/create-admin-account")
public String showCreateAdminAccount (Model model){
	AdminModel admin=new AdminModel();
	model.addAttribute("admin",admin);
	
	return "create-admin-account";
}
@GetMapping(path="/forget-pass")
	public String showForgetPass() {
		return "out-login";
	}

@PostMapping(path="/forget-pass-confirm")
public String ForgetPassConfirm(@ModelAttribute(name="user")UserModel u ) {
	PasswordRecover recover=new PasswordRecover();
	recover.setUsername(u.getUsername);
	String code="";
	Random r=new Random();
	for(int i=0;i<4;i++) {
		code+=r.nextInt(10);
	}
	recover.setCode(code);
	String username=SecurityContextHolder.getContext().getAuthentication().getName();
	return "out-login";
}

}
