package sequences;

//https://www.youtube.com/watch?v=y2BD4MJqV20&t=748s
//https://leetcode.com/problems/longest-palindromic-substring/
public class LonggestPallindromicSubSring {
	public static void main(String args[]) {
		LonggestPallindromicSubSring obj = new LonggestPallindromicSubSring();
		String s = "a";
		System.out.println(obj.longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		if (s==null)
			return "";
		if (s.length()==1)
			return s;
		int maxLen = 0;
		int maxStart = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int selfPal = pallindromeLen(i, i, s);
			int pairPal = pallindromeLen(i, i + 1, s);
			int maxSelf = Math.max(selfPal, pairPal);
			if (maxLen < maxSelf) {
				maxLen = maxSelf;
				maxStart = i - ((maxSelf - 1) / 2);
			}
		}
		System.out.println(maxLen);
		return maxLen > 0 ? s.substring(maxStart, maxStart + maxLen) : "";
	}

	public int pallindromeLen(int i, int j, String s) {
		int len = 0;
		if (s == null || i > j || i < 0 || j > s.length() - 1)
			return len;

		if (i == j)
			len--;

		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				len = len + 2;
				i--;
				j++;
			} else {
				break;
			}
		}
		return len;
	}
}
