package org.training;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.training.patterns.ClassicSingleton;

public class NewTest {
	private ClassicSingleton sone = null, stwo = null;
	private static Logger logger = Logger.getLogger(NewTest.class);	

	@BeforeClass
	public void beforeClass() {
		Reporter.log("getting singleton...", true);
		sone = ClassicSingleton.getInstance();
		Reporter.log("...got singleton: " + sone, true);
		Reporter.log("getting singleton...", true);
		stwo = ClassicSingleton.getInstance();
		Reporter.log("...got singleton: " + stwo, true);	
		//Reporter.log( "Message", true );
	}

	@Test
	public void testUnique() {
	      logger.info("checking singletons for equality");
	      Assert.assertEquals(true, sone == stwo);		
	}
}
