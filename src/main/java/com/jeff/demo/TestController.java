package com.jeff.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	DumbObjectRepository repo;
	
	@RequestMapping("/sayhello")
	public String sayHello() {
		return "Hello!";
	}
	
//	@RequestMapping("/save")
//	public String saveObject() {
//		
//		
//	}
	
	@RequestMapping("/object")
	public DumbObject getObject() {
		DumbObject object =new DumbObject();
		object.setName("Steve");
		return object;
	}
	
	//Path Variable
	@RequestMapping("/object/{name}")
	public DumbObject getObjectWithName(@PathVariable String name) {
		DumbObject object =new DumbObject();
		object.setName(name);
		return object;
		
	}
	
	//Post Object
	@RequestMapping("/createObject")
	public DumbObject postObject(@RequestBody DumbObject object) {
		return repo.save(object);
	}
	
	@RequestMapping("/badrequest")
	public ResponseEntity<?> getBadRequest() {
		return new ResponseEntity<>("Access Denied",HttpStatus.FORBIDDEN);
	}
}
