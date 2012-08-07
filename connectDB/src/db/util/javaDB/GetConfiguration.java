package db.util.javaDB;

import java.io.File;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class GetConfiguration {
	Configuration prop;
	
	//singTon??
	//private static GetConfiguration instance = new GetConfiguration();
	private static Configuration config;
	
	public void loadProperties(String fileName){
		config = new PropertiesConfiguration();
    	try {
			((PropertiesConfiguration) config).load(new File(fileName));
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void loadProperties(){
		try {
			config = new PropertiesConfiguration(new File("src//globals.properties"));
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String getProperties(String propertiesName){
		String propertiest = config.getString(propertiesName);
		return propertiest;
	}
}
