package com.divyansh.multiuserchatapp1.network1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*
public class ServerWorker implements Runnable{
public class ServerWorker extends Thread{
	@Override
	public void run() {
		 TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			System.out.println("RUN I is "+i+" "+Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				 TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 public static void main(String args[])
	 {		 ServerWorker job=new ServerWorker();
		 ServerWorker worker=new ServerWorker();
	 worker.start();
		 Thread worker=new Thread(job,"worker1");
		 worker.start();
         	 for(int j=1;j<=5;j++)
		 {
			 System.out.println("Main "+j +" "+Thread.currentThread());
			 
		 }
		 
		 
	 }
	

    }*/
  public class ServerWorker extends Thread{
	  private Socket clientSocket;
	  private InputStream in;
	  private OutputStream out;
	  private Server server;
	  public ServerWorker(Socket clientSocket,Server server) throws IOException
	  {
		  this.server=server;
		  this.clientSocket=clientSocket;
		  in=clientSocket.getInputStream();
		  out=clientSocket.getOutputStream();
		  System.out.println("New Client Comes");
	  }
	  @Override
	    public void run() 
	    {
	    	BufferedReader br=new BufferedReader(new InputStreamReader(in));
	    	String line;
	    	try {
	    	while(true)
	    	{
	    		
					line=br.readLine();
					System.out.println("Line Read...."+line);
					if(line.equalsIgnoreCase("quit"))
					{
						break;
					}
					
				//	out.write(line.getBytes());
					for(ServerWorker serverWorker:server.workers)
					{
						line=line+"\n";
						serverWorker.out.write(line.getBytes());
					}
				} 
	    		
	    	}
	    	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	finally
	    	{
	    		try
	    		{
	    		if(br!=null)
	    		{
	    			br.close();
	    		}
	    		if(in!=null)
	    		{
	    			in.close();
	    		}
	    		if(out!=null)
	    		{
	    			out.close();
	    		}
	    		if(clientSocket!=null)
	    		{
	    			clientSocket.close();
	    		}
	    	}
	    		catch(Exception ex)
	    		{
	    			ex.printStackTrace();
	    		}
	    }
  }
  }    