package com.algo4.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tuhin Gupta
 *
 *https://www.coursera.org/learn/algorithms-part2/lecture/4ZE6G/graph-api
 */
public class Graph {
	
	public final int V; // number of vertices
	private List<Integer>[] adj; //array of list integers of adjacent vertices
	
	public Graph(int V){
		this.V = V;
		adj = (List<Integer>[]) new List[V];
		
		for (int v=0; v <V; v++){
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}

}
