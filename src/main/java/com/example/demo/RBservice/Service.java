package com.example.demo.RBservice;

import java.util.List;

import com.example.demo.RBmodel.model;

public interface Service {

	List<model> getAll();
	model getEmp(int id);
	void deleteEmp(int id);
	int updateEmp(model m);
	int saveEmp(model m);

}
