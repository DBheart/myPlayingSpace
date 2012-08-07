package test.db.javaDB;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import db.javaDB.DBConnOfConfiguration;
import db.javaDB.DBConnOfProperties;
import db.javaDB.SplitDBConnectionNotMain;
import db.util.javaDB.DBConntions;

public class testSplitDBConnection {

	/**
	 * DBConntion과 쿼리가 모두 한 메서드에 있는것을 분리.
	 * @throws Exception
	 */
	public void testJaaDB() throws Exception {
		SplitDBConnectionNotMain dBConn = new SplitDBConnectionNotMain(); 
		
		dBConn.CreateTable();
		//dBConn.insertData();
		dBConn.selectTable();
		//dBConn.DBShowdown("org.apache.derby.jdbc.EmbeddedDriver");
	}
	
	/**
	 * DBConnection의 주요정보를 Properties에서 가지고 있음.
	 * @throws Exception
	 */
	public void testJavaDB_properties() throws Exception {
		DBConnOfProperties dBConn = new DBConnOfProperties();
		
		dBConn.CreateTable();
		//dBConn.insertData();
		dBConn.selectTable();
		dBConn.DBShowdown(dBConn.getProperty("driver_JavaDB"));
	}
	
	/**
	 * DBConntion과 Properties가져오는 부분을 모두 분리
	 * DBConnOfConfiguration에서는 순수 DB쿼리부분밖에 없음.
	 * @throws Exception
	 */
	@Test
	public void testJavaDB_Configuration() throws Exception {
		DBConnOfConfiguration dbConn = new DBConnOfConfiguration();
		DBConntions connUtil = new DBConntions(); 
		//dbConn.CreateTable();
		dbConn.insertData();
		dbConn.selectTable();
		connUtil.DBShowdown();
	}
}
