package com.fixertin.first;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
	public ArrayList<String> skills = new ArrayList<String>();
	public ArrayList<String> goals = new ArrayList<String>();
	public ArrayList<String> interests = new ArrayList<String>();
	//public ArrayList<String> tempList = new ArrayList<String>();
	
	public boolean failed;
	
	public HashMap<String, String> users = new HashMap<String, String>();

	public DBConnect connect;
	
	public Data(){
		connect = new DBConnect();
	}
	
	public void clearTempList(){
		//tempList.clear();
	}
	
	public int getTempSize(String user, String table){
		ArrayList<String> tempList = new ArrayList<String>();
		connect.getDataFromSpecificUser(tempList, table, user);	
		return tempList.size();
	}
	
	public String getTempElement(String user, String table, int index){
		ArrayList<String> tempList = new ArrayList<String>();
		connect.getDataFromSpecificUser(tempList, table, user);	
		return tempList.get(index);
	}
	
	public void addElementUser(String username, String password, String age, String phone, String job, String company, String email){
		if(!users.containsKey(username)){
			connect.addUser(users, username, password, age, phone, job, company, email);
		}
	}
	public void removeElement(int index, ArrayList<String> list){
		list.remove(index);
	}
	
	public HashMap<String, String> getUsers(){
		return users;
	}
	
	public ArrayList<String> getTempList(String table, String user){
		ArrayList<String> tempList = new ArrayList<String>();
		connect.getDataFromSpecificUser(tempList, table, user);
		return tempList;
	}
	
	public boolean getFailed(){
		return failed;
	}
	
	public void setFailed(Boolean b){
		failed = b;
	}
	
	public ArrayList<String> getSkills() {
		return skills;
	}
	public ArrayList<String> getGoals() {
		return goals;
	}
	public ArrayList<String> getInterests() {
		return interests;
	}
}
