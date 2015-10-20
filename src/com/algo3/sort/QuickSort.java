package com.algo3.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * QuickSort works on principle of shuffle, partition & sort. 
 * Shuffle is very important to avoid almost sorted array to start with and result in worst case N^2 operations
 * https://www.youtube.com/watch?v=y_G9BkAm6B8
 * not stable
 * o(n^2) worst case
 * o(nlogn) normal case
 */
public class QuickSort {
	
	
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
		System.out.println(Arrays.toString(ary));
	}
	
	public static int partition(int[] a, int lo, int hi){
		
		int i = lo, j = hi+1;
		
		while(true){
		
			while(isLess(a[++i], a[lo]))
				if(i == hi) break;
			
			while(isLess(a[lo], a[--j]))
				if(lo == j) break;
			
			if(j <= i) break;//if i & j cross
			
			System.out.println("i "+i+" j "+j);
			swap(a, i, j);
			
			
			
		}//while
		
		System.out.println("lo "+lo+" j "+j);
		swap(a, lo, j);
			
		return j;
	}
	
	//2, 8, 4, 9, 5, 1
	//i=1;j=5
	//2,1,4,9,5,8
	
	//find a pivot 
	//anything left of pivot is less than pivot and anything on right is larger pivot is at right spot. 
	//now sort the left and right arrays by finding the middle values of these as pivots and continuing similarly.
	public static void sort(int[] a, int lo, int hi){
		
		if(hi <= lo) return;
		
		int j = partition(a, lo, hi);
		System.out.println(Arrays.toString(a));
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	
	 // Implementing Fisher–Yates shuffle
	  static void shuffle(int[] a)
	  {
	    Random rnd = new Random();
	    for (int i = a.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int aa = a[index];
	      a[index] = a[i];
	      a[i] = aa;
	    }
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter ints seperated by space: ");
		Scanner scn = new Scanner(System.in);
		String n = scn.nextLine();
		
		String[] strary = n.split(" ");
		
		int[] a = new int[strary.length];

		//prep to get an int ary
		for (int i = 0; i < strary.length; i++) {
			a[i] = Integer.parseInt(strary[i]);
		}
		
		//-----prep complete
		
		//shuffle -- important for good quick sort that the list is NOT ordered to begin with but shuffled
		shuffle(a);
		System.out.println("Shuffle - "+Arrays.toString(a));
		
		//partition (will happen recursively in sort)		
		//sort(recursive)
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}
	


}
