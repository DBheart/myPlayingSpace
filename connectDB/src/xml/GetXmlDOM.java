package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class GetXmlDOM {

	public void getJAXB(String uri){
		try {
			// DocumentBuilderFactory를 생성한다.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
			// DocumentBuilderFactory에서 DocumentBuilder를 생성한다. 
			DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
			// DocumentBuilder로 XML 문서를 파싱해 도큐먼트를 얻는다.
			Document doc = documentBuilder.parse(uri);
            			
		} catch (ParserConfigurationException e){ 
			e.printStackTrace(); 
			System.out.println("Error in parsing:" + e.getMessage()); 
		} catch (java.io.IOException e) {
			e.printStackTrace(); 
			System.out.println("Error in parsing:" + e.getMessage()); 
		} catch (org.xml.sax.SAXException e) { 
			System.out.println("Error in parsing :" + e.getMessage()); 
		}
	}
}
