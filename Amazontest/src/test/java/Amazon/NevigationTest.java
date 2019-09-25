package Amazon;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.HomePage;
import pageObject.Signin;

public class NevigationTest extends base {
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username) throws IOException
	{
		HomePage hp= new HomePage(driver);
		
		Assert.assertTrue(hp.getNavigationCheck().isDisplayed());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
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

