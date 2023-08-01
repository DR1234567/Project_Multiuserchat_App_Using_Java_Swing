package com.divyansh.multiuserchatapp1.dao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.divyansh.multiuserchatapp1.utils1.ConfigReader.getValue;

public interface CommonDAO {
     public static Connection createConnection() throws ClassNotFoundException, SQLException
     {
    	 Class.forName(getValue("DRIVER"));
		final String CONNECTION_STRING=getValue("CONNECTION_URL");
    	 final String USER_ID=getValue("USERID");
    	 final String PASSWORD=getValue("PASSWORD");
    	 Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
    	 if(con!=null)
    	 {
    		 System.out.println("Connections Created...");
   		//  con.close();
    	 }
    	   return con;
     }
     
}
