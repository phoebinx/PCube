package dp;

public class LongestCommonSubSeq {
	char t1[] = "mbadm".toCharArray();
	char t2[] = "mdabm".toCharArray();

	public static void main(String args[]) {
		LongestCommonSubSeq obj = new LongestCommonSubSeq();
		System.out.println(obj.longestSub(obj.t1.length, obj.t2.length));
	}

	public int longestSub(int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (t1[n - 1] == t2[m - 1]) {
			return 1 + longestSub(n - 1, m - 1);
		} else {
			int temp1 = longestSub(n, m - 1);
			int temp2 = longestSub(n - 1, m);

			return Math.max(temp1, temp2);
		}
	}
}
