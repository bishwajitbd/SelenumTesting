package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	By orderCheck=By.xpath("//*[@id=\'nav-orders\']/span[2]");
	By NavigationCheck=By.xpath("//*[@id=\'nav-xshop\']");
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getOrderCheck()
	{
		return driver.findElement(orderCheck);
	}
	
	public WebElement getNavigationCheck()
	{
		return driver.findElement(NavigationCheck);
	}

}
