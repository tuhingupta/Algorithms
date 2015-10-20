package com.algo2.stackqueuebag;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 2 - application of stacks - Dijkstra's two stack algo computes value.
 * Arithmetic expression evaluation using stacks. 
 * For implementing stacks we use LinkedList generic class developed and in same package.
 * use expression like (1+((2+3)*(4*5)))= 101; 1+((2*3)+4)=11
 * expression has to start with bracket.
 */
public class ArithmeticEvalforStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> oper = new LinkedList<String>();
		LinkedList<Double> expression = new LinkedList<Double>();

		Scanner input = new Scanner(System.in);
		
		System.out.println("enter string, to evaluate");
		String n = input.nextLine();
		
		String[] words = n.split("");
		
		
		for (int i = 0; i < words.length; i++) {
			
			String wd = words[i];
			
			if(wd.equalsIgnoreCase("(")||wd.equals("")){
				continue;
			}else if(wd.equals("+")||wd.equals("*"))
			{
				oper.push(wd);
			}else if (wd.equals(")")){
				
				Double d1 = expression.pop();
				Double d2 = expression.pop();
				String exp = oper.pop();
				
				if(exp.equals("+")){
				
					expression.push(d1+d2);
				}else if (exp.equals("*")){
					expression.push(d1*d2);
				}
				
				
				
			}else
			{
				expression.push(Double.parseDouble(wd));
			}
			
		}//for
		
		if(!oper.isEmpty()){
		
			while(!oper.isEmpty()){
				Double d1 = expression.pop();
				Double d2 = expression.pop();
				String exp = oper.pop();
				
				if(exp.equals("+")){
				
					expression.push(d1+d2);
				}else if (exp.equals("*")){
					expression.push(d1*d2);
				}
			}
		}
		
		System.out.println("final result "+ expression.pop());

	}

}
