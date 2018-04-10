package com.algo4.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tuhin Gupta
 * 
 * #Level Order Traversal
 *  Read more here - https://www.youtube.com/watch?v=NjdOhYKjFrU
 *  
 *  
 * #Verticle Order Traversal
 *  Read more here - https://www.youtube.com/watch?v=PQKkr036wRc
 *
 */
public class BSTOperations {

	//Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. 
	static ArrayDeque<BSTNode> array = new ArrayDeque<BSTNode>();
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BSTNode root = null;
		
		int[] treeAry = {12, 3, 9, 20 , 15 ,7, 16, 2};
		
		/*
		 * treeAry:
						12
				 	3/		\20
				  2/\9	  15/
				     7/		\16
				     
		level order traversal should be = [12, 3, 20, 2, 9, 15, 7, 16]
				     
		*/
		
		//create tree
		for (int i = 0; i < treeAry.length; i++) {
			
			root = BinarySearchTree.insertNode(root, treeAry[i]);
		}
		
		//level order traversal should be = [12, 3, 20, 2, 9, 15, 7, 16]
		System.out.format("Binary Tree Level Order Traversal:  ");
		List<Integer> levelOrderedList = (ArrayList)levelOrderTraversal(root);
		
		System.out.println(levelOrderedList.toString());
		
		
		//lever order traversal in list format
		
		System.out.println("Binary Tree Level Order Traversal - print each level on new line");
		List<List<Integer>> levelOrderTraversalInLevels = levelOrderTraversalInLevels(root);
		
		for (Iterator iterator = levelOrderTraversalInLevels.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			System.out.println(list.toString());
			
		}
		
		
		//Vertical Order Traversal
		System.out.format("Node Value: %d, horizantal distance: %d \n",root.t, 0);
		verticalOrderTraversal(root, 0);
		
	}
	
	/**
	 * Printing level order in one line
	 * 1. Enqueue root
	 * 2. in loop - till elements in queue(list)
	 *  2.a take out head element(node) from queue
	 * 	2.a print node
	 *  2.b enqueue node.left and node.right 
	 * 
	 */
	public static List<Integer> levelOrderTraversal(BSTNode<Integer> root){
		
		List<Integer> levelOrderedList = new ArrayList();

		array.add(root);
		
		while(array != null){
			
			BSTNode<Integer> node = array.pollFirst(); //Retrieves and removes the first element of this deque, or returns null if this deque is empty.

			if(null == node)
				return levelOrderedList;
			
			levelOrderedList.add(node.t);
			
			if(node.leftNode != null)
				array.add(node.leftNode);
			
			if(node.rightNode != null)
				array.add(node.rightNode);
		
			
		}//for
		
		
		return levelOrderedList;
	}
	
	
	/**
	 * Printing level order in different lines:
	 * we will add a marker BSTNode to differentiate between each level.
	 * 1. Enqueue root
	 * 2. add marker(null) node
	 * 3. in loop - till elements in queue(list)
	 *  3.a take out head element(node) from queue
	 * 	3.a print node
	 *  3.b enqueue node.left and node.right 
	 * 
	 */
	public static List<List<Integer>> levelOrderTraversalInLevels(BSTNode<Integer> root){
		
		List<List<Integer>> levelOrderedList = new ArrayList();
		BSTNode<Integer> marker = new BSTNode<Integer>(null);

		array.add(root);
		array.add(marker);
		
		List<Integer> innerList = new ArrayList<Integer>();
		//innerList.add(root.t);
		
		while(array != null){
			
			if(array.size() == 1 && array.peekFirst().t == null){
				levelOrderedList.add(innerList);
				return levelOrderedList;
			}
			
			BSTNode<Integer> node = array.pollFirst(); //Retrieves and removes the first element of this deque, or returns null if this deque is empty.

			if(null != node && node.t == null){
				
				levelOrderedList.add(innerList);
				innerList = new ArrayList<Integer>();
				
				array.add(marker);
				
				continue;
			}
			
			innerList.add(node.t);
			
			if(node.leftNode != null)
				array.add(node.leftNode);
			
			if(node.rightNode != null)
				array.add(node.rightNode);
		
			
		}//for
		
		
		return levelOrderedList;
	}
	
	/**
	 * @param node
	 * @param parentHD
	 * 
	 * horizontal distance
	 * for left node = parent - 1
	 * for right node = parent + 1
	 */
	public static void verticalOrderTraversal(BSTNode<Integer> node, int parentHD){
		
		if(node.leftNode != null)  {
			
			node.leftNode.hd = parentHD -1;
			System.out.format("Node Value: %d, horizantal distance: %d \n",node.leftNode.t, node.leftNode.hd);
			verticalOrderTraversal(node.leftNode, node.leftNode.hd);
		}
		
		if(node.rightNode != null){
			
			node.rightNode.hd = parentHD +1;
			System.out.format("Node Value: %d, horizantal distance: %d \n",node.rightNode.t, node.rightNode.hd);
			verticalOrderTraversal(node.rightNode, node.rightNode.hd);
		}
		
		
		
	}


}
