package com.algo4.mst;

/**
 * @author Tuhin Gupta
 * 
 * Edge class for a MST - minimal spanning tree
 * This contains nodes node1 & node2 that are connected and the weight of the edge.
 *
 */
public class Edge implements Comparable<Edge>{
	
	public int node1;
	public int node2;
	public int weight;
	
	public Edge(int node1, int node2, int weight) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Edge o) {
		
		if (this.weight > o.weight)
			return 1;
		else return -1;
	}
	
	

	
}
