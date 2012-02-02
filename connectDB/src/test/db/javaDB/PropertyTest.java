package test.db.javaDB;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyTest {
	private String PROPERTIES_FILE = "//study//project//workspace//globals.properties";
	
	private String Classpath_File = ".//src//globals.properties";
	
	private String getProperty(String keyName){
		String value = null;
		
		try{
			Properties props = new Properties();
			FileInputStream fls = new FileInputStream(Classpath_File);
			props.load(new BufferedInputStream(fls));
			value = props.getProperty(keyName).trim();
			fls.close();
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return value;
	}
	
	private void setProperty(String keyName, String value){
		try {
			Properties props = new Properties();
			FileInputStream fls = new FileInputStream(Classpath_File);
			props.load(new BufferedInputStream(fls));
			props.setProperty(keyName, value);
			props.store(new FileOutputStream(Classpath_File), "");
			fls.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String args[]){
		PropertyTest o = new PropertyTest();	
		System.out.println("테스트 :"+o.getProperty("test"));
	}
	
	public void propCreate() {
		Properties properties = new Properties();
		// Read properties file.
		try {
	    	
	        properties.load(new FileInputStream(Classpath_File));
		} catch (IOException e) {
		}
		String avalue = properties.getProperty("test");
		System.out.println(avalue);
		//properties.setProperty("test1", "test");	    
		// Write properties file.
		try {
		    properties.store(new FileOutputStream(Classpath_File), null);
		} catch(IOException e) {
		}
	}
}
