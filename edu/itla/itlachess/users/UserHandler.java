package edu.itla.itlachess.users;

import java.io.PrintWriter;
import java.util.ArrayList;

import edu.itla.itlachess.network.ConnectionThread;

public class UserHandler {
	private ArrayList<User> users;
	private static UserHandler instance;
	
	public static synchronized UserHandler getInstance(){
		return instance == null ? instance = new UserHandler() : instance;
	}
	private UserHandler(){
		users = new ArrayList<User>();
	}
	
	public boolean isNicknameAvailable(String nickName){
		for(User user: users){
			if(user.getNickname().equalsIgnoreCase(nickName)){
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public ArrayList<User> getAvailableUsers(){
		ArrayList<User> availableUsers = new ArrayList<User>();
		for(User user : users){
			if(user.isAvailable()){
				availableUsers.add(user);
			}
		}
		return availableUsers;
	}
	
	public void login(String nickname, ConnectionThread connectionThread){
		users.add(new User(nickname, true, connectionThread));
	}
	
	public String printUsers(PrintWriter writer, ArrayList<User> users){
		StringBuilder builder = new StringBuilder();
		for(User user : users){
			writer.println(user.getNickname());
		}
		return builder.toString();		
	}
	
	public void sendMessage(String nickname , String message){
		for(User user : users){
			if(user.getNickname().equalsIgnoreCase(nickname)){
				System.out.println(message + " has been sent to " + nickname);
				user.getConnectionThread().getWriter().println(message);
			}
		}
	}
	
	
}
