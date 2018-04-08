package com.other.problems;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Tuhin Gupta
 * 
 * split sentance with space and print backwards
 *
 */
public class StringReverseWords {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String ss = sc.nextLine();
		
		split1(ss);
		split2(ss);
		
	}
	
	public static void split1(String ss){
		String[] sAry = ss.split(" ");
		System.out.println(sAry.length);
		
		for (int i = sAry.length -1; i >= 0; i--) {
			
			System.out.format(sAry[i]+ " ");
		}
		System.out.println("\n");
	}
	
	public static void split2(String ss){
		
		int begin = 0;
		int end = 0;
		Stack<String> sList = new Stack<String>();
		
		for(int i =0; i < ss.length(); i++){
			
			
			if(ss.charAt(i) == " ".charAt(0)){
				end = i;
				sList.push(ss.substring(begin, end));
				System.out.println(ss.substring(begin, end));
				
				begin = i+1;
			}
			
			
			
		}//for
		
		sList.push(ss.substring(begin, ss.length()));
		
		for (int i = 0; i < sList.size(); i++) {
			System.out.format(sList.pop() + " ");
			
		}
		
	}
	

}
