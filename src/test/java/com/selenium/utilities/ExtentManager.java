package com.selenium.utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if (extent==null)
		{
			extent=new ExtentReports(System.getProperty("user.dir")+"\\target\\html\\extent.html", false,DisplayOrder.OLDEST_FIRST);
		}
		
		return extent;
	}
	

}
