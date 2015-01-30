package edu.itla.itlachess.network;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class Server{
	private int port;
	private ServerSocket server;
	public Server(int port){
		this.port = port;
	}
	
	public void listen(){
		try {
			server = new ServerSocket(port);
			Socket client = server.accept();
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			writer.println("Welcome to our ITLA Chess Server");
			writer.close();
			client.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}