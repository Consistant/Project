package com.selenium.rough;

import java.util.Hashtable;

public class Hashtabletest {


	public static void main(String[] args) {
		
		Hashtable<String,String> table =new Hashtable<String,String>();
		
		table.put("Name", "gokul");
		table.put("age", "21");
		table.put("course", "cse");
		table.put("course", "ece");
		
		System.out.println(table.get("course"));
		

	}

}
