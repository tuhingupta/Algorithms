package com.algo3.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tuhing
 * 
 * recursive merge sort - divide and conquor. nlogn - best and worst case
 * this requires an aux array for sorting. hence requires more space
 * 2 important methods - merge and sort (sort being recursive)
 * 
 * Stable
Θ(n) extra space for arrays (as shown)
Θ(lg(n)) extra space for linked lists
Θ(n·lg(n)) time
Not adaptive
Does not require random access to data
http://www.sorting-algorithms.com/
 */
public class MergeSort {
	
	static int counter = 1;
	
	public static boolean  isLess(int a, int b){
		if(a<b) return true;
				else if(a>b) return false;
						else return false; 
	}
	
	//important merge method of merge sort
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi){
		
		//copy main ary a to aux ary from lo to hi
		for(int k=lo; k<=hi;k++){
			aux[k] = a[k];
		}
		
		int i = lo, j = mid+1;
		//this for method take 2 arrays from start (represent by i & j in aux) 
		//and compares & merges the two into a[] 
		for(int k=lo; k<=hi;k++){
			if (i > mid) 					 a[k] = aux[j++];
			else if (j > hi) 				 a[k] = aux[i++];
			else if (isLess(aux[j], aux[i])) a[k] = aux[j++];
			else 							 a[k] = aux[i++];
			
			System.out.println(counter++ + " - " +Arrays.toString(a));
		}
				
	}
	
	//this is the recursive sort
	// this breaks an array into arrays of 1 each. 
	//Then merge starts by merging into 1 arrays from sorted 2 arrays. 
	//then 2 arrays to sorted 4 arrays and so on.
	public static void sort (int[] a, int[] aux, int lo, int hi){
		
		if(hi <= lo) return;
		
		int mid = lo+ (hi-lo) /2;
		
		//recursive sort the 2 parts of the lo-hi array
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		
		//now merge the two parts of the array
		merge(a, aux, lo, mid, hi);
		
		
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

		//prep the input to int array
		for (int i = 0; i < strary.length; i++) {
			a[i] = Integer.parseInt(strary[i]);
		}
		
		//-----prep complete
		
		//merge sort starts here.
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length -1);
		
		System.out.println(Arrays.toString(a));
	}

}
