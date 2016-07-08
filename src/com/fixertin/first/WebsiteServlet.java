package com.fixertin.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WebsiteServlet")
public class WebsiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public int tempIndex = 0;
	public static String username;
	
	
	private DBConnect connect;
     
	public Data data;
	
    public WebsiteServlet() {
        super();
        data = new Data();
        connect = new DBConnect();
        connect.getUsers(data.getUsers(), "USERS");
    }
    
    public boolean checkIfValid(String input){
    	boolean b = false;
    	for(int i=0; i<data.getUsers().size(); i++){
    		if(data.getUsers().containsKey(input)){
    			b = true;
    		}
    	}
    	if(b){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String getUsernameFromCookie(HttpServletRequest request){
		for(Cookie cookie : request.getCookies())
			if(cookie.getName().equals("username"))
				return cookie.getValue();
		return null;
	}
    
    public boolean checkPassword(String password, String username){
    	if(data.getUsers().get(username).equalsIgnoreCase(password))
    		return true;
    	else
    		return false;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		username = request.getParameter("username");
		String password = request.getParameter("password");		
		System.out.println(username+" "+password+" "+tempIndex);
		System.out.println(data.getUsers());
		System.out.println(data.getSkills());
		if(checkIfValid(username)){
			
			if(checkPassword(password, username)){
				response.sendRedirect("UserPage.jsp");
				Cookie cookie = new Cookie("username", username);
				response.addCookie(cookie);
			}else{
				response.sendRedirect("AdminLoginPage.jsp?invalid=true");
			}
		}else{
			response.sendRedirect("AdminLoginPage.jsp?invalid=true");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
