package xml;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class testSAX {
	public static void main(String[] args) {
		testSAX sax = new testSAX();
		sax.testXMLReader();
	}
	public void testXML4J(){
		SAXParser mySAXParser = null; //new SAXParser();
		//JAXP에서는 SAXParser이 추상클래스이므로 바로생성할수 없다.
	}
	
	public void testJAXP(){
		SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
		SAXParser mySAXParser;
		try {
			mySAXParser = mySAXParserFactory.newSAXParser();
			mySAXParser.parse("http://sirini.net/blog/rss.php", new MyDefaultHandler());
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void testXMLReader(){


        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            MyDefaultHandler handler = new MyDefaultHandler();
            xr.setContentHandler(handler);
            xr.setErrorHandler(handler);
			xr.parse("http://sirini.net/blog/rss.php");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			XMLReader myReader = XMLReaderFactory.createXMLReader();
			myReader.parse("http://sirini.net/blog/rss.php");
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
