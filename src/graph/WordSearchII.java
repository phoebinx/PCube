package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

//https://www.youtube.com/watch?v=5Ha1nJ5rjrE
//https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
	public static void main(String args[]) {
		WordSearchII obj = new WordSearchII();
//		char board[][] = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
//				{ 'i', 'f', 'l', 'v' } };
//		String words[] = { "oath", "pea", "eat", "rain" };
		char board[][] = { { 'a', 'b' }, { 'a', 'a' } };
		String words[] = { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" };
		System.out.println(obj.findWords(board, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0)
			return res;
		TrieNode root = new TrieNode();
		buildTree(root, words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (root.children[c - 'a'] != null) {
					dfs(board, i, j, root, res);
				}
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length-1)
			return;
		if (board[i][j] == '#')
			return;
		char c = board[i][j];

		if (cur.children[c - 'a'] == null)
			return;
		cur = cur.children[c - 'a'];
		if (cur.word != null) {
			res.add(cur.word);
			cur.word = null;
		}
		board[i][j] = '#';
		dfs(board, i + 1, j, cur, res);
		dfs(board, i - 1, j, cur, res);
		dfs(board, i, j + 1, cur, res);
		dfs(board, i, j - 1, cur, res);
		board[i][j] = c;
	}

	public void buildTree(TrieNode root, String[] words) {
		for (String word : words) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				int index = (int) c - 'a';
				if (cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				cur = cur.children[index];
			}
			cur.word = word;
		}
	}

	class TrieNode {
		TrieNode[] children;
		String word;

		TrieNode() {
			children = new TrieNode[26];
			word = null;
		}

	}

}

//public List<String> findWords(char[][] board, String[] words) {
//	HashSet<String> result = new HashSet<>();
//	TreeSet<String> wordSet = new TreeSet<>(Arrays.asList(words));
//	for (int i = 0; i < board.length; i++) {
//		for (int j = 0; j < board[0].length; j++) {
//			findWordsUtil(Character.toString(board[i][j]), i, j, board, wordSet, result, Integer.MIN_VALUE, Integer.MIN_VALUE);
//		}
//	}
//	return new ArrayList<>(result);
//}
//
//public void findWordsUtil(String word, int i, int j, char[][] board, TreeSet<String> wordSet, HashSet<String> result , int lastI, int lastJ) {
//	if (wordSet.contains(word)) {
//		result.add(word);
//	}
//	int x[] = { 1, -1, 0, 0 };
//	int y[] = { 0, 0, 1, -1 };
//	for (int k = 0; k < 4; k++) {
//		if (util(board, i + x[k], j + y[k], word, wordSet, lastI, lastJ)) {
//			findWordsUtil(word + board[i + x[k]][j + y[k]], i + x[k], j + y[k], board, wordSet, result, i, j);
//		}
//	}
//}
//
//public boolean util(char[][] board, int i, int j, String word, TreeSet<String> wordSet, int lastI, int lastJ) {
//	if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && !(i==lastI && j==lastJ)
//			&& !wordSet.subSet(word + board[i][j], word + board[i][j] + "zzz").isEmpty())
//		return true;
//	return false;
//}