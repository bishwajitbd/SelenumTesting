package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;

	By signin=By.xpath("//*[@id=\'nav-link-accountList\']/span[1]");
	By signinNext=By.xpath("//*[@id=\'nav-flyout-ya-signin\']/a/span");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getSinginNext()
	{
		return driver.findElement(signinNext);
	}

	
}
