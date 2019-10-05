package com.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.dbconnection.Dbconnection;

import com.pojo.UserPojo;

public class UserLoginValidate {
	public static List<UserPojo> getUsers(String email,String password){		
		List<UserPojo>list = new ArrayList<>();
		//take a list to store the values which are in db
		 try{  
			Connection con=Dbconnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  				
				UserPojo pObject=new UserPojo(); 
				pObject.setUserCode(rs.getInt(1));  
				pObject.setUserName(rs.getString(2));
				pObject.setUserSurname(rs.getString(2));
				pObject.setBirthday(rs.getString(2));//if the values exist in db then											
				pObject.setEmail(rs.getString(4));
				pObject.setPassword(rs.getString(3));     // set them to setters and getters and them to list and return the list finally

				list.add(pObject);
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  		  
		return list;  //returns the list		
	}
}