package tree;

import java.util.Arrays;
import java.util.List;


public class CountSmallerNumbersAfterSelf {
	public static void main(String args[]) {
		int nums[] = {5,2,6,1};
		CountSmallerNumbersAfterSelf obj = new CountSmallerNumbersAfterSelf();
		System.out.println(obj.countSmaller(nums));
	}
	
	public List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		Node root = null;
		for (int i=nums.length-1;i>=0;i--) {
			root = insertNode(nums[i], root, ans,i,0);
		}
		return Arrays.asList(ans);
	}
	
	private Node insertNode(int num, Node node, Integer[] ans, int i, int preSum) {
		if (node ==null ) {
			node = new Node(num,0);
			ans[i] = preSum;
		} else if (node.val==num) {
			node.dup++;
			ans[i] = preSum+node.sum;
		} else if (node.val>num) {
			node.sum++;
			node.left= insertNode(num, node.left, ans, i, preSum);
		} else {
			node.right=insertNode(num, node.right, ans, i, preSum+node.sum+node.dup);
		}
		return node;
	}
	
	class Node {
		Node left,right;
		int val, sum,dup=1;
		Node(int val, int sum) {
			this.val = val;
			this.sum = sum;
		}
	}
}
