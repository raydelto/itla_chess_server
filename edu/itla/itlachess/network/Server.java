/**
 * @author Raydelto
 */
package edu.itla.itlachess.network;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	private int port;
	private ArrayList<ConnectionThread> connections;
	private ServerSocket server;
	private boolean enabled;
	private static Server instance;
	
	public static synchronized Server getInstance(){
		return instance == null ? instance = new Server() : instance;
	}
	
	private Server(){
		connections = new ArrayList<ConnectionThread>();
		enabled = true;
	}
	
	
	
	public ArrayList<ConnectionThread> getConnections() {
		return connections;
	}

	public void listen(int port){
		try {
			this.port = port;
			ConnectionThread connectionThread = null;
			System.out.println("Receiving connections on port " + port);
			server = new ServerSocket(port);
			Socket client = null;
			while(enabled){
				client = server.accept();
				PrintWriter writer = new PrintWriter(client.getOutputStream());
				writer.println("Welcome to our ITLA Chess Server");
				connectionThread = new ConnectionThread(client);
				connectionThread.start();
			}
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}