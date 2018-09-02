package com.other.problems;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Tuhin Gupta
 *
 *Merge K Sorted Lists into one sorted list
 *We can use Merge sort and its time complexity will be o(nk*log(nk)) where k number of lists with n elements 
 *
 *
 *However, a better solution will be to use heap and solve with o(n log k)
 */
public class Merge_K_Lists {
	
	static int[][] kLists = new int[][]{{1,10,15},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		
		
		
		//list1
		ListNode<Integer> newhead1, newhead2, newhead3; 
		ListNode<Integer> head1 = newhead1 = new ListNode<Integer>(kLists[0][0]);
		
		for(int i = 1; i < kLists[0].length;i++){
		
			ListNode<Integer> ln = new ListNode<>(kLists[0][i]);
			if(i==1)
				head1.next(ln);
			
			newhead1.next(ln);
			
			newhead1 = newhead1.next;
		}
		
		//list1
		
		ListNode<Integer> head2 = newhead2 = new ListNode<Integer>(kLists[1][0]);
		
		for(int i = 1; i < kLists[1].length;i++){
		
			ListNode<Integer> ln = new ListNode<>(kLists[1][i]);
			if(i==1)
				head2.next(ln);
			
			newhead2.next(ln);
			
			newhead2 = newhead2.next;
		}
		
		//list1
		
		ListNode<Integer> head3 = newhead3 = new ListNode<Integer>(kLists[2][0]);
		
		for(int i = 1; i < kLists[2].length;i++){
		
			ListNode<Integer> ln = new ListNode<>(kLists[2][i]);
			if(i==1)
				head3.next(ln);
			
			newhead3.next(ln);
			
			newhead3 = newhead3.next;
		}
		
		
		//---------sorted list created.---
		
		//total number of lists  -> k
		int k = kLists.length;
		
		/*
		 * The total order of time complexity o in this case is:
		 * o(k*log k) + o(n*2log(k)) ~= o(n*log(k))
		 */
		
		//Using PriorityQueue for heap implementation - addition/deletion is o(log(k)) 
				PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>(new Comparator<ListNode<Integer>>() {
					
					@Override
					public int compare(ListNode<Integer> o1, ListNode<Integer> o2) {
						// TODO Auto-generated method stub
						return o1.node - o2.node;
					}
				});
		
		
		
		//populate initial heap - it will be of size k -- o(k*log k)
		
		pq.add(head1); //o(log k)
		pq.add(head2); //o(log k)
		pq.add(head3); //o(log k)
		
		
		List<Integer> sortedList = new LinkedList<Integer>();

		
		//this loop runs for n times. Once for all elements in all lists
		while(!pq.isEmpty()){ // o(n)
		
			ListNode<Integer> ln = pq.remove();
			sortedList.add(ln.node);//pq.remove is o(log k) operation since pq has k elements
			
			if(ln.next != null)
				pq.add(ln.next); //pq.add operation is o(log k)
			
		}
		
		
		
		for (Iterator iterator = sortedList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer + " ");
		}
		
	}

}

class ListNode<T>{
	
	T node;
	ListNode<T> next;
	
	public ListNode(T val){
		this.node = val;
		
	}
	
	public void next(ListNode<T> nextVal){
		this.next = nextVal;
	}
	
}
