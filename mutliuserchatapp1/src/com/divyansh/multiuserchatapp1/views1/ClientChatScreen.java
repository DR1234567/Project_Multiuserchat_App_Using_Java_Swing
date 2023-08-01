package com.divyansh.multiuserchatapp1.views1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.divyansh.multiuserchatapp1.network1.Client;
import com.divyansh.multiuserchatapp1.utils1.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private  JTextArea textArea;
    private Client client;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					try {
						ClientChatScreen frame = new ClientChatScreen();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
   
	    private void sendIt() 
	    {
	    	String message=textField.getText();
	    	try {
				client.sendMessage(UserInfo.USER_NAME+"-"+message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea=  new JTextArea();
		client=new Client(textArea);
		setTitle("Chatting ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
  
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 6, 581, 359);
        contentPane.add(scrollPane);
        
       
        textArea.setFont(new Font("Lucida Grande",Font.PLAIN,16));
        textArea.setBounds(10, 26, 561, 336);
        scrollPane.setViewportView(textArea);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 14));
        textField.setBounds(10, 375, 433, 26);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton sendIt = new JButton("Send Message");
        sendIt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sendIt();
        	}
        });
        sendIt.setFont(new Font("Tahoma", Font.BOLD, 11));
        sendIt.setBounds(466, 377, 115, 21);
        contentPane.add(sendIt);
        setVisible(true);
        
	}
}
