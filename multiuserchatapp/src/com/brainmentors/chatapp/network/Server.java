package com.brainmentors.chatapp.network;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utils.ConfigReader;
public class Server  {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers= new ArrayList<>();
	public Server() throws IOException {
		int PORT= Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket= new ServerSocket(PORT);
		System.out.println("Server started and waiting client connection..");
		handleClientRequest();
	}
	
	public void handleClientRequest() throws IOException{
		while(true) {
			Socket clientSocket= serverSocket.accept(); //handshaking
			//per client per thread
			ServerWorker serverWorker= new ServerWorker(clientSocket,this);	
			workers.add(serverWorker);
			serverWorker.start();
		}
		
		
	}
	
	/*
	public Server() throws IOException{
		
		int PORT= Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket= new ServerSocket(PORT);
		System.out.println("Server started and waiting client connection..");
		Socket socket=  serverSocket.accept();
		System.out.println("client joins the server");
	
		InputStream in= socket.getInputStream();
		byte[] arr= in.readAllBytes();
		
	String str= new String(arr);
    System.out.println("mess rec "+str);
        in.close();
		socket.close();
		
	}
   */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Server server= new Server();
	}

}
