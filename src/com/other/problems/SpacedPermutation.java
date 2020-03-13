package com.other.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tuhin Gupta
 *
 *
 *Given an integer n, create an array such that each value is repeated twice.
 *
 *Input: n = 3
Output: [1, 1, 2, 2, 3, 3]


 After creating it, find a permutation such that each number is spaced in such a way, 
 they are at a "their value" distance from the second occurrence of the same number. 
 Return any 1 permutation if it exists. Empty array if no permutation exists.

Example 1:

Input: n = 3 --> This is the array - [1, 1, 2, 2, 3, 3]
Output: [3, 1, 2, 1, 3, 2]
Explanation:
The second 3 is 3 digits away from the first 3. 
The second 2 is 2 digits away from the first 2. 
The second 1 is 1 digit away from the first 1. 
 */
public class SpacedPermutation {
	
	public static void main(String[] args) {
		
		int input = 3;	
		
		int[] ary = new int[input*2];
		
		
		int i = 1;
		createAry(ary, i, input *2);
		
		int[] wip = new int[input*2];
		
		//initialize empty array to set values
		

		//initialize empty array for only input length
		LinkedList<Integer> list ;

//		for(int k=0; k< input; k++)
//		{
//			list.add(k+1);
//		}
		
		//Iterator<Integer> itr = list.iterator();
		
		for(int j=1;j<= input; j++){
		
			for(int w=0; w< wip.length; w++){
				wip[w] = 0;
			}
			list = new LinkedList<>();
			for(int k=0; k< input; k++)
			{
				list.add(k+1);
			}
			
			System.out.println("recursion "+list.toString()+" "+Arrays.toString(wip)+" "+j);
			recursive(list, wip, j);
		}
		
		
		
	}
	
	public static void recursive(LinkedList<Integer> list, int[] wip, int j){
		
		//System.out.println(Arrays.toString(wip));
		
		list.remove(new Integer(j));
		boolean bool = false;
		
		for(int i = 0; i < wip.length; i++){
			
			if(wip[i] == 0 && i+j+1 < wip.length && wip[i+j+1] == 0){
				wip[i] = j;
				wip[i+j+1] = j;
				bool = true;
				break;
			}else continue;
		}//for
		
		if(!bool) return;
		
		while(!list.isEmpty()){
			Integer t = list.getFirst();
			recursive(list, wip, t);
		}
		
		if(bool && list.isEmpty())
			System.out.println(Arrays.toString(wip));

		
		return;
		
		
	}
	
	
	
	public static void createAry(int[] ary, int i, int limit){
		
		//System.out.println(i);
		if(i-1 >= limit ) return;
		
		ary[i-1] = i/2 + i%2;
		i += 1;
		createAry(ary, i, limit);
		return;
		
	}
	
	

}
