/**
 * 
 */
package com.springlearning.rest.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springlearning.rest.restfulwebservices.bean.User;

/**
 * @author Mir
 *
 */

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"Mir", new Date()));
		users.add(new User(2,"Neha", new Date()));
		users.add(new User(3,"TinkuJiya", new Date()));
	}
	
	/**
	 * Returns the lost of all users
	 * @return
	 */
	public List<User> finaAll(){
		return users;
	}
	
	/**
	 * Saves a particular users
	 * @param user
	 * @return
	 */
	public User save(User user) {
		
		if(null==user.getId()) {
			user.setId(++usersCount);
		}
		
		users.add(user);
		return user;
	}
	
	/**
	 * Returns a particular user
	 * @param id
	 * @return
	 */
	public User findOne(int id) {
		for(User  user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * This method deletes a user 
	 * @param id
	 * @return
	 */
	public User deleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
