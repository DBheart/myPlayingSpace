package db.javaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.util.javaDB.DBConntions;

public class DBConnOfConfiguration {

	DBConntions DBConn = new DBConntions();
	
	public void selectTable(){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = DBConn.connDB();
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
			if(conn!=null)try{conn.close();}catch(Exception e2){}
			
		}finally{
			if(rs!=null)try{rs.close();}catch(Exception e2){}
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
			if(conn!=null)try{conn.close();}catch(Exception e2){}
		}
	}
	
	
	public void insertData(){
		Connection conn = null;
		
		conn = DBConn.connDB();
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
	
	public void CreateTable(){
		Connection conn = null;
		Statement stmt = null;
		
		conn = DBConn.connDB();
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
}
