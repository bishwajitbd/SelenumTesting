package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signin {
	public WebDriver driver;
	
	By email=By.id("ap_email");
	By continues= By.id("continue");
	By password=By.xpath("//*[@id=\'ap_password\']");
	By SigninComplete=By.xpath("//*[@id=\'signInSubmit\']");
	
	By errorMessage=By.xpath("//*[@id=\'auth-error-message-box\']/div/h4");
	

	public Signin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getErrorMessage()
	{
		return driver.findElement(errorMessage);
	}
	
	public WebElement getContinue()
	{
		return driver.findElement(continues);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getSigninComplete()
	{
		return driver.findElement(SigninComplete);
	}

}
