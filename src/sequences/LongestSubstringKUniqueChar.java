package sequences;

import java.util.HashMap;

//https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
//O(n)
public class LongestSubstringKUniqueChar {
	public static void main(String args[]) {
		String s = "abcbdbdbbdcdabd";
		int k = 5;
		LongestSubstringKUniqueChar obj = new LongestSubstringKUniqueChar();
		System.out.println(obj.LongestSubstringKUniqueChars(s, k));
	}

	public String LongestSubstringKUniqueChars(String s, int k) {
		HashMap<Character, Integer> curWindowMap = new HashMap<>();
		int start = 0, maxStart = 0;
		int maxLen = 0;

		for (int end = 0; end < s.length(); end++) {
			char curChar = s.charAt(end);
			if (curWindowMap.containsKey(curChar))
				curWindowMap.put(curChar, curWindowMap.get(curChar) + 1);
			else
				curWindowMap.put(curChar, 1);

			while (curWindowMap.size() > k) { // total unique char should always be less than k
				int curStartLen = curWindowMap.get(s.charAt(start));
				curWindowMap.put(s.charAt(start), curStartLen - 1);
				if (curStartLen-1==0) curWindowMap.remove(s.charAt(start));
				start++;
			}

			if (end - start + 1 > maxLen) {
				maxLen = Math.max(maxLen, end - start + 1);
				maxStart = start;
			}
		}

		return s.substring(maxStart, maxStart+maxLen);
	}
}
