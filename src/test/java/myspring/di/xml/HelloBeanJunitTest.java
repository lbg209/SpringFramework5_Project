package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {

	BeanFactory factory;
	
	@BeforeEach
	void container() {
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test
	void hello() {
		
		Hello helloById = (Hello) factory.getBean("hello");
		Hello helloByType = factory.getBean("hello", Hello.class);
		
		System.out.println(helloById == helloByType);
		
		assertSame(helloById, helloByType);
		
		assertEquals("Hello 스프링", helloByType.sayHello());
	
		helloById.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);
		
		assertEquals("Hello 스프링", printer.toString());
		
	
	}
}
