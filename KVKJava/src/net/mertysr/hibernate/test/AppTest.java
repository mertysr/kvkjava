package net.mertysr.hibernate.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.jandex.Main;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.InputStream;

import junit.framework.Assert;
import net.mertysr.hibernate.App;
import net.mertysr.hibernate.model.city.Iterator;
import net.mertysr.hibernate.model.city.NameRepository;

class AppTest {
	App app=new App();
	@Test
	void test() {
		NameRepository namesRepository = new NameRepository(); //Iterator behaivor
		  List < String > cityName = new ArrayList < String > ();
		  for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
		     cityName.add((String)iter.next());
	}
}
	@Test
	void Apptest() {
		
		app.doSomething();
	}
	@SuppressWarnings("deprecation")
	@Test
	void IteratorTest() {
		
		NameRepository nRepository=new NameRepository();
		assertEquals(app.IteratorCount(), nRepository.namesLength);
		
	}
	@Test 
	void UserNullTest(){
		assertNotNull(app.userNull());
	}
	@Test
	void UserSameTest() {
		System.out.println(app.userNull().length);
		assertSame(app.userNull()[0], app.userNull()[1]);

	}
	@Test
	void RepetitiveTest() {
		assertTrue(repetitive());
	}
	Boolean repetitive() {
		Boolean boolean1=false;
	    for (int i = 0; i < app.userNull().length; i++) {
	    	for (int j = 0; j < app.userNull().length; j++) {
	    		if(app.userNull()[i].equals(app.userNull()[j])) {
	    			boolean1=true;
	    			break;
	    		}
	    		else
	    		  break;
	    }
	    
	}
	  return boolean1;
	  
}
	
}
