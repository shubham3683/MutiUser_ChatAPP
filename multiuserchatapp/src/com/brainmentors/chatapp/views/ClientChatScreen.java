package com.brainmentors.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.network.Client;
import com.brainmentors.chatapp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private JTextArea textArea ;
    private Client client;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
					try {
						ClientChatScreen screen = new ClientChatScreen();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
		
	}
	private void sendIt() {
		String message= textField.getText();
		
			try {
				client.sendMessage(UserInfo.USER_NAME+" - " + message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}


	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea= new JTextArea();
		client= new Client(textArea);
		
		setTitle("ChitChat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(20, 10, 557, 200);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 10, 587, 218);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(18, 238, 432, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendIt = new JButton("Send Messages");
		sendIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendIt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sendIt.setBounds(459, 251, 151, 34);
		contentPane.add(sendIt);
		setVisible(true);
	}
}
