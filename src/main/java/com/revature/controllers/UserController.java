package com.revature.controllers;


import javax.servlet.http.HttpSession;

import com.revature.exceptions.NotLoggedInException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {

		private final UserService userService = new UserService();
		
		public boolean logout(HttpSession session) {
			try {
				 userService.logout(session);
	 			} catch(NotLoggedInException e) {
	 				return false;
	 			}
			return true;
		}
		public User findUserById(Httpsession session, int id) {
			if (session == null || session.getAttribute("currentUser") == null) {
				throw new NotLoggedInException();
			}
			
			
			
		}
		
		public List<User> findAllUser(HttpSession session) {
			
		}
}
