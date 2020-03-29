
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	private List<T> rules;
	private Map<T,Set<T>> mp = new HashMap<T,Set<T>>();
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
		fillMap();
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	
	public Set<T> noFollow(T elem) {
		// if T has no rules.
		Set<T> empty = new HashSet<T>();
		if(!mp.containsKey(elem)) return empty;
		return mp.get(elem);
	}
	
	private void fillMap() {
		for(int i=0; i<rules.size()-1; i++) {
			T curr = rules.get(i);
			T next = rules.get(i+1);
			if(mp.containsKey(curr)) {
				Set<T> s = mp.get(curr);
				s.add(next);
			}else {
				Set<T> s = new HashSet<T>();
				s.add(next);
				mp.put(curr, s);
			}
		}
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i =0; i<list.size()-1; i++) {
			T elem = list.get(i);
			Set<T> s = noFollow(elem);
			T next = list.get(i+1);
			if(s.contains(next)) {
				list.remove(i+1);
				i--;
			}
		}
	}
}
