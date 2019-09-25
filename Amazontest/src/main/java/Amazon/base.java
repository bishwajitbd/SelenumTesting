package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		//Properties prop= new Properties();
		//Data driven file
		prop= new Properties();
		FileInputStream fis= new FileInputStream("E:\\app\\SelenumTesting\\Amazontest\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\app\\chromedriver.exe" );
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("E:\\test\\"+result+"screenshot.png"));

	}

}
