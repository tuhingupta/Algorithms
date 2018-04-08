package com.other.problems;

import java.lang.reflect.Array;

/**
 * @author Tuhin Gupta
 *
 */
public class SetUsingArray {
	
	public static void main(String[] args) {
		
		
		Set<String> ss = new Set<String>(String.class, 10);
		
		ss.put(new String("a"), 0);
		ss.put("b", 1);
		ss.put("c", 2);
		ss.put("d", 3);
		int t = ss.put("c", 4);
		
		System.out.format("c already present at %d \n", t);
		System.out.format("2nd element in Set is %s", ss.get(1) );
		
	}
	
	

}

class Set<E>{
	
	private E[] e;
	
	Set(Class<E> a, int t){
		
		@SuppressWarnings("unchecked")
		final E[] e = (E[])Array.newInstance(a, t);
		
		this.e = e;
	}
	
	E get(int i){
		return e[i];
	}
	
	int put(E v, int i){
		
		for (int j = 0; j < e.length; j++) {
			
			E ee = e[j];
			
			if( ee != null && ee.equals(v))
				return j;
			
		}
		
		if(i < e.length){
			e[i] = v;
			return i;
		}else
			return -1;
	
	}
	
}
