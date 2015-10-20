package com.algo2.stackqueuebag;

import java.util.Scanner;

public class StackUsingLinkedList {

	/**
	 * @param args
	 * each word will be put in a node.  - will pop the top element from stack
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> ll = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("enter string, - for pop");
		String n = input.nextLine();
		
		String[] words = n.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			
			if(words[i].equalsIgnoreCase("-")){
				System.out.println(ll.pop());
			}else
			{
				ll.push(words[i]);
			}
			
		}
		
		System.out.println("left in string..");
		
		//pop all elements
		while(true){
			if(ll.isEmpty()){
				break;
			}
			
			System.out.println(ll.pop());
		}
		
	}

}
