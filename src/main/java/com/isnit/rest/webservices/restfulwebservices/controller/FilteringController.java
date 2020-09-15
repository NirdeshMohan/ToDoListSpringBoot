package com.isnit.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isnit.rest.webservices.restfulwebservices.model.UserFilterBean;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public UserFilterBean getUserFilteringData() {
		return new UserFilterBean("F1","F2","F3","F4");
	}
	
	@GetMapping("/filtering-list")
	public List<UserFilterBean> getUserListFilteringData() {
		return Arrays.asList(new UserFilterBean("F1","F2","F3","F4"),
				new UserFilterBean("F11","F22","F33","F44"),
				new UserFilterBean("F111","F222","F333","F444")); 
	}
}
