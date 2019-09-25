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

public class OrderLoginTestWithWorngEmail extends base {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
	
		/*LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		l.getSinginNext().click();*/
		
		HomePage hp= new HomePage(driver);
		hp.getOrderCheck().click();
		

		Signin s= new Signin(driver);
		s.getEmail().sendKeys(username);
		s.getContinue().click();
		
		Assert.assertEquals(s.getErrorMessage().getText(), "There was a problem");
		
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
		Object[][] data = new Object[2][1];
		
		//0th row
		data[0][0]="wrongaddress124@gmail.com";
		
		//1st row
		data[1][0]="wrong233@gmail.com";
		
		return data;
		
		
		
	}
}

