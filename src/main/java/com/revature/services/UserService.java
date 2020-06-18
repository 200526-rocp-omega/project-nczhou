package com.revature.services;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.models.User;
import com.revature.templates.LoginTemplate;


public class UserService {

	
	
	public User login(LoginTemplate lt) {
		
		User userFromDB= findByUsername(lt.getUsername());
		
//		if username was incorrect
		if(userFromDB == null) {
			
			return null
		}
		
		if(userFromDB.getPassword().equals(lt.getPassword())) {
			 return userFromDB
		}
//		if username right but password not right
		return null
	}
	public void logout(HttpSession session) {
//		were never logged in to service
		if(session ==null || session.getAttribute("currentUser") == null) {
			
		}
	}
}
