package com.example.spring_course_prKanan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_course_prKanan.entity.AdminModel;
import com.example.spring_course_prKanan.repository.UserRepository;

@Service

public class UserService {
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
@Autowired
private UserRepository userRepository;
public void add(AdminModel admin) {
	
	userRepository.add(admin);
	String rawPassword=admin.getPassword();
	String encodedPassword=encoder.encode(rawPassword);
	encodedPasswords="{bcrypt}"+encodedPassword;
	admin.setPassword(encodedPassword);
	userRepository.add(admin);
	
}
}
