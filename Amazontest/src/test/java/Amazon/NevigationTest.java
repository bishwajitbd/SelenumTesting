package Amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.HomePage;
import pageObject.Signin;

public class NevigationTest extends base {
	public static Logger log = LogManager.getLogger(NevigationTest.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Navigation Test: 1. Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("2. Navigated to Home page");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username) throws IOException
	{
		HomePage hp= new HomePage(driver);
		
		Assert.assertTrue(hp.getNavigationCheck().isDisplayed());
		log.info("3. Validate the alart text message that displayed for Navigtion");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	

	@DataProvider
	public Object[][] getData()
	{
		//Row stand for how many different data types tested
		//Column stand for how many value per each test
		Object[][] data = new Object[1][1];
		
		//0th row
		data[0][0]="wrongaddress124@gmail.com";
		
		return data;
		
		
		
	}
}

