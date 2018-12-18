package cucumber.selenium.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebConnector {

public static WebDriver driver;
public static Properties OR;
public static Properties Config;
public static FileInputStream fis;


public WebConnector(){
	
	try {
		OR=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\cucumber\\selenium\\config\\OR.properties");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		OR.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	try {
		Config=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\cucumber\\selenium\\config\\Config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try {
			Config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

public void openBrowser(String Browser, String url)
{
	if(Config.getProperty("Browser").equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Config.getProperty("url"));
	}
}

public void type(String locator, String value)
{
	driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
}

public void click(String locator)
{
	driver.findElement(By.xpath(OR.getProperty(locator))).click();
}


}
