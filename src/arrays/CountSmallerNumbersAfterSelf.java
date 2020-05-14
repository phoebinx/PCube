package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountSmallerNumbersAfterSelf {
	public static void main(String args[]) {
		CountSmallerNumbersAfterSelf obj = new CountSmallerNumbersAfterSelf();
		//int nums[] = { 26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		int nums[] = { 26,78,27,100,33,67,90,23,66,5,38,7,35,23};
		System.out.println(obj.countSmaller(nums));
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<>();
		List<Integer> sortedSet = new ArrayList<>();
		int index;
		for (int i = nums.length - 1; i >= 0; i--) {
			index = findElementPosition(nums[i], sortedSet);
			sortedSet.add(nums[i]);
			Collections.sort(sortedSet);
			result.add(index + 1);
		}
		Collections.reverse(result);
		return result;
	}

	private int findElementPosition(int num, List<Integer> sortedList) {
		int index = sortedList.size()-1;
		while (index >= 0 && sortedList.get(index) >= num) {
			index--;
		}
		return index;
	}

}
