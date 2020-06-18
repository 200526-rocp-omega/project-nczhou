package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.templates.LoginTemplate;

public class LoginServlet extends HttpServlet {

	private static final ObjectMapper om = new ObjectMapper();
	
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	       throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	       throws ServletException, IOException {
        
		BufferedReader reader = req.getReader();
        
	//	reader
		
        StringBuiler sb = new StringBuilder();
        
        String line;
        while((line=reader.readLine()) != null) {
        	sb.append(line);
        }
/*
 *  the (line= reader.readline  part obtains the value for a single line
 *frome the body of the request and stores it into the line variable
 *
 *then the !=null part compares the value of the string to nul
 *
 *if the readline method is null that means we are at the end
 */
        
        String body = sb.toString();
        LoginTemplate lt = om.readValue(body,LoginTemplate.class);
        
        User u = service.login(lt);
        
        if(u == null) {
//        	login failed
        	res.setStatus(400);
        	PrintWriter writer = res.getWriter();
        	
        	writer.println("Username or Password was incorrect");
        	return;
        }
        
        
        HttpSession session = req.getSession();
        
        User current =(User) session.getAtribute("currentUser");
        
        //Already logged in
        if(current !=null) {
        	
        		res.setStatus(400);
        		res.getWriter().println("You are already logged in as user " + current.getUsername());
        }
        
        
        BufferedReader reader =req.getReader();
        
        StringBuilder sb = new StringBuilder();
        
        session.setAttribute("currentUser", u);
        
				res.setStatus(200);
				
				writer.println(om.writerValueAsString(u));
	}
}
