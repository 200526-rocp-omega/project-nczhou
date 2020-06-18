package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.authorization.AuthService;
import com.revature.controllers.UserController;
import com.revature.exceptions.AuthorizationException;
import com.revature.exceptions.NotLoggedInException;
import com.revature.templates.MessageTemplate;

public class FrontController extends HttpServlet {

	    /**
	 * 
	 */
	private static final long serialVersionUID = -4854248294011883310L;
    private static final UserController userController;
	private static final ObjectMapper om = new ObjectMapper();
		
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res)
		         throws ServletException, IOException {
			res.setContentType("application/json");
	  final String URI = req.getRequestURI().replace("/SerletDemo","").replaceFirst("/", "");
	  			
	  String[] portions = URI.split("/");
	  
//	  System.out.println(Arrays.toString(portions));
	  
	    	try {
	    		switch(portions[0]) {
//	  old command  		switch(URI) {
	    		 case "users":
	    			 if(portions.length > 1) {  //could also use lenght == 2
	    				 // Delegate to a Controller method to handle obtaining a User by ID
	    				 int id = Integer.parseInt(portion[1]);
	    				 AuthService.guard(req.getSession(false),id,"Employee", "Admin");
	    				 
	    				 User u = userController.findUserById(req.getSession(false), id);
	    				 res.setStatus(200);
	    				 res.getWriter().println(om.writeValueAsString(u));
	    				 } 
	    			 else {
	    				 // Delegate to a Controller method to handle obtaining all users
	    				 AuthService.guard(req.getSession(false),"Employee", "Admin");
	    				 List<User> all = userController.findAllUsers(req.getSession(false));  //no valid request then don't create session
	    				 res.setStatus(200);
	    				 res.getWriter().println(om.writeValueAsString(all));
	    			 }
	    			 
	    		 break;
	    		}
	    	} catch(AuthorizationException e) {
	    		   res.setStatus(401);
	    		   MessageTemplate message = new MessageTemplate("The Imcoming token has expired");
	    		   res.getWriter().println(om.writeValueAsString(message));
	    	}
		}
		
	
	
	    @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res)
		 		throws ServletException, IOException {
	    	res.setContentType("application/json");
	    	
	    	final String URI = req.getRequestURI().replace("/ServletDemo","").replaceFirst("/","");
	    	
	    	String[] portions = URI.split("/");
	    	
	    	
	    	System.out.println(req);
	    	
		}
	    
	    
	    
	    
	    
	    
}
