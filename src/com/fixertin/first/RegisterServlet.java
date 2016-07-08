package com.fixertin.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Data data;
       
    public RegisterServlet() {
        super();
        data = new Data();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String company = request.getParameter("company");
		String email = request.getParameter("email");

		
		if(!data.getUsers().containsKey(username)){
			data.addElementUser(username, password, age, phone, job, company, email);
			response.sendRedirect("AdminLoginPage.jsp?invalid=false");
		}else
			response.sendRedirect("RegisterPage.jsp?invalid=true");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
