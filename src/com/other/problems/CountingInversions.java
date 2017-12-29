package com.other.problems;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.algo3.sort.MergeSort;

/**
 * @author Tuhin Gupta
 * 
 * Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j 
 * but a[i]>a[j]. Given an array, design a linearithmic algorithm to count the number of inversions.
 * 
 * Solution:
 * O(n * log n) time by the following way.
 * 1. Merge sort array A and create a copy (array B) 
 *    Take A[1] and find its position in sorted array B via a binary search. The number of inversions for this element will be one less than the index number of its position in B since every lower number that appears after the first element of A will be an inversion.
 * 2a. accumulate the number of inversions to counter variable num_inversions.
 * 2b. remove A[1] from array A and also from its corresponding position in array B
 * 3. rerun from step 2 until there are no more elements in A.
 *
 *This is linearithmic algo because:
 * Step 1 (merge sort) would take O(n * log n) to execute. 
 * Step 2 would execute n times and at each execution would perform a binary search that takes O(log n) 
 * 	to run for a total of O(n * log n). 
 * Total running time would thus be O(n * log n) + O(n * log n) = O(n * log n).
 */

public class CountingInversions {
	
	public static void main(String[] args) {
		
		System.out.println("Enter ints seperated by space: ");
		Scanner scn = new Scanner(System.in);
		String n = scn.nextLine();
		scn.close();
		
		String[] strary = n.split(" ");
		
		int[] a = new int[strary.length];

		//prep the input to int array
		for (int i = 0; i < strary.length; i++) {
			a[i] = Integer.parseInt(strary[i]);
		}
		//-----prep complete
		
		int[] orig = Arrays.copyOf(a, a.length);
		
		//Step 1 - merge sort starts here.
		int[] aux = new int[a.length];
		MergeSort.sort(a, aux, 0, a.length -1);
		
		System.out.println("Original array - "+ Arrays.toString(orig));
		System.out.println("Merge Sorted array - "+ Arrays.toString(a));
		
		int invCount = 0;
		
		//Step 2 - count inversions
		for (int i = 0; i < orig.length;i++){
			
			int pos = binarySearch(orig[i], a);
			//System.out.println(pos);
			
			if(pos > 0)
				invCount += pos;
			
			a = ArrayUtils.removeElement(a, orig[i]);
			
			
			
		}
		
		System.out.println("Inversion Count "+ invCount);
		
	}
	
	/*
	 * binary search - logn logarithamic way to find position of a key
	 */
	public static int binarySearch(int key, int[] ary){
		
		int lo = 0;
		int hi = ary.length -1;
		
		while (lo <= hi){
			
			int mid = lo + (hi -lo)/2;
			
			if (key < ary[mid]) 
				hi = mid -1;
			else if (key > ary[mid])
				lo = mid +1 ;
			else return mid;
		}
		
		return -1;
	}
	

}
