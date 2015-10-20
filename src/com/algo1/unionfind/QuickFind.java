package com.algo1.unionfind;

import java.util.Scanner;

/*
 * The <tt>QuickFindUF</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses quick find.
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *  Afterwards, <em>find</em>, <em>connected</em>, and <em>count</em>
 *  takes constant time but <em>union</em> takes linear time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  
 * This algo uses N^2 (quadratic times) access to process sequence of N union cmds. N to initialize arry. N for union. 1 for find.
 */
public class QuickFind {
	
	static int[] ufarray;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		System.out.println("enter int till which you want to initialize array");
		n = input.nextInt();
		initialize(n);
		
		do{
			System.out.println("enter 999 to exit");
			System.out.println("enter p: ");
			int p = input.nextInt();
			
			if(p == 999){
				break;
			}
			
			System.out.println("enter q: ");
			int q = input.nextInt();
			
			if(isConnected(p, q)){
				System.out.println(p+" "+q+"are connected");
			}else{
				union(p,q);
			}
			
						
		}while(true);
		
		for (int i = 0; i < ufarray.length; i++) {
			
			System.out.println("Component for element "+i+" is "+find(i));
		}
	}
	
	/*
	 * takes N iterations to initialize UF array.
	 */
	static void initialize(int n){
		
		ufarray = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			
			ufarray[i] = i;
			
		}
	}
	
	/*
	 * if both are not connected then connect them by having same id in ufarray for both of them.
	 * also change ids of all other ints that shared the ids before.
	 */
	static void union(int p, int q){
		
		int p1 = ufarray[p];
		int q1 = ufarray[q];
		
		for (int i = 0; i < ufarray.length; i++) {
			
			if(q1 == ufarray[i]){
				ufarray[i] = p1;
			}
			
		}
		
	}
	
	/*
	 * check if both are connected.
	 */
	static boolean isConnected (int p, int q){
		
		if(ufarray[p] == ufarray[q])
			return true;
		else
			return false;
	}

	/*
	 * Returns the component identifier for the component containing site <tt>p</tt>.
	 */
	static int find(int p){
		return ufarray[p];
	}
}
