package com.example.spring_core.Kanan;

public class Computer {

	    private Employee employee;

	    public Computer(Employee employee) {
	        this.employee = employee;
	    }
	    public Employee getEmployee() {
	        return employee;
	    }
	    public void setEmployee(Employee employee) {
	        this.employee = employee;
	    }
	    @Override
	    public String toString() {
	        return "Computer [employee=" + employee + "]";
	    }
	}

