package com.example.demo.RBcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.RBmodel.model;
import com.example.demo.RBservice.ServiceImpl;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class controller {

	
	
	@Autowired
	ServiceImpl service;
	
	@RequestMapping("/")
	public String tp()
	{
		return "HELLOOOOOOOOOOOO";
		
	}
	
	
	
	//return type ResponseEntity returns JSON data
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody model m)
	{
		int id = service.saveEmp(m);
		
		
			return new ResponseEntity<String>(
					"Employee" + id + "saved", 
					HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<model>> getAll()
	{
		List<model> list = service.getAll();
		
		return new ResponseEntity<List<model>>(list,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<model> get(@PathVariable int id)
	{
		model m = service.getEmp(id);
		return new ResponseEntity<model>(m,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{	
		service.deleteEmp(id);
		
		//String msg = "DELETED RECORD with id:"+ id;
		
		return new ResponseEntity<String>("deleted id: "+id,HttpStatus.OK);
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(
			@PathVariable int id,
			@RequestBody model m)
	{
		
		model updated = service.getEmp(id);
		updated.setEmpname(m.getEmpname());
		updated.setEmpdept(m.getEmpdept());
		updated.setEmpsal(m.getEmpsal());
		
		service.saveEmp(updated);
		
		
			return new ResponseEntity<String>(
					"Employee " + id + "Updated", 
					HttpStatus.OK);
	}
	
	
	
	
}
