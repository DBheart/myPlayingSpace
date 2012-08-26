package db.util.file;

import java.io.File;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class GetConfiguration {
	Configuration prop;
	
	//singTon??
	//private static GetConfiguration instance = new GetConfiguration();
	private static Configuration config;
	
	public void loadProperties(String fileName){
		config = new PropertiesConfiguration();
    	try {
			((PropertiesConfiguration) config).load(new File(fileName));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Configuration getValues(){
		return config;
	}
	
	
	public String getProperties(String propertiesName){
		String propertiest = config.getString(propertiesName);
		return propertiest;
	}
	
	public void loadXML(String fileName){
		config = new XMLConfiguration();
    	try {
			config = new XMLConfiguration(new File(fileName));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String getElement(String xmlId){
		String XmlName = config.getString(xmlId);
		
		return XmlName;
		
	}
}
