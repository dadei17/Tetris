// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import junit.framework.TestCase;

public class StringCodeTest extends TestCase {
	//
	// blowup
	//
	StringCode s = new StringCode();
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	public void testBlowup4() {
		assertEquals("222118", StringCode.blowup("3218"));
		assertEquals("abbbbb", StringCode.blowup("a4b5"));
		assertEquals("a", StringCode.blowup("a"));
		assertEquals("2aaabbbb", StringCode.blowup("12a3b"));
	}
	
	
	//
	// maxRun
	//
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	
	public void testRun4() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(4, StringCode.maxRun("aa3ccc1111"));
		assertEquals(3, StringCode.maxRun("gg321ttt33vVvv"));
		assertEquals(1, StringCode.maxRun("f3u90"));
		assertEquals(5, StringCode.maxRun("ggggg"));
	}

	
	//
	//stringIntersect
	//
	
	public void testIntersect1() {
		assertEquals(false, StringCode.stringIntersect("hoo","",6));
		assertEquals(false, StringCode.stringIntersect("hoopllla", "asf", 4));
	}
	
	public void testIntersect2() {
		assertEquals(true, StringCode.stringIntersect("hoopla","hoopllla",5));
		assertEquals(true, StringCode.stringIntersect("hoopllla","lll",3));
		assertEquals(false, StringCode.stringIntersect("hoopllla","llbl",4));
	}
	
	public void testIntersect3() {
		assertEquals(true, StringCode.stringIntersect("abcccc", "sdfbccccbac",5));
		assertEquals(true, StringCode.stringIntersect("aabc", "bcbcbcbcbcbc", 2));
		assertEquals(false, StringCode.stringIntersect("aabc", "bcbcbcbcbcbc", 3));
		assertEquals(true, StringCode.stringIntersect("aabc", "bcbcbcbcbcbc", 1));
	}
	
	public void testIntersect4() {
		assertEquals(true, StringCode.stringIntersect("12127424","1237429",3));
		assertEquals(true, StringCode.stringIntersect("11ghsv12hj", "s5hhsv12", 4));
		assertEquals(true, StringCode.stringIntersect("11ghsv126", "s5jkshhsv126", 5));
		assertEquals(false, StringCode.stringIntersect("11ghsv126", "s5jkshh2", 2));
	}
	
}
