package com.algo4.tree;

public class BSTNode<T> implements Comparable<T>{
	
	T t;
	BSTNode<T> leftNode;
	BSTNode<T> rightNode;
	Integer rank ; //rank is the number of nodes that are smaller to the given node
	
	public BSTNode(T val){
		
		this.t = val;
		
	}
	
	
	@Override
	public int compareTo(T o) {
		
		if(t.equals(o))
			return 0;
		
		if(t.hashCode() > o.hashCode())
			return 1;
		else return -1;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BSTNode other = (BSTNode) obj;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
	
	

}
