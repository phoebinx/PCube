package arrays;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
public class MinimumMovestoEqualArrayElements {
	public static void main(String args[]) {
		int nums[] = { 1, 2, 3 };
		MinimumMovestoEqualArrayElements obj = new MinimumMovestoEqualArrayElements();
		System.out.println(obj.minMoves(nums));
	}

	public int minMoves(int[] nums) {
		int min = nums[0];
		for (int e:nums) min=Math.min(min, e);
		int res = 0;
		for (int e:nums) res+=e-min;
		return res;
	}
}

//Adding 1 to n - 1 elements (untill smallest reaches the highest) is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
//So, best way to do this is make all the elements in the array equal to the min element. (subtract 1 from each element to reach the lowest instead of adding 1 to n-1 elements to reach the ighest)