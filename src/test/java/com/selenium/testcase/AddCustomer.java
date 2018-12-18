package com.selenium.testcase;



import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.util.HSSFColor.ORANGE;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.utilities.*;


import com.selenium.Base.TestBase;

public class AddCustomer extends TestBase {
	
	//@Test (dataProvider="getData")
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	//public void addCustomer(String fname,String lname,String postcode,String alerttext) throws InterruptedException
	public void addCustomer(Hashtable<String,String> data) throws InterruptedException{
		
		System.out.println(data.get("firstname"));

		//System.out.println(OR.getProperty("addCustBtn_CSS"));
		//click("addCustBtn_CSS");
		/*Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='addCust()']")));
		driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(fname);
		driver.findElement(By.cssSelector(OR.getProperty("lastname_XPATH"))).sendKeys(lname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(postcode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn_CSS"))).click();
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Thread.sleep(3000);*/
	}
	
	/*@DataProvider
	public Object[][] getData()
	{
				
		String sheetname="AddCustomer";
		int rows=ExcelReader.getRowCount(sheetname);
		int cols=ExcelReader.getColumnCount(sheetname);
		
		Object[][] data=new Object[rows-1][cols];
		
		for (int rowNum=1;rowNum<rows;rowNum++)
		{
			for (int colNum=0;colNum<cols;colNum++)
			{
				data[rowNum-1][colNum]=ExcelReader.cellData(sheetname,colNum,rowNum);
			}
		}
		return data;
		
		
	}
	
}*/


}