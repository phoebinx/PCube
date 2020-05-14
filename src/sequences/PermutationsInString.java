package sequences;

//https://leetcode.com/problems/permutation-in-string/
public class PermutationsInString {
	public static void main(String args[]) {
		String s1 = "ab", s2 = "eidbaooo";
		PermutationsInString obj = new PermutationsInString();
		System.out.println(obj.checkInclusion(s1, s2));
	}

	public boolean checkInclusion(String s1, String s2) {
		int s1Arr[] = new int[26];
		for (int j = 0; j < s1.length(); j++) {
			s1Arr[s1.charAt(j) - 'a']++;
		}

		int start = 0;
		int s2Arr[] = s1Arr.clone();
		for (int end = 0; end < s2.length(); end++) {
			if (start > end)
				return false;
			if (s2Arr[s2.charAt(end) - 'a'] > 0) {
				s2Arr[s2.charAt(end) - 'a']--;
				if (isBlank(s2Arr))
					return true;

			} else {
				s2Arr[s2.charAt(start) - 'a']++;
				start++;
				--end;
			}
		}
		return false;
	}

	public boolean isBlank(int[] arr) {
		for (int i : arr) {
			if (i != 0)
				return false;
		}
		return true;
	}
}
