package sequences;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubNoRepeatingChar {
	public static void main(String args[]) {
		LongestSubNoRepeatingChar obj = new LongestSubNoRepeatingChar();
		String s = "pwwkew";
		System.out.println(obj.lengthOfLongestSubstring(s));
	}
	public int lengthOfLongestSubstring(String s) {	
		int start = 0;
		int lastIndex [] = new int[26];
	
		for (int i=0;i<lastIndex.length;i++)
			lastIndex[i]=-1;
		
		int maxLength= 0;
		for (int end = 0;end<s.length();end++) {
			char curChar = s.charAt(end);
			if (lastIndex[curChar-'a']>=start) { //in current window
				start = Math.max(start, lastIndex[curChar-'a']+1);
			}
			lastIndex[curChar-'a'] = end;
			maxLength=Math.max(maxLength,end-start+1);
		}
		return maxLength;
	}

}
