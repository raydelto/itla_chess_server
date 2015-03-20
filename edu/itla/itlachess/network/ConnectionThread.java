package edu.itla.itlachess.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import edu.itla.itlachess.users.UserHandler;

public class ConnectionThread extends Thread{
	
	private Socket client;
	private PrintWriter writer;
	private BufferedReader reader;
	private boolean connected;
	private UserHandler userHandler;
	
	public Socket getClient() {
		return client;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public BufferedReader getReader() {
		return reader;
	}
	
	 public ConnectionThread(Socket client) {
		this.client  = client;
		try {
			writer = new PrintWriter(client.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			connected = true;
			userHandler = UserHandler.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void sendMessage(String message){
		writer.println(message);
	}
	 
	
	@Override
	public void run() {
		String message = null;
		try {
			while(  (message = reader.readLine()) != null && connected) {
				System.out.println("Message received: " + message);
				try {
					handleMessage(message);
				} catch (Exception e) {
					System.err.println("Error while handling message");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading peer message.");
			e.printStackTrace();
		}		
	}
	
	private void handleMessage(String message) throws Exception{
		String command = message.split("&")[0];
		System.out.println("message: " + message + " , command : " + command);
		String nickname;
		switch(command){
		case "/quit":	
			writer.println("Good bye!");
			connected = false;
			try {
				client.close();
				reader.close();
			} catch (IOException e) {
				System.err.println("Error while closing connection.");

				e.printStackTrace();
			}
			break;
		case "/list_users":
			userHandler.printUsers(writer, userHandler.getUsers());
			break;
		case "/list_available_users":
			userHandler.printUsers(writer, userHandler.getUsers());
			break;
		case "/login":
			nickname = message.split("&")[1];
			if(userHandler.isNicknameAvailable(nickname)){
				writer.println("Nickname " + nickname + " registered successfully.");
				userHandler.login(nickname, this);
			}else{
				writer.println("Nickname " + nickname + " is already in use.");
			}
			break;
		case "/play":
			String[] parts = message.split("&");
			nickname = parts[1];
			String play = parts[2];	
			userHandler.sendMessage(nickname, play);
			break;
		default:
			writer.println("Unknown command: " + message);
		}
	}

}
