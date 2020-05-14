package dp;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("Longest subsequence is: " + getLongestSeq2(arr));
	}

	public static int getLongestSeq(int arr[]) {
		Integer[] lis = new Integer[arr.length];

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		int d = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				d++;
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		System.out.println(d);
		return Collections.max(Arrays.asList(lis));
	}

	public static int getLongestSeq2(int arr[]) {
		Integer[] lis = new Integer[arr.length];

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		int d = 0;
		int max = 0;
		int totMax = 0;
		for (int i = 0; i < arr.length; i++) {
			max = 0;
			for (int j = i + 1; j < arr.length - 1; j++) {
				d++;
				if (arr[i] < arr[j]) {
					max++;
				}
			}
			totMax = Math.max(max, totMax);
		}
		System.out.println(d);
		return totMax;// Collections.max(Arrays.asList(lis));
	}

}
