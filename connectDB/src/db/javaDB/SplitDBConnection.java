package db.javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SplitDBConnection {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateTable();
		insertData();
		selectTable();
	}
	
	private static void selectTable(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = connDB();
		//Select data
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select name from test_table");
			int i = 0;
			while(rs.next()){
				System.out.println(i++ + " name:"+rs.getString("name"));
			}
		}catch (Exception e) {
			if(rs!=null)try{rs.close();}catch(Exception e2){}
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
		}finally{
			if(rs!=null)try{rs.close();}catch(Exception e2){}
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
		}
	}
	
	
	private static void insertData(){
		Connection conn = null;
		
		conn = connDB();
		PreparedStatement pstmt = null;
		
		//Insert data
		try{
			pstmt = conn.prepareStatement("INSERT INTO test_table(name) VALUES (?)");
			
			pstmt.setString(1, "deity98");
			pstmt.executeUpdate();
			System.out.println("inserted...");
		}catch (Exception e) {
			System.out.println("Fuck! Insert fail");
			e.printStackTrace();
			if(pstmt!=null)try{pstmt.close();}catch(Exception e2){}
			if(conn!=null)try{conn.close();}catch(Exception e2){}
		}finally{
			if(pstmt!=null)try{pstmt.close();}catch(Exception e2){}
			if(conn!=null)try{conn.close();}catch(Exception e2){}
			
		}
	}
	
	private static void CreateTable(){
		Connection conn = null;
		Statement stmt = null;
		
		conn = connDB();
		//Create Table Query
		String createString = "CREATE TABLE test_table"
							+ "(nno int not null generated always as identity," 
							+ " name VARCHAR(32) not null)"
							;
		
		//Craete Table
		try{
			stmt = conn.createStatement();
			System.out.println("Creating table...");
			stmt.execute(createString);
		}catch (Exception e) {
			System.out.println("Creating exist...");
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
			if(conn!=null)try{conn.close();}catch(Exception e2){}
		}finally{
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
			if(conn!=null)try{conn.close();}catch(Exception e2){}
			
		}			
		
		
	}
	
	private static Connection connDB(){
		Connection conn = null;
		
		//JaaDb Embed Driver
		String driver ="org.apache.derby.jdbc.EmbeddedDriver";
		
		//Database name
		String dbName ="testDB";
		
		//ConnectionURL
		String connectionURL = "jdbc:derby:"+dbName+";create=true";
		
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
	
	//DB Showdown??? ?¬ì????.
	private void DBShowdown(String driver){
		//DB shutdown
		if(driver.equals("org.apache.derby.jdbc.EmbeddedDriver")){
			boolean isSuccess = false;
			
			try{
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
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
	
	private void getProperities(){
		
	}



}
