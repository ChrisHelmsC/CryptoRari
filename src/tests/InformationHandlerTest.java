package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cryptoRari.services.InformationHandler;

public class InformationHandlerTest {
	
	InformationHandler IH;
	
	public InformationHandlerTest() {
		IH = new InformationHandler();
	}

	@Test
	public void testGetProducts() {
		List productList = new ArrayList();
		productList = IH.getProducts();
		System.out.println(productList);
		
		/*
		 * can also use assertEquals(expected, actual)
		 * it will test to see if expected = actual, they are just variables of any data type
		 */
		assertTrue(productList.size() > 0); //passes if this statement is true can have as many as you want
		assertTrue(productList != null);
	}
	
	
	@Test
	public void testChrissFunction() {
		//shit goes here
		// make as many of these test as you want
	}

}
