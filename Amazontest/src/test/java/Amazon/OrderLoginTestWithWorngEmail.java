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

public class OrderLoginTestWithWorngEmail extends base {
	public static Logger log = LogManager.getLogger(OrderLoginTestWithWorngEmail.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Singin test: 1 Driver is initialized");
	}
	@Test(dataProvider="getData")
	public void orerPageWrongLogin(String username) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("2. Navigated to Home page");
	
		/*LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		l.getSinginNext().click();*/
		
		HomePage hp= new HomePage(driver);
		hp.getOrderCheck().click();
		log.info("3. Click on order from top nagigation");
		

		Signin s= new Signin(driver);
		s.getEmail().sendKeys(username);
		log.info("4, Enter email information in the email box.");
		s.getContinue().click();
		log.info("5. Click on Continue");
		
		Assert.assertEquals(s.getErrorMessage().getText(), "1There was a problem");
		log.info("6. Validate the alert text message that displayed for wrong password");
		
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
		Object[][] data = new Object[2][1];
		
		//0th row
		data[0][0]="wrongaddress124@gmail.com";
		
		//1st row
		data[1][0]="wrong233@gmail.com";
		
		return data;
		
		
		
	}
}

