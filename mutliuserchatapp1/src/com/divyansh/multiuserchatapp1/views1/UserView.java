package com.divyansh.multiuserchatapp1.views1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	
	   public UserView()
	   {   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       setSize(400,400);
	       setResizable(true);
	       setLocationRelativeTo(null);
	       JLabel welcome=new JLabel("Login");
	       welcome.setFont(new Font("Arial",Font.BOLD,40));
	       Container container=this.getContentPane();
	       container.setLayout(null);
	       welcome.setBounds(100, 70, 200, 60);
	       container.add(welcome);
		   setVisible(true);
	   }
	 
      public static void main(String args[])
      {
    	   UserView userview=new UserView();
    	   
      }
}
