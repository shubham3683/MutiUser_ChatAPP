package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBuffer;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	/**
	 * 
	 */
	private void doLogin() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
				UserDTO userDTO = new UserDTO(userid, password);
				try{
					String message="";
					if(userDAO.isLogin(userDTO)) {
						message="welcome"+userid;
						UserInfo.USER_NAME=userid;
					JOptionPane.showMessageDialog(this,message);
					setVisible(false);
					dispose();
					DashBoard dashBoard=new DashBoard(message);
					dashBoard.setVisible(true);
				}
					else {
						message= "invalid userid or password";
						JOptionPane.showMessageDialog(this,message);
					}
					
				}
				catch(ClassNotFoundException | SQLException ex){
										ex.printStackTrace();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
	}
				
	private void register() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
		int result = userDAO.add(userDTO);
		if(result>0) 
			//System.out.println("record added..");
			JOptionPane.showMessageDialog(this,"Registered successfully");
		else 
			//System.out.println("record not added ...");
		JOptionPane.showMessageDialog(this,"Registration failed");
		}
		catch(ClassNotFoundException | SQLException ex){
			System.out.println("DB issue");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some generic exception raised");
			ex.printStackTrace();
		}
		System.out.println("userid" +userid+"Password"+password);
	}

	public UserScreen() {
		setForeground(new Color(255, 255, 255));
		setBackground(Color.WHITE);
		setTitle("Login");
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(264, 34, 127, 43);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(359, 117, 272, 39);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel UserIdlbl = new JLabel("UserId");
		UserIdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UserIdlbl.setBounds(117, 134, 63, 22);
		getContentPane().add(UserIdlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdlbl.setBounds(117, 215, 100, 29);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(359, 209, 272, 35);
		getContentPane().add(passwordField);
		
		JButton Loginbt = new JButton("Login");
		Loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		Loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Loginbt.setBounds(199, 308, 100, 29);
		getContentPane().add(Loginbt);
		
		JButton Registerbt = new JButton("Register");
		Registerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		Registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Registerbt.setBounds(453, 308, 100, 29);
		getContentPane().add(Registerbt);
		setSize(774, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
