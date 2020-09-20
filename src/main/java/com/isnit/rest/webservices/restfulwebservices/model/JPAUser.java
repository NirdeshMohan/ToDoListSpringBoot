package com.isnit.rest.webservices.restfulwebservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User Details")
@Entity
public class JPAUser { 
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="First Name should have atleast 2 characters")
	private String first;
	
	@Size(min=2, message="Last Name should have atleast 2 characters")
	private String last;
	
	@Past
	@ApiModelProperty(notes="Birthday should be in past")
	private Date dob;
	
	@OneToMany(mappedBy = "jpaUser")
	private List<Post> posts;
	
	public JPAUser(Integer id, String first, String last, Date dob) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first=" + first + ", last=" + last + ", dob=" + dob + "]";
	}
	public JPAUser() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
