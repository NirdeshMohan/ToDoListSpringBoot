package com.isnit.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.isnit.rest.webservices.restfulwebservices.model.User;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	static{
		users.add(new User(1, "Nirdesh", "Mohan", new Date()));
		users.add(new User(2, "Ishaan", "Sharma", new Date()));
		users.add(new User(3, "Nitish", "Sharma", new Date()));
	};
	
	public static List<User> findAll(){
		return users;
	}

	public User findOne(int id){
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user){
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User delete(int id){
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User user = it.next();
			if(user.getId() == id) {
				it.remove();
				return user;
			}
		}
		return null;
	}
}
