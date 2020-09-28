package com.Webwhatsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpSession;

import com.Webwhatsapp.ENTITY.whatsappuser;
import com.Webwhatsapp.service.WhatsappwebServiceInterface;

import Webwhatsapp.Utility.Servicefactory;

/**
 * Servlet implementation class Signinservlet
 */
public class Signinservlet extends HttpServlet {
	

	

	WhatsappwebServiceInterface fs=null;
	
	
	public Signinservlet()
	{
		 fs=Servicefactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		whatsappuser fe=new whatsappuser();
		fe.setName(name);
		fe.setPassword(password);
		
		
		
		boolean i=fs.loginProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			
			out.println("welcome "+name+"   <a href=TimeLine>timeline</a>   <a href=friendlist>friendlist</a>");
	
		}
		else {
			out.println("Invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/signin.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
