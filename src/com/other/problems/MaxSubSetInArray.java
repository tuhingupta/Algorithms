package com.other.problems;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Input: A 2-dimensional array NxN - Matrix - with positive and negative elements.
 * Output: A submatrix of any size such that its summation is the maximum among all possible submatrices.
 * Requirement: Algorithm complexity to be of O(N^3)
 * http://stackoverflow.com/questions/2643908/getting-the-submatrix-with-maximum-sum
 * 
 * @author Tuhin Gupta
 *
 */

public class MaxSubSetInArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter integers seperated by space in one line");
		
		String st = sc.nextLine();
		String[] ss ;
		
		ss = st.split(" ");
		int[] intAry = new int[ss.length];
		for (int i = 0; i < ss.length; i++) {
			
			intAry[i] = Integer.parseInt(ss[i]);
		}
		
		System.out.println("The input array is "+Arrays.toString(intAry));
		
		//Kandane's algorithm
		
		int[] sum = new int[intAry.length];
		int[] pos = new int[intAry.length];
		
		for (int i = 0; i < intAry.length; i++) {
			if(i == 0){
				sum[i] = intAry[i];
				pos[i] = i;
			}else{
				
				if((sum[i-1]+intAry[i]) > intAry[i]){//add to same array
					sum[i] = sum[i-1] + intAry[i];
					pos[i] = pos[i-1];
					
				}else{//starting a new one
					sum[i] = intAry[i];
					pos[i] = i;
					
				}
			}//else
			
		}//for
		
		int x = 0;
		int y = 0;
		int highestVal = intAry[0];
		
		//now find the highest sum in the sum array and its positions
		
		for (int i = 1; i < sum.length; i++) {
			if(sum[i]> highestVal){
				x=pos[i];
				y=i;
				highestVal = sum[i];
			}
			
		}
		
		System.out.println("Max subset is ("+x+","+y+") and highest sum is "+highestVal);

	}

}
