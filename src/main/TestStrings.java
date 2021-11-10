package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestStrings {
	
	// Convert a string to a character list so it can be sorted
		public static char[] stringToCharList(String str){
			//List<Character> chars = str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return chars;
		}
		
		public static boolean testRegex(String str, String regex) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			return m.find();
		}
		
		public static String testGetSubStringWRegex(String str, String regex) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			if(m.find())
				return m.group();
			else
				return "Not found";
		}
		
		// Remove all substrings part from s starting from the left most
		public static String removeOccurrences(String s, String part) {
		    final int n = s.length();
		    final int k = part.length();

		    StringBuilder sb = new StringBuilder(s);
		    int j = 0; // sb's index

		    for (int i = 0; i < n; ++i) {
		    	System.out.println(j );
		      sb.setCharAt(j++, s.charAt(i));
		      System.out.println(j );
		      if (j >= k && sb.substring(j - k, j).toString().equals(part)) {
		    	  j -= k;
		      }
		     
		    }

		    return sb.substring(0, j).toString();
		  }
		

		public static void main(String[] args) {
			String test = "ifuyqjaf";
			System.out.println(removeOccurrences("ccctltctlltlb", "ctl"));

		}

}
