// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
	
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testIntNoFollow1() {
		List<String> rules =  stringToList("acab");
		Taboo<String> t = new Taboo<String>(rules);
		Set<String> s = new HashSet<String>();
		s.add("c");
		s.add("b");
		assertEquals(s, t.noFollow("a"));
	}
	
	public void testIntNoFollow2() {
		List<String> rules =  stringToList("acbxca");
		Taboo<String> t = new Taboo<String>(rules);
		Set<String> s = new HashSet<String>();
		s.add("b");
		s.add("a");
		assertEquals(s, t.noFollow("c"));
	}
	
	//Empty Set.
	public void testIntNoFollow3() {
		List<String> rules =  stringToList("acbxca");
		Taboo<String> t = new Taboo<String>(rules);
		Set<String> s = new HashSet<String>();
		assertEquals(s, t.noFollow("h"));
	}
	
	public void testReduce1() {
		List<String> rules = stringToList("acab");
		List<String> first =  stringToList("acbxca");
		List<String> end = stringToList("axc");
		Taboo<String> t = new Taboo<String>(rules);
		t.reduce(first);
		assertEquals(true, first.equals(end));
	}
	
	public void testReduce2() {
		List<String> rules = stringToList("acab");
		List<String> first =  stringToList("acbxca");
		List<String> end = stringToList("axc");
		Taboo<String> t = new Taboo<String>(rules);
		t.reduce(first);
		assertEquals(true, first.equals(end));
	}
	
	public void testReduce3() {
		List<String> rules = stringToList("acab");
		List<String> first =  stringToList("acbxcacccc");
		List<String> end = stringToList("axccccc");
		Taboo<String> t = new Taboo<String>(rules);
		t.reduce(first);
		assertEquals(true, first.equals(end));
	}
	
	public void testReduce4() {
		List<String> rules = stringToList("acab");
		List<String> first =  stringToList("acab");
		List<String> end = stringToList("a");
		Taboo<String> t = new Taboo<String>(rules);
		t.reduce(first);
		assertEquals(false, first.equals(end));
	}
	
	// null in string
	public void testReduce5() {
		List<String> rules = stringToList("ac");
		rules.add(null);
		rules.add("a");
		rules.add("b");
		List<String> first =  stringToList("bcacc");
		List<String> end = stringToList("bca");
		Taboo<String> t = new Taboo<String>(rules);
		t.reduce(first);
		assertEquals(true, first.equals(end));
	}
	
	// integers
	public void testReduce6() {
		List<Integer> rules  = new ArrayList<Integer>(); //012324
		for(int i =0; i<5; i++) {
			rules.add(i);
			if(i == 3) {
				rules.add(2);
			}
		}
		List<Integer> first =  new ArrayList<Integer>(); //234120
		first.add(2);
		first.add(3);
		first.add(4);
		first.add(1);
		first.add(2);
		first.add(0);
		List<Integer> end = new ArrayList<Integer>(); //210
		end.add(2);
		end.add(1);
		end.add(0);
		Taboo<Integer> t = new Taboo<Integer>(rules);
		t.reduce(first);
		assertEquals(true, first.equals(end));
		first.clear();
		assertEquals(false, first.equals(end));
	}
	
	
	
	
	
}


