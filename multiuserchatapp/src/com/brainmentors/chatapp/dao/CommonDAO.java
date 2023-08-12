package com.brainmentors.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import static com.brainmentors.chatapp.utils.ConfigReader.getValue;


public interface CommonDAO{
public static Connection createConnection() throws ClassNotFoundException, SQLException {
//	Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName(getValue("DRIVER"));
//	final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/chatdb";
	final String CONNECTION_STRING = getValue("CONNECTION_URL");
//	final String USER_ID ="root";
//	final String  PASSWORD="Revolution@1729";
	final String USER_ID = getValue("USERID");
	final String  PASSWORD= getValue("PASSWORD");
	Connection con= DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	if(con!=null) {
		System.out.println("connection created...");
	//con.close();
  }
 return con;
}
/*public static void main (String[] args) throws ClassNotFoundException, SQLException {
	CommonDAO commonDAO = new CommonDAO();
	commonDAO.createConnection();*/ //for testing the connection
      
}
