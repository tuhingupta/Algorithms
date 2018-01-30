package com.other.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * TwoSum - enter an array of ints. Also enter the sum or target you want
 * Now you need to find two distinct numbers in the array that add up to the sum (target)
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

	
	public static void main(String[] args) {
		
		System.out.println("Enter array seperated by space with last number as the sum");
		Scanner scn = new Scanner(System.in);
		String n = scn.nextLine();
		
		scn.close();
		
		String[] strary = n.split(" ");
		int[] intAry = new int[strary.length -1];
		
		for (int i = 0; i < strary.length -1; i++) {
			
			intAry[i] = Integer.parseInt(strary[i]);
		}
		
		
		
		int sum = Integer.parseInt(strary[strary.length -1]);
		
		//------execution -- o(n) way of solving this
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int diff;
		
		System.out.format("Sum %d found using numbers ", sum);
		for (int i = 0; i < intAry.length; i++) {
		
			diff = sum - intAry[i];
			
			//map.contains is o(1) time efficiency 
			if(map.containsKey(diff))
				System.out.format("two variables %d and %d", intAry[i], diff );
			else
				map.put(Integer.valueOf(intAry[i]), intAry[i]);
			
		}
		
		
		
	}
}
