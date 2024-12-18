package com.example.spring_core.Kanan;

public class Person{
	 private int id;
	    private String name;
	    private int age;
	    private double salary;

	    
	    public void Person() {
	        this.id = 1;
	        this.name = "Cristiano";
	        this.age = 39;
	        this.salary =700000;
	    }

	   
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
}
