package com.algo1.unionfind;

import java.util.Scanner;

/*
 * Weighted quick-union:
 * 
 * Quick-union is based on the same data structure—the site-indexed id[] array—but it uses a different interpretation of the values that leads to more complicated structures. 
 * Specifically, the id[] entry for each site will be the name of another site in the same component (possibly itself). 
 * To implement find() we start at the given site, follow its link to another site, follow that sites link to yet another site, and so forth, 
 * following links until reaching a root, a site that has a link to itself. 
 * Two sites are in the same component if and only if this process leads them to the same root. 
 * To validate this process, we need union() to maintain this invariant, which is easily arranged: we follow links to find the roots associated with each of the given sites, 
 * then rename one of the components by linking one of these roots to the other.
 * 
 * Weighted quick-union. Rather than arbitrarily connecting the second tree to the first for union() in the quick-union algorithm,
 * we keep track of the size of each tree and always connect the smaller tree to the larger.
 * 
 * http://algs4.cs.princeton.edu/15uf/
 * 
 */
public class WeightedQuickUnion {

	
	static int[] ufarray;
	static int[] sizeArray;

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
			
			System.out.println("(999 to exit) enter p: ");
			int p = input.nextInt();
			
			if(p == 999){
				break;
			}
			
			System.out.println("enter q: ");
			int q = input.nextInt();
			
			union(p,q);
			
			System.out.println("ufarray");
			String ua = new String();
			for (int i = 0; i < ufarray.length; i++) {
				
				ua += " "+ufarray[i];
			}
			System.out.println(ua);
			System.out.println("sizeArray");
			String sa = new String();
			for (int i = 0; i < sizeArray.length; i++) {
				
				sa += " "+sizeArray[i];
			}
			System.out.println(sa);
						
		}while(true);
		


	}
	
	/*
	 * takes N iterations to initialize UF array.
	 */
	static void initialize(int n){
		
		ufarray = new int[n+1];
		sizeArray = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			
			ufarray[i] = i;
			sizeArray[i] = 1;
			
		}
	}
	
	/*
	 * 
	 */
	static void union(int p, int q){
		
		int p1 = find(p);
		int q1 = find(q);
		
		if(p1 == q1){
			System.out.println("connected");
		}else
		{
			System.out.println("union");
			int sp = sizeArray[p1];
			int sq = sizeArray[q1];
			
			if(sp < sq ){
				ufarray[p1] = q1;
				sizeArray[q1] += sp;
				
			}else
			{
				ufarray[q1] = p1;
				sizeArray[p1] += sq;
			}
		}
			
		
		
	}
	


	/*
	 * Returns the component identifier for the component containing site <tt>p</tt>.
	 */
	static int find(int p){

		while(p != ufarray[p]){
			p = ufarray[p];
		}
		
		return p;
	}
	
	

}
