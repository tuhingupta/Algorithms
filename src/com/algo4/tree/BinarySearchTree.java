package com.algo4.tree;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
 * about BST - https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html
 * check this URL - http://www.theparticle.com/_javadata2.html#Comparing_Objects
 */
public class BinarySearchTree {
	
	static BSTNode<Integer> root = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter ints seperated by space: ");
		Scanner scn = new Scanner(System.in);
		String nx = scn.nextLine();
		
		String[] strary = nx.split(" ");
		Integer[] whitelist = new Integer[strary.length];

		

		//prep to get an int ary
		for (int i = 0; i < strary.length; i++) {
			
			whitelist[i] = Integer.parseInt(strary[i]);
		}
		
		//now the whitelist array is complete to be inserted
		for (int i = 0; i < whitelist.length; i++) {
			System.out.println("inserting "+whitelist[i]);
			insertNode(whitelist[i]);
		}
		
		
		//traverse Tree
		System.out.print("in order - ");
		intrav(root);//this will print sorted list
		System.out.println("");
		System.out.print("pre order - ");
		pretrav(root);
		breadthFirst(root);
		
		//search
		System.out.println(searchTree(root, 42)==null?"not found":"found");
		System.out.println(searchTree(root, 33)==null?"not found":"found");

	}
	
	public static void insertNode( Integer value){
		
		if(null == root){
			root = new BSTNode<Integer>(value);
			
		}else{
		
			BSTNode<Integer> valNode = new BSTNode<Integer>(value);
			
			BSTNode<Integer> nodeToInsert = traverseLastNode(root, valNode);
			
			if(nodeToInsert.compareTo(value) > 0){
				nodeToInsert.leftNode = valNode;
			}else{
				nodeToInsert.rightNode = valNode;
			}
		
		}//else
		
	}
	
	//traverse 
	
	public static BSTNode<Integer> traverseLastNode(BSTNode<Integer> currentRoot, BSTNode<Integer> newNode){
		
		BSTNode<Integer> retNode=null;
		
		if(currentRoot.compareTo(newNode.t) > 0 )
		{
			
			if(null != currentRoot.leftNode){
				retNode = traverseLastNode(currentRoot.leftNode, newNode);
			}else{
				retNode = currentRoot;
			}
			
		}else{//for right side
			
			if(null != currentRoot.rightNode){
				retNode = traverseLastNode(currentRoot.rightNode, newNode);
			}else{
				retNode = currentRoot;
			}
			
		}
		
		
		return retNode;
		
		
	}
	
	public static BSTNode<Integer> searchTree(BSTNode<Integer> root, Integer val){
		
		
		if(null != root && root.compareTo(val)>0){
			searchTree(root.leftNode, val);
		}
		
		if(null != root && root.compareTo(val)<0){
			searchTree(root.rightNode, val);
		}
		
		if(null != root && root.compareTo(val)==0){
			return root;
		}
		
		return null;
	}
	
	//breadth first traversal
	public static void breadthFirst(BSTNode<Integer> p){
		System.out.println("");
		System.out.print("breadthFirst ");
		
		ArrayDeque<BSTNode<Integer>> queue = new ArrayDeque<BSTNode<Integer>>();
		
		queue.add(p);
		
		while(!queue.isEmpty()){
			
			p = queue.poll();
			
			if(null != p.leftNode){
			
				queue.add(p.leftNode);
			}
			if(null != p.rightNode){
				
				queue.add(p.rightNode);
			}
			
			
			System.out.print(p.t+" ");
			
			
			
		}//while
		
	}
	
	
	//depth first traversals
	public static void intrav(BSTNode<Integer> p){
        if(p == null)
            return;
        intrav(p.leftNode);
        System.out.print(p.t+" ");
        intrav(p.rightNode);
    }
	
	
	public static void pretrav(BSTNode<Integer> p){
        if(p == null)
            return;
        System.out.print(p.t+" ");
        pretrav(p.leftNode);
        pretrav(p.rightNode);
    }


}
