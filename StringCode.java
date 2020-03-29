import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max = 0;
		int curr = 1;
		for(int i=0; i<str.length() - 1; i++) {
			char firstChar = str.charAt(i);
			char secChar = str.charAt(i + 1);
			if(firstChar == secChar) {
				curr++;
				/** if previous character is equal to the next and 
				we are already on last character and we have to check max.*/
				if(i == str.length() - 2) {
					if(curr > max) max = curr;
				}
			}else {
				if(curr > max) max = curr;
				curr = 1;
			}
		}
		return max; 
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String res = "";
		if(str.isEmpty()) return res;
		for(int i=0; i<str.length()-1; i++) {
			char curr = str.charAt(i);
			if(Character.isDigit(curr)) {
				int range = Character.getNumericValue(curr);
				char nextChar = str.charAt(i + 1);
				for(int j=0; j<range; j++) {
					res += nextChar;
				}
			}else {
				res += curr;
			}
		}
		char lastChar = str.charAt(str.length() - 1);
		if(!Character.isDigit(lastChar)) res += lastChar;
		
		return res;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(a.length()<len || b.length()<len) return false;
		HashSet<String> hash = new HashSet<String>();
		for(int i=0; i<a.length()-len+1;i++) {
			String sub = a.substring(i, i+len);
			hash.add(sub);
		}
		for(int i = 0; i<b.length() -len + 1; i++) {
			String sub = b.substring(i, i+len);
			if(hash.contains(sub)) return true;
		}
		return false;
	}
}
