package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	
	// JPA/Hibernate Database 
	// for now its UserDaoService and using  a static list 
	private static List<User> users = new ArrayList<>(); 
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "adam", LocalDate.now().minusYears(30)) );
		users.add(new User(++usersCount, "eve", LocalDate.now().minusYears(25)) );
		users.add(new User(++usersCount, "jim", LocalDate.now().minusYears(20)) );
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User retriveUser(Integer userId) {
		return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
	}
	
	
	public void deleteById(Integer userId) {
		 User userFound = users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
		 users.remove(userFound);
	}
	
	public User save(User user){
		user.setId(++usersCount);
		users.add(user);
		return user;		
	}

}
