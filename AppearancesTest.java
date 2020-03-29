import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	Appearances p = new Appearances();
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	public void testSameCount3() {
		List<String> a = stringToList("zbcd5");
		List<String> b = stringToList("s");
		assertEquals(0, Appearances.sameCount(a, b));
	}
	
	public void testSameCount4() {
		List<String> a = stringToList("zh cd5c88");
		List<String> b = stringToList("8a8b88");
		List<String> c = stringToList("8a8b88 ");
		assertEquals(0, Appearances.sameCount(a, b));
		assertEquals(1, Appearances.sameCount(a, c));
		assertEquals(3, Appearances.sameCount(c, b));
	}
	
	public void testSameCount5() {
		List<String> a = stringToList("zhcd5c88asdgxz");
		List<String> b = stringToList("");
		assertEquals(0, Appearances.sameCount(a, b));
	}
	
	public void testSameCount6() {
		List<String> a = stringToList("b  a ");
		List<String> b = stringToList("  h ");
		assertEquals(1, Appearances.sameCount(a, b));
	}
	
}
