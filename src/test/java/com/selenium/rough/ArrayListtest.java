package com.selenium.rough;

import java.util.ArrayList;

public class ArrayListtest {

	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList <String>();
		
		list.add("first");
		list.add("second");
		list.add("third");
		
		System.out.println(list.get(2));
		System.out.println(list.size());

		for (int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}

}
