package com.selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.selenium.Base.TestBase;


public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;
	
	public void captureScreenshot() throws IOException
	{
		File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		Date d=new Date();
		screenshotName=d.toString().replace(":","-").replace(" ","-").substring(4)+".jpg";
		
		FileUtils.copyFile(scr,new File(System.getProperty("user.dir")+"\\target\\" + screenshotName));
	}


@DataProvider(name="dp")
public Object[][] getData(Method m)
{
			
	String sheetName=m.getName();
	int rows=ExcelReader.getRowCount(sheetName);
	int cols=ExcelReader.getColumnCount(sheetName);
	
	Object[][] data=new Object[rows][cols];
	Hashtable<String,String> table = null;
	
	for (int rowNum=2;rowNum<rows;rowNum++)
	{
		table = new Hashtable<String,String>();
		for (int colNum=0;colNum<cols;colNum++)
		{
			System.out.println("Rownum" + rowNum +"colNum"+colNum);
			table.put(ExcelReader.cellData(sheetName, colNum, 1), ExcelReader.cellData(sheetName, colNum, rowNum));
			data[rowNum-1][colNum]=table;
			/*System.out.println(ExcelReader.cellData(sheetName, colNum, 1));
			data[rowNum-1][colNum]=ExcelReader.cellData(sheetName,colNum,rowNum);
			System.out.println(data[rowNum-1][colNum]);
			table.put(ExcelReader.cellData(sheetName, colNum, 1),(String) data[rowNum-1][colNum]);*/
			System.out.println(table.get("lastname"));
			
		}
	}
	return data;
	
		
}
}