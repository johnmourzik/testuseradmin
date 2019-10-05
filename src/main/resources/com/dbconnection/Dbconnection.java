package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	static final String URL="jdbc:mysql://localhost:3306/";
	static final String DATABASE_NAME="travelagency";
	static final String USERNAME="root";
	static final String PASSWORD="root";
	static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection() throws SQLException{ //making a static connection,shares to all classes
		Connection con=null; // creating connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL+DATABASE_NAME + PARAMS,USERNAME,PASSWORD);
						
		} catch (Exception e) {
			con.close();
			//throws an error if at all its unable to create an connection
			System.out.println(e);
		}	
		return con; // we return the connection and we can get the connection wherever needed.
	}		
}
