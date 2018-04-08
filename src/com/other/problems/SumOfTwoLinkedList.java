package com.other.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tuhin Gupta
 *https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * Add two numbers. Represent numbers as lists and then add them
 * 943=9<-4<-3 + 100(=1<-0<-0) = 1043 (= 1<-0<-4<-3)
 */
public class SumOfTwoLinkedList {

	static List<Integer> ll1 = new ArrayList<Integer>();
	static List<Integer> ll2 = new ArrayList<Integer>();
	static List<Integer> result = new ArrayList<Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list1 = {1, 1, 9, 4, 8}; //11948
		int[] list2 = {3, 7, 9}; //379
		
		prepareLinklist(list1, ll1);
		prepareLinklist(list2, ll2);
		
		System.out.println(ll1.size());
		
		int counter = 0, carry = 0;
		//Add equal lists (recursive)
		carry = addLists(counter, carry);
					
		if(carry > 0)
			result.add(carry);
		
		int ii = 0;
		int number = 0;
		
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			number += integer * Math.pow(10, ii);
			
			ii++;
		}
		
		System.out.format("sum of 11948 + 379 is %d", number);
	}
	
	public static void prepareLinklist(int[] list, List<Integer> ll){
		
		for(int i = list.length -1 ; i >= 0 ; i--){
			
			ll.add(list[i]);
			
		}
		
		System.out.println(ll.toString());
		
	}
	
	public static int addLists(int counter, int carry){
		
		
		if(counter <= ll1.size()-1 || counter <= ll2.size()-1  ){
			
			int num1 = ll1.size() > counter? ll1.get(counter): 0;
			int num2 = ll2.size() > counter? ll2.get(counter): 0;
			
			int num = num1+num2+carry;
			
			if(num > 9)
				carry = num /10;
			else carry = 0;
			
			result.add(num%10);
			
			addLists(++counter, carry);
			
		}else
			return carry;
		
		return 0;
		
	}
	
	


}
