package medium;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord_DataStructureDesign {
	/*
	 * Design a data structure that supports the following two operations:
	 * 
	 * void addWord(word) bool search(word) search(word) can search a literal
	 * word or a regular expression string containing only letters a-z or .. A .
	 * means it can represent any one letter.
	 * 
	 * For example:
	 * 
	 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
	 * search("bad") -> true search(".ad") -> true search("b..") -> true Note:
	 * You may assume that all words are consist of lowercase letters a-z.
	 */

	private WordNode root;

	/** Initialize your data structure here. */
	public AddAndSearchWord_DataStructureDesign() {
		// Your runtime beats 8.29% of java submissions. Runtime 289
		root = new WordNode('0', new HashMap<>());
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		WordNode curRoot = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!curRoot.child.containsKey(c))
				curRoot.child.put(c, new WordNode(c, new HashMap<>()));
			curRoot = curRoot.child.get(c);
		}
		// !! 0 represents the ending of a word
		curRoot.child.put('0', new WordNode('0', new HashMap<>()));
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return helper(word, 0, this.root);
	}

	private boolean helper(String word, int pos, WordNode curRoot) {

		for (int i = pos; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (char key : curRoot.child.keySet())
					if (helper(word, i + 1, curRoot.child.get(key)))
						return true;
				return false;
			}
			if (!curRoot.child.containsKey(c))
				return false;
			else
				curRoot = curRoot.child.get(c);
		}
		// !! 0 represents the ending of a word
		if (curRoot.child.containsKey('0'))
			return true;
		else
			return false;
	}

	private class WordNode {
		char value;
		Map<Character, WordNode> child;

		public WordNode(char c, HashMap child) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.child = child;
		}
	}

	/*
	 * !!Use array instead of hashmap to locate the char acording to diff with
	 * 'a' However this way may take up to much space if the word is not so
	 * short. For example, for "abcdefg" it takes 26^7 units, while hashmap takes 7 
	 */
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}

	private TrieNode root2 = new TrieNode();

	public void addWord2(String word) {
		TrieNode node = root2;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	public boolean search2(String word) {
		return match(word.toCharArray(), 0, root2);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length)
			return !node.item.equals("");
		if (chs[k] != '.') {
			return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					if (match(chs, k + 1, node.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
