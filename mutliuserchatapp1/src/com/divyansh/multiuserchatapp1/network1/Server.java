package com.divyansh.multiuserchatapp1.network1;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.divyansh.multiuserchatapp1.utils1.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers=new ArrayList<>();
	public Server() throws IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket =new ServerSocket(PORT);
		System.out.println("Server start and waiting for the client to join....");
		handleClientRequest();
		}
	public void handleClientRequest() throws IOException
	{
		while(true)
		{
		Socket clientSocket=serverSocket.accept();
		ServerWorker serverWorker=new ServerWorker(clientSocket,this);
		workers.add(serverWorker);
		serverWorker.start();
		}
	}
	/*public Server() throws IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket =new ServerSocket(PORT);
		System.out.println("Server started and waiting for client connection");
		Socket socket=serverSocket.accept();
		System.out.println("Client joins Server");
		InputStream in=socket.getInputStream();
		byte arr[]=in.readAllBytes();
		String str=new String(arr);
		System.out.println("Message Rec From the Client "+str);
		in.close();
		socket.close();
		
	}*/
	 public static void main(String args[]) throws IOException
	 {
	 Server server=new Server();
		 
	 }
}
