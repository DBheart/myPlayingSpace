package test.db.javaDB;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.File;

public class ConfigrationTest{
	Configuration prop;
	
	private static ConfigrationTest instance = new ConfigrationTest();
	private static Configuration config;
	
	
	public void load(String fileName){
		config = null;
		config = new PropertiesConfiguration();
    	try {
			((PropertiesConfiguration) config).load(new File(fileName));
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void loadXML(String fileName){
		//config = new XMLConfiguration();
    	try {
    		config = new XMLConfiguration(new File(fileName));
			//((XMLConfiguration) config).load(new File(fileName));
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}		
	}
	
	public void test(){
		try{
			String projectHome = config.getString("project.home");
			System.out.println("project.home ="+projectHome);
			
			int port = config.getInt("port");
			System.out.println("port ="+port);
			
			boolean debug = config.getBoolean("debug");
			System.out.println("debug ="+debug);
			
			String tempHome = config.getString("temp.home");
			System.out.println("temp.home ="+tempHome);
			
			String[] jdbcDrivers = config.getStringArray("jdbc.driver");
			for(int i=0; i< jdbcDrivers.length; i++){
				System.out.println(jdbcDrivers[i]);
			}
			
			String mysqlUser = config.getString("mysql.user");
			System.out.println("mysql.user ="+mysqlUser);
			
			String mysqlPassword = config.getString("mysql.password");
			System.out.println("mysql.password ="+mysqlPassword);
			
			String defaultPassword = config.getString("mysql.password","admin");
			System.out.println("mysql.password="+defaultPassword);
			
			
		}catch(org.apache.commons.configuration.ConversionException e){
			System.err.println(e.getMessage());
		}
	}
	
	public void testXML(){
		// 하부 설정 얻기
		HierarchicalConfiguration sub = ((HierarchicalConfiguration) config).configurationAt("foreground.color");
		 
		// 하부 설정 값 얻기
		System.out.printf("sub conf red = %s\n", sub.getString("red"));
	}
	
	public static void main(String[] args){
		ConfigrationTest prop = ConfigrationTest.instance;
		//test.load(".//src//test.proterties");
		
		prop.load("src//test.properties");
		prop.test();
		
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");

		prop.loadXML("src//config.xml");
		prop.testXML();
		
	}

}