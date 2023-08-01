package com.divyansh.multiuserchatapp1.views1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.divyansh.multiuserchatapp1.dao1.UserDAO;
import com.divyansh.multiuserchatapp1.dto1.UserDTO;
import com.divyansh.multiuserchatapp1.utils1.UserInfo;

import java.awt.Font;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
				UserScreen window = new UserScreen();
			
					
	}   
	  UserDAO userDAO=new UserDAO();
	   private void doLogin()
	   {
		   String userid=useridtxt.getText();
		   char []password=passwordField.getPassword();
		   
		   UserDTO userDTO=new UserDTO(userid,password);
		   try {
			   String message="";
			if(userDAO.isLogin(userDTO))
			{
				message="Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DashBoard dashBoard=new DashBoard(message);
				dashBoard.setVisible(true);
			}
			else
			{
				message="Invalid Userid or Password";
				JOptionPane.showMessageDialog(this,message);
			}
			//JOptionPane.showMessageDialog(this,message);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	   private void register()
	   {
		   String userid=useridtxt.getText();
		   char []password=passwordField.getPassword();
		 //  UserDAO userDAO=new UserDAO();
		   UserDTO userDTO=new UserDTO(userid,password);
		    try {
		   int result=userDAO.add(userDTO);
		   if (result>0)
		   {
			   JOptionPane.showMessageDialog(this, "Register Successfull");
			   //System.out.println("Record added");
		   }
		   else {
			   JOptionPane.showMessageDialog(this, "Register Fails");
			  // System.out.println("Record not added");
		   }
		    }
		    catch(ClassNotFoundException |SQLException ex)
		    {
		    	System.out.println("DB Issue");
		    	ex.printStackTrace();
		    }
		    catch(Exception ex) {
		    	System.out.println("Some Generic exception Raised...");
		    	 ex.printStackTrace();
		    }
		   System.out.print("userid"+userid+"Password"+password);
		   
	   }

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setTitle("LOGIN");
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 43, 112, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel useridlbl = new JLabel("User id");
		useridlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		useridlbl.setBounds(117, 102, 70, 30);
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		pwdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlbl.setBounds(100, 160, 112, 30);
		getContentPane().add(pwdlbl);
		
		JButton loginbt = new JButton("login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginbt.setBounds(167, 232, 85, 21);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerbt.setBounds(272, 232, 97, 21);
		getContentPane().add(registerbt);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(222, 111, 142, 21);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 170, 142, 19);
		getContentPane().add(passwordField);
		setResizable(false);
		setSize( 538, 409);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}