package com.fixertin.first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditSkillsServlet")
public class EditSkillsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBConnect connect;
    
	public Data data;
       
    public EditSkillsServlet() {
        super();
        data = new Data();
        connect = new DBConnect();
        connect.getUsers(data.getUsers(), "USERS");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newInput = request.getParameter("newSkill");
		String index = request.getParameter("removeSkill");
		int i;
		System.out.println(index+" "+data.getTempSize(WebsiteServlet.username, "ALL_SKILLS"));
		if(newInput != "")
			connect.addSkill(newInput, "ALL_SKILLS", WebsiteServlet.username);
		if(index != ""){
			i = Integer.parseInt(index) - 1;
			connect.removeSkill(data.getTempElement(WebsiteServlet.username, "All_skills", i), "ALL_SKILLS");
		}
		data.clearTempList();
		response.sendRedirect("UserPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
