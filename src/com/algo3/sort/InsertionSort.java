package com.algo3.sort;

import java.util.Arrays;
import java.util.Scanner;

/*
 *   Stable
	 O(1) extra space
	 O(n2) comparisons and swaps
	 Adaptive: O(n) time when nearly sorted
	 Very low overhead
 *   insertion sort is the algorithm of choice either when the data is nearly sorted (because it is adaptive) 
 *   or when the problem size is small (because it has low overhead).
 */
public class InsertionSort {

	static int counter = 1;
	
	public static boolean  isLess(int a, int b){
		if(a<b) return true;
				else if(a>b) return false;
						else return false; 
	}

	//this is the core of insertion sort.. to swap positions.
	public static void swap(int[] ary, int posa, int posb){
		
		int swap = ary[posa];
		ary[posa] = ary[posb];
		ary[posb] = swap;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		System.out.println("Enter ints seperated by space: ");
		Scanner scn = new Scanner(System.in);
		String n = scn.nextLine();
		
		String[] strary = n.split(" ");
		
		int[] intary = new int[strary.length];

		//prep to get an int ary
		for (int i = 0; i < strary.length; i++) {
			intary[i] = Integer.parseInt(strary[i]);
		}
		
		//-----prep complete
		
		//insertion sort starts here
		//number is moved from unsorted portion (right) to sorted portion (left) till all nos are sorted
		//i=0 is the start and considered the sorted portion
		//so in subsequent passes i=0,1,2 will be sorted. anything right of i=2 will be unsorted
		for (int i = 1; i < intary.length; i++) 
		{
			
			int elem = intary[i];
			int pos = i;
			
			for (int j = i-1; j >= 0; j--) {
				
				if(isLess(elem, intary[j] ))
				{
					//elem = intary[j];
					swap(intary, pos, j);
					pos =j;
				}else{
					break;
				}
				
				System.out.println(counter+++" "+ i+ " "+Arrays.toString(intary));
			}
			
			
			
		}//outer for

		
	}

}
