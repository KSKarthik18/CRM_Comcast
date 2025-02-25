package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database_utility {
	Connection con=null;
	public void getbdconnection(String URl, String Username, String Password) {
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(URl, Username, Password);
		} catch (Exception e) {
		}
	}
	
	public void getbdconnection() {
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		} catch (Exception e) {
		}
	}

	public void closeconnection() throws Exception {
		try {
			con.close();	
		} catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String Query) {
		ResultSet result=null;
		try {
			Statement state = con.createStatement();
			result = state.executeQuery(Query);
		} catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String Query) {
		int result= 0;
		try {
			Statement state = con.createStatement();
			result=state.executeUpdate(Query);
		} catch (Exception e) {
		}
		return result;
	}
}
