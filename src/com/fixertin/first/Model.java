package com.fixertin.first;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Model {
	
	
	private String open = "<li>", end = "</li>";
	private DBConnect connect;
	
	public Data data = new Data();
	
	public ArrayList<String> getSkills(){
		return data.getSkills();
	}
	public ArrayList<String> getGoals(){
		return data.getGoals();
	}
	public ArrayList<String> getInterests(){
		return data.getInterests();
	}
	public ArrayList<String> getTempList(String table, String user){
		return data.getTempList(table, user);
	}
	public boolean getFailed(){
		return data.getFailed();
	}
	
	
	
	public Model(){
		connect = new DBConnect();
		connect.getData(data.getSkills(), "ALL_SKILLS");
		connect.getData(data.getGoals(), "ALL_GOALS");
		connect.getData(data.getInterests(), "ALL_INTERESTS");
		//System.out.println(skills);
		

	}
	
	public void removeData(ArrayList<String> list){
		list.clear();
	}
	
	public String getUser(){
		return WebsiteServlet.username;
	}
	
	public String getSpecificElementData(String user, String table, int index){
		connect.getDataFromSpecificUser(data.getTempList(table, user), table, user);	
		return "<li>"+data.getTempList(table, user).get(index)+"</li>";
	}
	
	public String getSpecificElementDataTable(String user, String table, int index){
		connect.getDataFromSpecificUser(data.getTempList(table, user), table, user);	
		return "<td>"+data.getTempList(table, user).get(index)+"</td>";
	}
	
	public int getTempSize(String user, String table){
		ArrayList<String> tempList = new ArrayList<String>();
		connect.getDataFromSpecificUser(tempList, table, user);	
		return tempList.size();
	}
	
	public int getSize(ArrayList<String> list){
		return list.size();
	}
	
	public void addElement(ArrayList<String> list, String skill, String open, String end){
		list.add(open + skill + end);
	}
	
	public String getElement(ArrayList<String> list, int i){
		return "<li>"+list.get(i)+"</li>";
	}
	
}
