package com.selenium.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.Base.TestBase;
import com.selenium.utilities.ExcelReader;

import java.util.*;

public class TestProperties extends TestBase {
	public static Logger log=Logger.getLogger(TestProperties.class); 
	public static ExcelReader excel =new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static void main(String args[]) throws IOException, InterruptedException
	
	{
		
	System.out.println("Path="+System.getProperty("user.dir"));
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		Properties Config=new Properties();
		Config.load(fis);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		Properties OR=new Properties();
		OR.load(fis);
		System.out.println(Config.getProperty("Browser"));
		
		log.debug("testing");
		Date d=new Date();
		System.out.println(d);
		String screenshotname=d.toString().replace(":","-").replace(" ","-").substring(4)+".jpg";
		System.out.println(screenshotname);
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","D:\\selenium-java-3.8.1\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		System.out.println(OR.getProperty("addCustBtn_CSS"));
		String locator="bmlBtn_CSS";
		System.out.println("locator is: "+locator);
		//TestProperties test=new TestProperties();
		//test.click("bmlBtn_CSS");*/
	if (locator.endsWith("_CSS"))
		{
			System.out.println("locator is :"+ locator);
			System.out.println(OR.getProperty(locator));
	driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
	//input[@ng-model='lName']
	
					
		
		
		//driver.close();
	}
		
		/*File src=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
		System.out.println(src);
		FileInputStream fis1= new FileInputStream(src);
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis1);//complete work book load
		System.out.println(workbook);*/
		String sheetname="AddCustomer";
		int rows=ExcelReader.getRowCount(sheetname);
		int cols=ExcelReader.getColumnCount(sheetname);
		
		Object[][] data=new Object[rows-1][cols];
		
		for (int rowNum=1;rowNum<rows;rowNum++)
		{
			for (int colNum=0;colNum<cols;colNum++)
			{
				System.out.println("Rownum" + rowNum +"colNum"+colNum);
				
				data[rowNum-1][colNum]=ExcelReader.cellData(sheetname,colNum,rowNum);
				System.out.println(data[rowNum-1][colNum]);
			}
		}
		
	}
}

		

		

		

	

	
	/*public void click(String locator) 
	{
		
		
		System.out.println("locator is :"+ locator);
		try{
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		Properties OR=new Properties();
		OR.load(fis);
		if (locator.endsWith("_CSS"))
		{
			System.out.println("locator is :"+ locator);
			System.out.println(OR.getProperty(locator));
	driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
					
		}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
*/

	
//	@DataProvider
//	public static Object[][] getData()
//	{
//				
//		String sheetname="AddCustomer";
//		int rows=ExcelReader.getRowCount(sheetname);
//		int cols=ExcelReader.getColumnCount(sheetname);
//		
//		Object[][] data=new Object[rows-1][cols];
//		
//		for (int rowNum=2;rowNum<=rows;rowNum++)
//		{
//			for (int colNum=0;colNum<=cols;colNum++)
//			{
//				data[rowNum-2][colNum]=ExcelReader.cellData(sheetname,colNum,rowNum);
//			}
//		}
//		return data;
//		
//		
//	}
//	
//}
//
//
