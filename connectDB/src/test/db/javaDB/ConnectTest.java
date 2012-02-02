package test.db.javaDB;

import java.sql.*;

public class ConnectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//JaaDb Embed Driver
		String driver ="org.apache.derby.jdbc.EmbeddedDriver";
		
		//Database name
		String dbName ="testDB";
		
		//ConnectionURL
		String connectionURL = "jdbc:derby:"+dbName+";create=true";
		//Create Table Query
		String createString = "CREATE TABLE test_table"
							+ "(nno int not null generated always as identity," 
							+ " name VARCHAR(32) not null)"
							;
		
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
			// TODO: handle exception
		}
		
		//Craete Table
		try{
			stmt = conn.createStatement();
			System.out.println("Creating table...");
			stmt.execute(createString);
		}catch (Exception e) {
			System.out.println("Creating exist...");
			// TODO: handle exception
		}finally{
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
			
		}
		
		//Insert data
		try{
			pstmt = conn.prepareStatement("INSERT INTO test_table(name) VALUES (?)");
			
			pstmt.setString(1, "deity98");
			pstmt.executeUpdate();
			System.out.println("inserted...");
		}catch (Exception e) {
			System.out.println("Fuck! Insert fail");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//Select data
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select name from test_table");
			
			while(rs.next()){
				System.out.println(" name:"+rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally{
			if(rs!=null)try{rs.close();}catch(Exception e2){}
			if(stmt!=null)try{stmt.close();}catch(Exception e2){}
		}
		
		//close Connection
		try{
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fuck! ERR!");
			// TODO: handle exception
		}
		
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

}
