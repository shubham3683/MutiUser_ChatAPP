package com.brainmentors.chatapp.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UserView extends JFrame{
	int counter=0;
	public UserView() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("login");
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel welcome = new JLabel("login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		
		container.setLayout(null);
		welcome.setBounds(100, 70, 200, 50);
		container.add(welcome);
	    JButton button = new JButton("count");
	    button.setBounds(100,150,100,100);
	    container.add(button);
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		counter++;
	    		welcome.setText("count "+ counter);
	    	}
	    });
	}
	
public static void main(String[] args) {
	UserView userview= new UserView();
}
}

