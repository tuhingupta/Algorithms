package com.other.problems;


import java.util.ArrayList;
import java.util.Scanner;

import com.algo4.tree.BSTNode;


/**
 * @author Tuhin Gupta
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/
 * Find a pair with given sum in a Balanced BST. 
 * Given a Balanced Binary Search Tree and a target sum, 
 * write a function that returns true if there is a pair (nodes with values) with sum equals to target sum, 
 * otherwise return false. Expected time complexity is O(n) and only O(Logn) extra space can be used.
 *
 ***Approach***
 *Given as Approach #3 Using BST in LeetCode link above 
 *In this approach, we make use of the fact that the given tree is a Binary Search Tree. 
 *Now, we know that the inorder traversal of a BST gives the nodes in ascending order. 
 *Thus, we do the inorder traversal of the given tree and put the results in a listlist which contains the nodes sorted in ascending order.
 *Once this is done, we make use of two pointers ll and rr pointing to the beginning and the end of the sorted listlist.
 */
public class PairOfSumBST {
	
	static BSTNode<Integer> root = null; //tree will be created with this as root 
	static java.util.List<Integer> list = new ArrayList<Integer>(); //this list will contain the elements in sorted order. o(n) space complexity

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] ary = {12, 5, 13, 17, 6, 9, 4, 7, 11, 2};
		
		
		System.out.println("Enter the number you need to search as sum of 2 nodes in BST");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		Integer sumVal = Integer.parseInt(s);// we need to find 2 nodes whose sum is this
		
		/*
		 * BST tree from ary values
		 * 
		 			12
		 		5/		\13
		 	  4/ \6		11/	\17
		  	2/\	  /\9
		  		     
		 */

		
		for (int i = 0; i < ary.length; i++) {
			
			insertNode(ary[i]);
		}
		
		
		//sort the values and add to set
		inorder(root);
		
		
		/*create 2 pointers l & r;
		 * navigate the pointers with l=0 and r=ary.length -1
		 * if l+r = sum then we found the nodes, else 
		 * 	if(l+r) < sum then increment l
		 * 		else increment r  
		*/
		
		int l = 0;
		int r = list.size() -1;
		
		while(true){
		
			int L = list.get(l);
			int R = list.get(r);
			
			if(L+R == sumVal){
				System.out.format("Found: Node %d and %d add to sum %d \n",L, R, sumVal);
				return;
			}
			else 
				if (L+R < sumVal)
					l++;
				else
					r++;
					
			if(l > r){
				System.out.format("Not Found: 2 Node not found with sum equal to %d \n", sumVal);
			}
					
		}//while
		
	}
	
	
	/**
	 * @param p
	 * 
	 * Inorder for sorted elements
	 * Do inorder traversal and add the elements in sorted order in the set.
	 * 
	 */
	public static void inorder(BSTNode<Integer> p){
        if(p == null)
            return;
        inorder(p.leftNode);
        list.add(p.t);
        inorder(p.rightNode);
    }
	
	
	//these methods create the tree by inserting nodes from array
	/**
	 * @param value
	 */
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
	
	/**
	 * @param currentRoot
	 * @param newNode
	 * @return
	 */
	public static BSTNode<Integer> traverseLastNode(BSTNode<Integer> currentRoot, BSTNode<Integer> newNode){
		
		BSTNode<Integer> retNode=null;
		
		if(currentRoot.compareTo(newNode.t) > 0 )//left side
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
	
}
