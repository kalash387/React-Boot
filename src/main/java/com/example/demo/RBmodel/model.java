package com.example.demo.RBmodel;


import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




//@Document(collection = "DB1")

@Entity
@Table(name = "reactboot")
public class model{
	
	
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
	private String Empname;
	
	private double Empsal;
	
	private String Empdept;
	
	
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public double getEmpsal() {
		return Empsal;
	}
	public void setEmpsal(double empsal) {
		Empsal = empsal;
	}
	public String getEmpdept() {
		return Empdept;
	}
	public void setEmpdept(String empdept) {
		Empdept = empdept;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
