package com.example.spring_core.Kanan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee2 {
int id;
String name;
@Autowired
Car car;
public Employee2() {
	name="Kanan";
	id=7;
}
}
