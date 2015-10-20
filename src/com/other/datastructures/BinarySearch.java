package com.other.datastructures;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;


public class BinarySearch extends Assert{
	
	static char[] cAry;
	
	public static void main(String[] args) {
		
		//System.out.println('c'>'m');
		
		
		
		//System.out.println(binarySearch(cAry, 'c'));
				
	}
	
	@Before
	public void prepTestCase(){
		
		BinarySearch bs = new BinarySearch();
		System.out.println("enter chars without spaces..");
		
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		
		cAry = st.toCharArray();
		
		Arrays.sort(cAry);
		System.out.println(cAry);
		
	}
	
	@Test
	public void test_binarySearch(){
		BinarySearch bs = new BinarySearch();
	
		System.out.println("-->"+binarySearch(cAry, 'z'));
		assertEquals("test for char c",'c', binarySearch(cAry, 'c'));
		//assert binarySearch(cAry, 'b')=='b';
		assertEquals("test for char d",'d', binarySearch(cAry, 'd'));
		//assert binarySearch(cAry, 'a')=='a';
		//assert binarySearch(cAry, 'f')=='f';
		
		
		
	}
	
	public  char binarySearch(char[] stary, char c){
		
		if(0 == stary.length) { return 0;}
		
		return binarySearch (stary, c, 0 , stary.length);
		
	}
	
	/*
	 * runs a while loop and keeps dividing the array into half and checking for the char to be present
	 * if the mid of  array is greater than char, then mid becomes high
	 * else if mid of array is smaller than char then mid becomes low
	 */
	public  char binarySearch(char[] stary, char c, int lo, int hi){
		
		while(true)
		{
			
	        int mid = lo+(hi-lo)/2;
	       // if(lo>=mid) return 0;
	        if(lo>=hi) return 0;
		
			if(stary[mid] == c) return c;
			if(stary[mid] > c) { hi = mid;}
			else {lo = mid+1;}
		
			System.out.format("mid %d hi %d lo %d", mid, hi, lo);
		}
		
		//return 0;
	}

}
