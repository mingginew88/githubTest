package i_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection04 {
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++){
			System.out.println(set.add((int)(Math.random()*45+1)));
		}
		
		System.out.println(set);
		
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		System.out.println(list);
		
		Set<Integer> set2 = new HashSet<Integer>(list);
		System.out.println(set2);
		System.out.println(set2);
		
		
		
		
		
		
	}

}
