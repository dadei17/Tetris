import java.util.*;

import sun.security.util.Length;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int res = 0;
		Map<T,Integer> first = counter(a);
		Map<T,Integer> sec = counter(b);
		for(T curr : first.keySet()) {
			if(!sec.containsKey(curr)) continue;
			if(first.get(curr) == sec.get(curr)) res++;
		}
		return res; 
	}
	
	private static <T> Map<T,Integer> counter(Collection<T> a){
		Map<T,Integer> mp = new HashMap<T,Integer>();
		Iterator<T> major = a.iterator();
		while(major.hasNext()) {
			T curr = major.next();
			int count = 0;
			if(mp.containsKey(curr)) continue;
			Iterator<T> sec = a.iterator();
			while(sec.hasNext()) {
				T changer = sec.next();
				if(curr.equals(changer)) {
					count ++;
				}
			}
			mp.put(curr, count);
		}
		return mp;
	}
	
}
