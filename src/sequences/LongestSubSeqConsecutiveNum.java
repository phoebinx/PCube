package sequences;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestSubSeqConsecutiveNum {
	public static void main(String args[]) {
		LongestSubSeqConsecutiveNum obj = new LongestSubSeqConsecutiveNum();
		Integer arr[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println(obj.longestConsecutive(arr));
	}

	public int longestConsecutive(Integer[] nums) {
		HashSet<Integer> numSet = new HashSet<>(Arrays.asList(nums));
		int maxLength = 0;
		int count;
		for (int num : numSet) {
			if (!numSet.contains(num - 1)) {
				count = 1;
				while (numSet.contains(num + count))
					count++;
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}
}
