package com.isnit.rest.webservices.restfulwebservices.versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isnit.rest.webservices.restfulwebservices.versioning.model.Name;
import com.isnit.rest.webservices.restfulwebservices.versioning.model.PersonV1;
import com.isnit.rest.webservices.restfulwebservices.versioning.model.PersonV2;

@RestController
public class PersonController {
	//1st Way for versioning  URI
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Nirdesh Mohan v1");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2("Nirdesh Mohan v2");
	}
	
	@GetMapping("v3/person")
	public Name name() {
		return new Name("Nirdesh V3", "Mohan V3");
	}
	
	//2nd Way for versioning PARAM
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Nirdesh Mohan v1");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2("Nirdesh Mohan v2");
	}
	
	@GetMapping(value="/person/param", params="version=3")
	public Name paramV3() {
		return new Name("Nirdesh V3", "Mohan V3");
	}
	
	
	//3rd Way for versioning  HEADER
	@GetMapping(value="/person/header", headers="X-API_VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Nirdesh Mohan v1");
	}
	
	@GetMapping(value="/person/header", headers="X-API_VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2("Nirdesh Mohan v2");
	}
	
	@GetMapping(value="/person/header", headers="X-API_VERSION=3")
	public Name headerV3() {
		return new Name("Nirdesh V3", "Mohan V3");
	}
	
	//4th Way for versioning PRODUCERS (content negotiation or accept header)
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Nirdesh Mohan v1");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2("Nirdesh Mohan v2");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v3+json")
	public Name producesV3() {
		return new Name("Nirdesh V3", "Mohan V3");
	}
}
