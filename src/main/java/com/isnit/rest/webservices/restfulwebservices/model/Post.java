package com.isnit.rest.webservices.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private JPAUser jpaUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public JPAUser getJpaUser() {
		return jpaUser;
	}

	public void setJpaUser(JPAUser jpaUser) {
		this.jpaUser = jpaUser;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", jpaUser=" + jpaUser + "]";
	}
}
