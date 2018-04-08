package com.algo4.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Tuhin Gupta
 *
 *Look at Graph.java for implementation of Graph
 * a graph that is not directed. a->b then b->a
 * edges connect vertices
 */
public class UndirectedGraph {

	static boolean[] marked;
	static int[] edgeTo; //auxilary data structure to manage edge from vertex
	
	static Queue<Integer> q = new PriorityQueue();//this data structure is for bfs to hold vertex
	
	public static void main(String[] args) {
		
		int v =5; //number of vertices
		int[][] connectedV = {
				{0, 2}, {0, 3}, {0, 4}, {1, 4}, {1, 2}, {2, 3} 	
		};
		System.out.println("Number of vertices "+ v);
		
		Graph g = new Graph(v);
		
		//create the connections in undirected graph
		for (int i = 0; i < connectedV.length; i++) {
			
			g.addEdge(connectedV[i][0], connectedV[i][1]);
		}
		
		//adjacent vertices
		for (Iterator iterator = g.adj(0).iterator(); iterator.hasNext();) {
			Integer type = (Integer) iterator.next();
			System.out.print(type+" ");
			
		}
		
		//depth first search
		marked = new boolean[g.V];
		edgeTo = new int[g.V];
		
		dfs(g, 0);
		
		for (int i = 0; i < edgeTo.length; i++) {
			
			System.out.format("\n Depth-first search: Edge from %d to %d \n", i, edgeTo[i] );
		}
		
		//breadth first search
		marked = new boolean[g.V];
		edgeTo = new int[g.V];
		
		bfs(g, 1);
		for (int i = 0; i < edgeTo.length; i++) {
			
			System.out.format("\n Breadth-first search: Edge from %d to %d \n", i, edgeTo[i] );
		}
		
		
		
	}
	
	/**
	 * @param g
	 * @param vertice
	 * dfs is used for finding all connected vertices in a graph
	 * practicle implemetation could be - connected pixels of same color to change color in photoshop
	 */
	public static void dfs(Graph g, int vertice){

		marked[vertice] = true;
		
		for(int w: g.adj(vertice)){
			
			if(!marked[w]){
				//this recursion is kind of a stack. each vertex is explored like a stack. FILO
				dfs(g, w);
				edgeTo[w] = vertice;
			}
			
		}//for
		
	}
	
	/**
	 * @param g
	 * @param v
	 * BFS computes the shortest path (fewer number of edges) from s to all other
	 * vertices in a graph in time proportional to E+V(edge + vertice)
	 * bfs each vertex is added to a queue. FIFO
	 * https://www.coursera.org/learn/algorithms-part2/lecture/DjaET/breadth-first-search
	 */
	public static void bfs(Graph g, int v){
		
		q.add(v);
		int e = v;
		edgeTo[v] = v;
		
		while(!q.isEmpty()){
			e = q.remove();
			marked[e] = true;
			
			for(int w: g.adj(e)){
				//System.out.format("%d is adjacent to %d\n", w, e);
				
				if(!marked[w]){
					edgeTo[w] = e;
					q.add(w);
				}
				
			}//for
		}//while
		
	}
}
