package test.file;

import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.junit.Test;

import db.util.file.GetConfiguration;

public class testGetConfigration{
	GetConfiguration prop = new GetConfiguration();
	
	@Test
	public void testRun(){
		//이놈의 파일가져오는 디렉토리 구조가 문제구만.. 큼.
		prop.loadProperties("src//test.properties");
		
	}
	
	@Test
	public void testLoadProperty(){
		prop.loadProperties(".//src//test.properties");
		Configuration config = prop.getValues();
		
		
		Iterator<String> it = config.getKeys();
		while(it.hasNext()){
			String propId = (String)it.next();
			System.out.println(propId+":::::"+prop.getProperties(propId));
		}
		
	}
	
	@Test
	public void testGetProperty(){
		prop.loadProperties(".//src//test.properties");
		String projectHome = prop.getProperties("project.home");
		System.out.println("HOME :"+projectHome);
	}
	
	@Test
	public void testgetSubXML(){
		prop.loadXML("src//config.xml");
		
		Configuration config = prop.getValues();
		
		//하부 이하의값 모두가져오기
		HierarchicalConfiguration sub = ((HierarchicalConfiguration) config).configurationAt("foreground.color");
		
		Iterator it = sub.getKeys();
		while(it.hasNext()){
			String elementKey = (String)it.next();
			System.out.println("["+elementKey+"]key====>"+sub.getString(elementKey));
		}
		 
	}
	
	@Test
	public void testGetXML(){
		prop.loadXML("src//config.xml");
		
		System.out.println("xml:::::::"+prop.getElement("foreground.color.red"));
		
	}
	
	
	

}