package com.algo2.stackqueuebag;

/**
 * @author tuhing
 *
 * @param <Item> generic implementation of LinkedList. see its use in other 2 classes of the package.
 */
public class LinkedList<Item> {


	private  Node firstNode = null;
	
	private  class Node{
		
		public Node(Item item, Node nextNode){
			this.item = item;
			this.nextNode = nextNode;
			
		}
		
		Item item;
		Node nextNode;
	}
	
	public  boolean isEmpty(){
		
		if(null == firstNode)
			return true;
		else
			return false;
		
	}
	
	public  void push(Item element){
		
		Node newNode = new Node(element, firstNode);
		firstNode = newNode;
		
	}
	
	public  Item pop(){
		
	if(null != firstNode){	
		Item returnStr = firstNode.item;
		firstNode = firstNode.nextNode;
		return returnStr;
	}else
		return null;
	}
	
	
	
	

}
