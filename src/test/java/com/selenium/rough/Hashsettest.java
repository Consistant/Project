package com.selenium.rough;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hashsettest {


	public static void main(String[] args) {
		
		Set<Integer> set=new HashSet<Integer>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		
		Iterator<Integer> iterate=set.iterator();
		/*System.out.println(iterate.next());
		System.out.println(iterate.next());
		*/
		while(iterate.hasNext())
		{
			System.out.println(iterate.next());
		}
		
		
	}

}
