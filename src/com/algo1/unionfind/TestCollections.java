package com.algo1.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lst = new ArrayList<String>();
		lst.iterator();
		
		
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("1","a");
		hmap.put("2","b");
		hmap.put("3","c");
		hmap.put("4","d");
		hmap.put("5","e");
		System.out.println(hmap.put("5","f")); 
		
		System.out.println(hmap);
		System.out.println(hmap.entrySet());
		
		Iterator it = hmap.keySet().iterator();
		
		while(it.hasNext()){
			System.out.println(hmap.get(it.next()));
		}
		
	//	Map.Entry<String, String> me = (Map.Entry<String, String>) hmap.entrySet();

		for(Map.Entry<String, String> me : hmap.entrySet()){
			System.out.println(me.getKey() + me.getValue());
		}
		
	
		String ts = "this is a long string";
		char[] cs = ts.toCharArray();
		System.out.println(cs);
		
		String tt = Arrays.toString(cs);
		System.out.println(tt);
		
		
	}

}
