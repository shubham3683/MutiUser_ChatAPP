package com.brainmentors.chatapp.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.Encryption;
import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;
import com.mysql.cj.xdevapi.PreparableStatement;
//CRUD
public class UserDAO  {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception{
		Connection con= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		final String SQL ="select userid from users where userid=? and password=?";
		try {
			con=CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,userDTO.getUserid());
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		
	}
	
	
	
	
	
	
	
	
// public int add(String userid, String password, byte age, String city, String phone,String email);	
public int add(UserDTO userDTO)throws SQLException,ClassNotFoundException, Exception {
	System.out.println("rec "+userDTO.getUserid()+"" + userDTO.getPassword());
	Connection connection=null;
	Statement stmt=null;//query
	try {
	connection = CommonDAO.createConnection(); // step 1 create connection
	// step 2 we do a query
	stmt= connection.createStatement();
	// insert into users (userid, password) values ('ram','ram123');
int record=	stmt.executeUpdate("insert into users(userid,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt( new String(userDTO.getPassword()))+"')");
return record;
	}
	
finally {
	if(stmt!=null)
stmt.close();
	if(connection!=null)
connection.close();
}	
	
	
}
}
