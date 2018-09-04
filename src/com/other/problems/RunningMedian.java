package com.other.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tuhin Gupta
 *
 * This is a data structures problem of finding running median from streamed data using Heaps
 * This can also be found using Insertion sort but it takes O(n^2) time to sort n elements and then add the new element
 * 
 * Better solution is using heaps We don't need to sort the elements.
 * We only need to know 1 (in case of odd) and 2 (in case of even) numbers for finding the median.
 * Median is (n-1)/2 spot of the sorted array if the number of elements in an array (n) is odd. 
 * For a sorted array with an even number of elements, average of two elements in the middle are medians
 * 
 * Heaps take o(nlog n) for heap insertions/deletions. This problem can be solved with using min and max heaps.
 * min and max are very effective because they allow us to pull out the smallest (from max heap) and greatest (from min heap) elements.
 * These will be the 2 middle elements when we have even number of elements.
 */
public class RunningMedian {

	public static void getMedian(int[] integers){
		
		double median;
		
		// for lower half of numbers
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return -1 * o1.compareTo(o2); // we need biggest number at the top so we are multiplying by 1
											  // normally PQ stores lowest number at the top
			};
		});
		
		//for higher half of numbers
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1.compareTo(o2); 
			};
		});
		
		ArrayList<Integer> aryList = new ArrayList<>();
		
		// take array and find medians
		for (int i = 0; i < integers.length; i++) {
			
			aryList.add(integers[i]);//this is just for printing 
			
			addNumber(integers[i], maxHeap, minHeap);
			rebalanceHeaps(maxHeap, minHeap);
			median = getMedian(maxHeap, minHeap);
			
			//printing the answer in pretty format
			Collections.sort(aryList);
			System.out.println("Median of List of numbers "+aryList.toString()+" is "+median);
		}
		
	}
	
		
	public static void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
		
		//if number is less than max number in the lower numbers heap
		if(maxHeap.size() == 0 || maxHeap.peek() > number){
			maxHeap.add(number);
		}else{
			minHeap.add(number);
		}
	}
	
	public static void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
		
		if(maxHeap.size() - minHeap.size() > 1){
			minHeap.add(maxHeap.poll());
		}else if (minHeap.size() - maxHeap.size() > 1){
			maxHeap.add(minHeap.poll());
		}
		
	}
	
	public static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
		
		//odd
		if((maxHeap.size()+minHeap.size())%2 > 0){
			
			if(maxHeap.size() > minHeap.size()){
				return maxHeap.peek();
			}else
				return minHeap.peek();
			
		}else{
			//even		
			return (double) (maxHeap.peek()+minHeap.peek())/2;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		//pass the test array
		int[] testInt = {4,6,12,7,9,14,8,11,3};
		getMedian(testInt);
		
	}
	
}
