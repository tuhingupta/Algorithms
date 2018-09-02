package com.algo4.mst;

/**
 * @author Tuhin Gupta
 * 
 * See also similar implementation in com.algo3.sort.HeapSort - HeapSort.java
 * Both use concepts of Binary Heaps - https://www.coursera.org/learn/algorithms-part1/lecture/Uzwy6/binary-heaps
 * 
 * 
 * A priority queue acts like a queue in that you dequeue an item by removing it from the front. However, in a priority queue the logical order of items inside a queue is determined by their priority. 
 * The highest priority items are at the front of the queue and the lowest priority items are at the back.
 * However, inserting into a list is O(n) and sorting a list is O(nlogn). 
 * The classic way to implement a priority queue is using a data structure called a binary heap. 
 * A binary heap will allow us both enqueue and dequeue items in O(logn). 
 */
public class PriorityQueue {

	 Edge[] array;
	 int size;
	 int inputCount = 0;
	 int n =0;

	public PriorityQueue(int size) {
		
		 this.size = size;
		 this.array = new Edge[size+1];
		 array[0] = new Edge(0,0,0);
	}
	

	
	//swim method
	public void swim(int k){
		
		while(k > 1 && isLess(array[k/2], array[k])){
			swap(k, k/2);
			k = k/2; //parent node of k is at k/2
		}
		
	}
	
	//sink
	public  void sink(int k){
		
		while(2*k <= size){
			
			int j = 2*k;
			if(j<size && isLess(array[j], array[j+1])) j++;
			if(!isLess(array[k], array[j])) break;
			swap(k, j);
			k=j;
		}
		
	}
	
	public  boolean  isLess(Edge a, Edge b){
		if(a!=null && b!=null){
			if(a.weight < b.weight) return true;
					else if(a.weight > b.weight) return false;
							else return false;
		}else
			return false;
	}
	
	//this is the core of insertion sort.. to swap positions.
	public void swap( int posa, int posb){
		
		Edge swap = array[posa];
		array[posa] = array[posb];
		array[posb] = swap;
		
	}
	
	/*
	 * add edge and sort binary heap based on edge weight
	 */
	public void addEdge(Edge e){
		
		this.array[++inputCount] = e;
		swim(inputCount);
		
		
	}
	
	/*
	 * this is nothing but implementation of heap sort 
	 * we will keep removing elements from the top(max element) , promoting the last element and sinking it till it finds right spot
	 */
	public void sortEdges(){
		
		
		for(int i = n-1; i > 0; i--){
				Edge max = array[1];
				System.out.format("Sorted Array: Edge between %d and %d with weight %d\n", max.node1, max.node2, max.weight);
				
				swap(1, i);
				n = i-1;
				sink(1);
			}
			
		
	}
	
	
	/*
	 * 
	 * Array starts from 1 for simpler k & k/2 calculations.
	 * If you pass 6 to PriorityQueue constructor then it will create an array of n+1
	 * 
	 */
	public static void main(String[] args) {
		
		PriorityQueue pq = new PriorityQueue(6);
		pq.n = pq.array.length;
		
		pq.addEdge(new Edge(1,2, 2));
		pq.addEdge(new Edge(1,3, 4));
		pq.addEdge(new Edge(1,4, 6));
		pq.addEdge(new Edge(2,3, 8));
		pq.addEdge(new Edge(2,4, 1));
		pq.addEdge(new Edge(3,4, 7));
		
		pq.sortEdges();
		System.out.println("---------------------------------------------");
//		for (int i = 1; i < pq.array.length; i++) {
//			
//			Edge e = pq.array[i];
//			
//			System.out.format("Edge between %d and %d with weight %d\n", e.node1, e.node2, e.weight);
//		}
		
		
	}
	
	
}
