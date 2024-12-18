package com.example.spring_course_prKanan.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {
private String name;
private String username;
private String password;
private int enabled;
}
