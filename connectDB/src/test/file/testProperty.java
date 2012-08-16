package test.file;

import java.util.Map;

import org.junit.Test;

import db.util.file.Property;

//테스트케이스는 내가 알아볼수 있는것으로 하자. 
public class testProperty {
	Property p = new Property(".//src//globals.properties");
	
	@Test
	public void 프로퍼티가져오기(){
		
		String test = p.getProperty("test");
		System.out.println(test);
	}
	
	@Test
	public void 모든프로퍼티_가져오기(){
		Map listProperty = p.listProperty();
		System.out.println(listProperty);
		
	}
	
	@Test
	public void 프로퍼티_등록하기(){
		p.setProperty("test", "test11122");
		//프로퍼티값으로 한글을 입력할때는 문제가 좀있었던듯하다.
		//이제는 한글이 들어가면 자기가 알아서 수정해주네? ㅋㅋ
		모든프로퍼티_가져오기();
		//store라는것은 메모리상의 Property와 실제 파일간의 간극때문에 사용하는것이다.
	}
	
	@Test
	public void 프로퍼티_만들기(){
		p.propCreate(".//src//deity.properties");
		
	}
	
	
	
}
