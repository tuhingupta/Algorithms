package com.algo3.sort;

import java.util.Arrays;
import java.util.Scanner;

/*
 * http://www.sorting-algorithms.com/selection-sort
 * 
 * Properties
	Not stable
	O(1) extra space
	Θ(n2) comparisons
	Θ(n) swaps
	Not adaptive
 * 
 */
public class SelectionSort {
	
	static int counter = 1;
	public static boolean  isLess(int a, int b){
		if(a<b) return true;
				else if(a>b) return false;
						else return false; 
	}

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

		for (int i = 0; i < strary.length; i++) {
			intary[i] = Integer.parseInt(strary[i]);
		}
		//--prep for data complete--now sorting
		
		//in selection sort the first element of the array is picked and compared against the entire array.
		//the smallest element found in that pass of entire array is kept that that ith position 
		// on each pass the min value is found and kept at the i-th index. 
		//current i-th value is swapped with it.
		int min;
		int posb=0;
		for (int i = 0; i < intary.length; i++) {
			
			min = intary[i];
			boolean doswap = false;
			
			for(int j=i+1; j < intary.length ;j++ ){
				
				if(isLess(intary[j],min)){
					min = intary[j];
					posb = j;
					doswap = true;
				}
				
				System.out.println(counter++ + " - " +Arrays.toString(intary));
				
			}//for j
			
			if(doswap){
				doswap = false;
				swap(intary, i, posb);
			}
			
			
		}//for i
	
		System.out.println(Arrays.toString(intary));
		
	}

}
