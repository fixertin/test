package com.fixertin.first;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;




public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int modifiedRows;
	
	private int x;
	
	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/website","root","Thunderofdark1");
			st = con.createStatement();
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	private int getNumberOfRows(String table){
		try{
			String query = "SELECT COUNT(*) FROM "+table+";";
			rs = st.executeQuery(query);
			rs.next();
			System.out.println(rs.getInt("COUNT(*)"));
			return rs.getInt("COUNT(*)");
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
	
	public void getData(ArrayList<String> list, String table){
		try{
			String query = "SELECT * FROM "+table;
			rs = st.executeQuery(query);
			while(rs.next()){
				String skill = rs.getString("SKILL");
				list.add(skill);		
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void getDataFromSpecificUser(ArrayList<String> list, String table, String user){
		try{
			String query = "SELECT * FROM "+table+" WHERE USER='"+user+"'";
			rs = st.executeQuery(query);
			while(rs.next()){
				String skill = rs.getString("SKILL");
				list.add(skill);		
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void addSkill(String skill, String table, String user){
		try{
			x = getNumberOfRows(table);
			x+=1;
			String query = "INSERT INTO "+table+"(ID, SKILL, USER) VALUES("+x+",'"+skill+"', '"+user+"');";
			modifiedRows = st.executeUpdate(query);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void removeSkill(String skill, String table){
		try{
			String query = "DELETE FROM "+table+" WHERE SKILL='"+skill+"';";
			modifiedRows = st.executeUpdate(query);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void addUser(HashMap<String, String> map, String username, String password, String age, String phone, String job, String company, String email){
		try{
			String query = "INSERT INTO USERS(USERNAME, PASSWORDS, AGE, PHONE_NUMBER, CURRENT_JOB, COMPANY_SCHOOL, EMAIL) VALUES(?,?,?,?,?,?,?)";
			//rs = st.executeQuery(query);
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, age);
			pst.setString(4, phone);
			pst.setString(5, job);
			pst.setString(6, company);
			pst.setString(7, email);

			pst.execute();
			map.put(username, password);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public String getUserInfo(String user, String column){
		try{
			String query = "SELECT "+column+" FROM USERS WHERE USERNAME='"+user+"';";
			rs = st.executeQuery(query);
			rs.next();
			return rs.getString(column);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public void getUsers(HashMap<String, String> map, String table){
		try{
			String query = "SELECT * FROM "+table;
			rs = st.executeQuery(query);
			while(rs.next()){
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORDS");
				map.put(username, password);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
