package com.fixertin.first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditInterestsServlet")
public class EditInterestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBConnect connect;
    
	public Data data;
       
    public EditInterestsServlet() {
        super();
        data = new Data();
        connect = new DBConnect();
        connect.getUsers(data.getUsers(), "USERS");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newInput = request.getParameter("newSkill");
		String index = request.getParameter("removeSkill");
		int i;
		System.out.println(index+" "+data.getTempList("ALL_INTERESTS", WebsiteServlet.username).size());
		if(newInput != "")
			connect.addSkill(newInput, "ALL_INTERESTS", WebsiteServlet.username);
		if(index != ""){
			i = Integer.parseInt(index) - 1;
			connect.removeSkill(data.getTempElement(WebsiteServlet.username, "ALL_INTERESTS", i), "ALL_INTERESTS");
		}
		data.clearTempList();
		response.sendRedirect("UserPage.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
