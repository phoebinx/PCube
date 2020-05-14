package sequences;
//https://www.youtube.com/watch?v=00FmUN1pkGE
//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharacterReplacement {
	public static void main(String args[]) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		String s = "ABAB";
		int k = 2;
		System.out.println(obj.characterReplacement(s, k));
	}
	
	public int characterReplacement(String s, int k) {
		int charCount [] = new int[26];
		int maxCount=0;//maxFree in current window
		int maxLength = 0;
		int start = 0;
		
		for (int end = 0;end<s.length();end++) {
			char curChar = s.charAt(end);
			maxCount = Math.max(maxCount, ++charCount[curChar-'A']);
			while (end-start+1-maxCount>k) {
				start++;
				charCount[s.charAt(start)-'A']--;
			}
			maxLength = Math.max(maxLength, end-start+1);
		}
		
		return maxLength;
	}
}
//use sliding window approahch
//maintain maxFreq of character in current window
//check if non matching character len is > k, move window if so
//maintain maxLength which is longest length of repeating char which can be replaced.