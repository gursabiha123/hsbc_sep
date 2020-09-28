package com.Webwhatsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Webwhatsapp.ENTITY.whatsappuser;
import com.Webwhatsapp.service.WhatsappwebServiceInterface;

import Webwhatsapp.Utility.Servicefactory;



public class friendlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name=request.getParameter("username");
		
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		System.out.println(name);//prints on console
		
		whatsappuser fe=new whatsappuser();
		fe.setName(name);
		
		WhatsappwebServiceInterface fs=Servicefactory.createObject("adminservice");
		List<whatsappuser> i=fs.friendProfile(fe);
		//facebookServiceInterface fs=Servicefactory.createObject("adminservice");
		//boolean i=fs.loginProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");//prints on webpages
		
		if(i.size()>0) {
			for(whatsappuser ff:i) {
				out.println(ff.getName());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}
 

}
