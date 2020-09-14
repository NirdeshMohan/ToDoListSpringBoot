package com.isnit.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET, path="/hello-world")  OR
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello To Do World!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("From Bean.");
	}
	
	@GetMapping(path="/hello-world-bean/pathvariable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello To Do World, %s", name));
	}

}
