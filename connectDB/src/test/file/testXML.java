package test.file;

import org.junit.Test;

import xml.GetXmlDOM;
import xml.GetXmlSAX;

public class testXML {

	@Test
	public void getXmlDom(){
		System.out.println("DOM ====================");
		GetXmlDOM dom = new GetXmlDOM();
		dom.getJAXB("http://sirini.net/blog/rss.php");
		System.out.println("DOM ====================");
	}
	
	@Test
	public void getXmlSax(){
		System.out.println("SAX ====================");
		GetXmlSAX sax = new GetXmlSAX();
		sax.readXML("http://sirini.net/blog/rss.php");
		System.out.println("SAX ====================");
	}
}
