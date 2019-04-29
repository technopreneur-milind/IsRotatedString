package com.example.demo.RoateString;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.execute("abcdabceabcd", "abcdabcdabce"));
	}

	private boolean execute(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length())
			return false;
		List<Integer> matchedIndices= new ArrayList<Integer>();
		for (int index = 0; index < str1.length(); index++) {
			if (str1.charAt(index) == str2.charAt(0)) {
				matchedIndices.add(index);
			}
		}

		// now check
		boolean matched = true;
		for(int nextMatch : matchedIndices)
		{
			matched = true;
			int firstIndex = nextMatch +1;
			for (int index = 1; index < str2.length(); index++) {
				if (firstIndex >= str1.length())
					firstIndex = 0;
				if (str2.charAt(index) != str1.charAt(firstIndex++)) {
					matched = false;
					break;
				}
			}
			if(matched)
				break;
		}
		return matched;
	}
}
