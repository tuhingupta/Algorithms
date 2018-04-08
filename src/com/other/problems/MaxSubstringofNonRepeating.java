package com.other.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxSubstringofNonRepeating {

	
	public static void main(String[] args) {
		
		System.out.println("enter string with repeating char");
		Scanner scn = new Scanner(System.in);
		String n = scn.nextLine();
		
		scn.close();
		
		lengthOfLongestSubstring(n);
		
		
	}
	
	
	 public static int  lengthOfLongestSubstring(String s) {
		 
		 char[] cary = s.toCharArray();
	     
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 
		 char c;
		 String maxss = new String();
		 int start = 0;
		 int end = 0;
		 int size = 0;
		 
		 //o(n) time complexity implementation
		 for(int i=0, j=0;j<s.length();){
			 
			 System.out.format("\n i=%d j=%d string %s and max ss is %s", i, j, hm.keySet(), maxss);
			 c = cary[j];
			 
			 if(hm.get(String.valueOf(c)) != null){
				
				 if(size < hm.size()){
					 maxss = hm.keySet().toString();
					 start = (Integer)hm.values().toArray()[0];
					 end = (Integer)hm.values().toArray()[hm.size() -1];
					 size = hm.size();
				 }
				 hm.remove(String.valueOf(hm.keySet().toArray()[0]));
				 i++;
				 
				 
			 }else{
				 
				 hm.put(String.valueOf(c), Integer.valueOf(j));

				 j++;
				 
				 
			 }//else
			 
		 }//for
		 
//		 if(size > 0 ){
//			 start = (Integer)hm.values().toArray()[0];
//			 end = (Integer)hm.values().toArray()[hm.size() -1];
//			 size = hm.size();
//			 
//		 }
		 
		 //max substring print
		 System.out.format("Max substring is %s with elements at %d, %d", maxss, start, end);
		 
		 return hm.size();
	}
}
