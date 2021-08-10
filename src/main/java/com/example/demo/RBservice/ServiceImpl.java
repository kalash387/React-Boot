package com.example.demo.RBservice;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.CustomExceptions.NotFoundException;
import com.example.demo.RBdao.dao;
import com.example.demo.RBmodel.model;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service 
{

	@Autowired
	private dao repo;
	
	@Override
	public List<model> getAll() {
		// TODO Auto-generated method stub
		
		List<model> list = repo.findAll();
		return list;
	}

	@Override
	public model getEmp(int id) {
		// TODO Auto-generated method stub
	
		Optional<model> opt = repo.findById(id);
		model m = opt.orElseThrow(
				()-> new NotFoundException("Employee does not exist")
				);
		
		return m;
	}

	@Override
	public void deleteEmp(int id) {
	
		
		//Below line checks if this id exists by calling above getEmp method
		model m = getEmp(id);
		
		repo.deleteById(id);
		
		
	}

	

	@Override
	public int saveEmp(model m) {

		int j = repo.save(m).getId();
		return j;
	}

	@Override
	public int updateEmp(model m) 
	{
		
		int i = repo.save(m).getId();
	
		return i;
	}

	
	
	
}
