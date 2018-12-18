package com.selenium.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.utilities.ExcelReader;
import com.selenium.utilities.ExtentManager;

public class TestBase{

	public WebDriver driver;
	public static FileInputStream fis;
	public static Properties Config=new Properties();
	public static Properties OR=new Properties();
	public static WebDriverWait wait;
	public static Logger log;
	public static WebElement dropdown;
	public static ExtentReports extent;
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
		
	@BeforeSuite
	public void setUp() throws FileNotFoundException
	{
		
		if (driver==null)
		{
			try{
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				Config.load(fis);
				//log.debug("Config file loaded");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			try
			{

				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				OR.load(fis);
				//log.debug("OR file loaded");

			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			

			
			
			if (Config.getProperty("Browser").equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver=new ChromeDriver();
				//log.debug("Chrome launched");

			}
			else if(Config.getProperty("Browser").equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriver.exe");
				driver=new InternetExplorerDriver();
				//log.debug("IE launched");
			}

			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,5);
		}

	}
	
	public boolean isElementPresent(By by)
	{
		try{
			driver.findElement(by);
			return true;
		}
		catch(ElementNotFoundException e)
		{
			return false;
		}
	}
	
	public void click(String locator)
	{
		if (locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		else if (locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		else if (locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
			
		}
			
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}
	
	public void type(String locator,String value)
	{
		if (locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			
		}
		test.log(LogStatus.INFO, "Typing to : " + locator);
	}
	
	public void select(String locator,String value)
	{
		if (locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		else if (locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		else if (locator.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
			
		}
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO,"Selecting from dropdown : " + locator + " value as " + value);
	}
	@AfterSuite
	
	public void tearDown()
	{
		if (!(driver==null))
		{
			//driver.close();
			//log.debug("Test completed");
		}
	}
}
