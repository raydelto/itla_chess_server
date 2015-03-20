package edu.itla.itlachess.users;

import edu.itla.itlachess.network.ConnectionThread;

public class User {
	private String nickname;
	private boolean available;
	private ConnectionThread connectionThread;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public ConnectionThread getConnectionThread() {
		return connectionThread;
	}
	public void setConnectionThread(ConnectionThread connectionThread) {
		this.connectionThread = connectionThread;
	}
	public User(String nickname, boolean available,
			ConnectionThread connectionThread) {
		super();
		this.nickname = nickname;
		this.available = available;
		this.connectionThread = connectionThread;
	}


}
