package com.isnit.rest.webservices.restfulwebservices.versioning.model;

public class PersonV2 {
	private String name;

	public PersonV2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
