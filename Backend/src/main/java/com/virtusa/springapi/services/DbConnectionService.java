package com.virtusa.springapi.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionService {
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://b84baca87e0006:9ce21d56@us-cdbr-east-02.cleardb.com/heroku_f4848eecf60dc7c?reconnect=true", "b84baca87e0006", "9ce21d56");
		return con;
	}
	
	public static void closeConnection(Connection con) throws Exception{
		con.close();
	}

}
