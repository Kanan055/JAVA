package com.example.spring_course_prKanan.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentModel {
	
	    private Long id;
	    private String name;
	    private String username;
	    private String password;
	    private boolean enabled;

	   
	    public StudentModel() {}

	    public StudentModel(Long id, String name, String username, String password, boolean enabled) {
	        this.id = id;
	        this.name = name;
	        this.username = username;
	        this.password = password;
	        this.enabled = enabled;
	    }

	   
	   
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }
	}


