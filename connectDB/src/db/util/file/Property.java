package db.util.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
 * 프로퍼티는 지웠다 썼다하는것보다는 가져다 읽는것에 쓰는게 맞다.
 * */
public class Property {
	private static String Classpath_File = ".//src//globals.properties";
	
	public Property(String propertyName){
		Classpath_File = propertyName;
	}
	
	//HashMap이 좋은 이유는 sysout찍으면 그값이 그대로 나와서이다.
	public Map listProperty() {
		Map rtnMap = new HashMap();
		try{
			Properties props = new Properties();
			FileInputStream fls = new FileInputStream(Classpath_File);
			props.load(new BufferedInputStream(fls));
		
			//값을 순서대로 찍어내기
			//키값을 찍어낸다음에.. 그것에 대한것을 이터레이션 하는게 제일 빠를듯.
			
			//Enumeration listPropertyId =props.keys();
			
			for (Enumeration e = props.propertyNames(); e.hasMoreElements();){
				
				String key = (String)e.nextElement();
				
				rtnMap.put(key, props.getProperty(key));
			}
			
			fls.close();
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return rtnMap;
	}

	public String getProperty(String keyName){
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
	
	public void setProperty(String keyName, String value){
		try {
			Properties props = new Properties();
			FileInputStream fls = new FileInputStream(Classpath_File);
			props.load(new BufferedInputStream(fls));
			props.setProperty(keyName, value);
			//setProperty를 한것은 메모리상(props객체)에 등록하는것이고, store를 할때만이 파일에 기록한다.
			props.store(new FileOutputStream(Classpath_File), "");
			fls.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void propCreate(String newPropertyFile) {
		Properties properties = new Properties();
		properties.setProperty("test", "테스트");
		
		try {
		    properties.store(new FileOutputStream(newPropertyFile), null);
		} catch(IOException e) {
		}
	}

	/**
	 * 아래 것을 알아보자.
	 * clone
	 * sotre
	 * values
	 * list
	 */
	public void moreProperty(){
		String value = null;
		try{
			Properties props = new Properties();
			FileInputStream fls = new FileInputStream(Classpath_File);
			props.load(new BufferedInputStream(fls));
		
			//값을 순서대로 찍어내기
			for (Enumeration e = props.elements(); e.hasMoreElements();){
				System.out.println(e.nextElement());
			}
			//HashMap h = (HashMap) props.clone();
			//System.out.println(h);
			//순서대로말고.. 값으로 넣어놓을 방법은?
			System.out.println("Set :"+props.keySet());//Set으로 가지고 있다.
			
			//아래 두개는 같은 값을 가진다.. 틀린점은? 가져오는 순서가 약간 틀리네?
			props.keys();//Enumeration으로 가지고 온다.
			props.propertyNames();
			
			//아래 두개는 같은값을 가져간다. 몬차이일까?
			props.keySet();//키값을 Set으로 가지고 온다.
			props.stringPropertyNames();
			
			
			//value = props.getProperty(keyName).trim();
			fls.close();
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}
