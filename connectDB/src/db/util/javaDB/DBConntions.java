package db.util.javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import db.util.file.GetConfiguration;


public class DBConntions {
	GetConfiguration config = new GetConfiguration();
	
	
	public Connection connDB(){
		config.loadProperties();
		Connection conn = null;
		
		String driver = config.getProperties("driver_JavaDB");
		
		String connectionURL = config.getProperties("connectionURL_JavaDB");
		
		//Load Driver
		try{
			Class.forName(driver);
			
		}catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//get Connection 
		try{
			conn = DriverManager.getConnection(connectionURL);
		}catch (Exception e) {
			e.printStackTrace();
			if(conn!=null)try{conn.close();}catch(Exception e2){}
		}
		
		return conn;
	}	
	
	public void DBShowdown(){
		String driverNm = config.getProperties("driver_JavaDB"); 
		String showdownString = config.getProperties("shutdown_JavaDB"); 
			
		if(driverNm.equals(driverNm)){
			boolean isSuccess = false;
			
			try{
				DriverManager.getConnection(showdownString);
			}catch(SQLException se){
				if(se.getSQLState().equals("XJ015")){
					isSuccess = true;
				}
			}
			
			if(!isSuccess){
				System.out.println("Fuck! Shutdown fail!");
			}else{
				System.out.println("End...");
			}
		}
	}
	
	
}
