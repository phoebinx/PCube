package dp;
//https://www.youtube.com/watch?v=z6wr9E-Bm1c
//https://leetcode.com/problems/edit-distance/
public class EditDistance {
	public static void main(String args[]) {
		EditDistance obj = new EditDistance();
		String word1 = "horse", word2 = "ros";
		System.out.println(obj.minDistance(word1, word2));
	}

	public int minDistance(String word1, String word2) {
		int grid[][] = new int[word1.length()+1][word2.length()+1];
		for (int i=0;i<=word1.length();i++) {
			grid[i][0] = i;
		}
		for (int j=0;j<=word2.length();j++) grid[0][j] = j;
		
		for (int i =0;i<word1.length();i++) {
			for (int j=0;j<word2.length();j++) {
				char c1 = word1.charAt(i);
				char c2 = word2.charAt(j);
				if (c1==c2) grid[i+1][j+1] = grid[i][j];
				else {
					grid[i+1][j+1] = Math.min(grid[i][j], Math.min(grid[i][j+1], grid[i+1][j]))+1;
				}
			}
		}
		return grid[word1.length()][word2.length()];
	}
}
