package com.Webwhatsapp.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Webwhatsapp.ENTITY.whatsappuser;
import com.Webwhatsapp.service.WhatsappwebServiceInterface;

import Webwhatsapp.Utility.Servicefactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {

	

		//public class RegistrationServlet extends HttpServlet {
			
			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name=request.getParameter("name");
				String password=request.getParameter("password");
				String email=request.getParameter("email");
				String address=request.getParameter("address");
				
				whatsappuser we=new whatsappuser();
				we.setName(name);
				we.setAddress(address);
				we.setEmail(email);
				we.setPassword(password);
				
				
				
				WhatsappwebServiceInterface fs=Servicefactory.createObject("adminservice");
				int i=fs.createProfile(we);
				
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html><body>");
				if(i>0) {
					
					out.println("Registration successful   <a href=signin.html>Contunue...</a>");
						
					out.println("Your Name is "+name);
					out.println("<br>Your Password is "+password);
					
				}
				out.println("</body></html>");
			}


}
