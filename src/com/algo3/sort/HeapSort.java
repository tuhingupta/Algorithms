package com.algo3.sort;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Not stable
O(1) extra space (see discussion)
O(n·lg(n)) time
Not really adaptive

The first loop (for loop in main), the Θ(n) "heapify" phase, puts the array into heap order. 
The second loop(heapSort method), the O(n·lg(n)) "sortdown" phase, repeatedly extracts the maximum and restores heap order.

 */
public class HeapSort {
	
	static int[] a;
	static int n;
	static int m;
	
	
	//swim method
	public static void swim(int k){
		
		while(k > 1 && isLess(a[k/2], a[k])){
			swap(k, k/2);
			k = k/2; //parent node of k is at k/2
		}
		
	}
	
	//sink
	public static void sink(int k){
		
		while(2*k <= n){
			
			int j = 2*k;
			if(j<n && isLess(a[j], a[j+1])) j++;
			if(!isLess(a[k], a[j])) break;
			swap(k, j);
			k=j;
		}
		
	}
	
	public static boolean  isLess(int vala, int valb){
		if(vala < valb) return true;
				else if(vala > valb) return false;
						else return false; 
	}
	
	//this is the core of insertion sort.. to swap positions.
	public static void swap( int posa, int posb){
		
		int swap = a[posa];
		a[posa] = a[posb];
		a[posb] = swap;
		
	}
	
	//this takes maximum 2logN compares
	public static void heapSort(){
		
		for(int i = n; i > 0; i--){
			int max = a[1];
			swap(1, i);
			n = n-1;
			sink(1);
		}
		
	}

	/**
	 * @param args
	 * 
	 * this heap sort is divided into 2 steps.
	 * step1- one by one elements are added into the end of the heap, them they swim to right position. it takes maximum 1+logN compares for this operation
	 * step2- now sort the binary heap tree. this operation is heapSort method that take maximum 2logN compares.
	 */
	public static void main(String[] args) {

		System.out.println("Enter ints seperated by space: ");
		Scanner scn = new Scanner(System.in);
		String nx = scn.nextLine();
		
		String[] strary = nx.split(" ");
		int[] input;
		
		n = strary.length;
		m = n+1;
		input = new int[m];

		//prep to get an int ary
		for (int i = 0, j=1; i < strary.length; i++, j++) {
			if(i == 0) input[0] = 0; 
			input[j] = Integer.parseInt(strary[i]);
		}
		
		//n = m;
		//-----prep complete
		
		a = new int[m]; //now a[] will represent binary heap array. when each element is added in a loop 
		//it will swim/sink to find right place
		//the array is not sorted, but the binary heap is setup in right place. 
		//if you create a heap tree, with a[1] as head and proceed, 
		//you can see all elements in heap order (not sorted though)
		//this loop insert elements from buffer 1 by 1. this takes maxium 1+logN compares
		for (int i = 1; i < m; i++) {//heapify
			
			int x = input[i];
			a[i] = x;
			
			swim(i);
			
		}
		
		System.out.println("Binary heap(heapify): (ignore 0th position) "+Arrays.toString(a));
		
		heapSort();
		
		System.out.println("Heap Sorted: (ignore 0th position) "+Arrays.toString(a));
		
//		for(int k=n/2; k>= 1; k--){
//			sink(k);
//		}
//		
//		while(n>1){
//			swap(1, n);
//			sink(--n);
//		}
		
		

	}

}
