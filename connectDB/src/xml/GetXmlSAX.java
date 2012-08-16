package xml;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class GetXmlSAX {
	public static void main(String[] args) {
		GetXmlSAX sax = new GetXmlSAX();
		sax.readXML("http://sirini.net/blog/rss.php");
	}
	public void testXML4J(){
		SAXParser mySAXParser = null; //new SAXParser();
		//JAXP에서는 SAXParser이 추상클래스이므로 바로생성할수 없다.
	}
	
	public void getJAXP(String xml){
		SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
		SAXParser mySAXParser;
		try {
			mySAXParser = mySAXParserFactory.newSAXParser();
			mySAXParser.parse(xml, new MyDefaultHandler());
			
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
	
	public void readXML(String xml){


        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            MyDefaultHandler handler = new MyDefaultHandler();
            xr.setContentHandler(handler);
            xr.setErrorHandler(handler);
			xr.parse(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			XMLReader myReader = XMLReaderFactory.createXMLReader();
			myReader.parse(xml);
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
