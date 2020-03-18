package com.vicky.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
public static Connection getConnection(){
		
		try{
			 Class.forName("com.mysql.jdbc.Driver");
		      return DriverManager.getConnection("jdbc:mysql://localhost:3306/mahesh_gym", "root", "MaheshGym@2019");
		 	}
			catch(Exception e){
				
			}
		return null;
	}

}
