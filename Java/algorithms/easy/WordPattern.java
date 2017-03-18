package easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Examples: 
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	 * pattern = "abba", str = "dog cat cat fish" should return false. 
	 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
	 * pattern = "abba", str = "dog dog dog dog" should return false. 
	 * 
	 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase
	 * letters separated by a single space.
	 */

	public boolean solution(String pattern, String str) {
		// Your runtime beats 16.29% of java submissions. Runtime 3ms
		String[] arrayStr = str.split(" ");
		if(pattern.length()!=arrayStr.length)
			return false;
		char[] arrayPat = pattern.toCharArray();
		HashMap<Character, String> map= new HashMap<>();
		
		for(int i=0;i<arrayPat.length;i++){
			if(map.containsKey(arrayPat[i])){
				if(!map.get(arrayPat[i]).equals(arrayStr[i]))
					return false;
			}
			else{
				if(map.containsValue(arrayStr[i]))
					return false;
				map.put(arrayPat[i], arrayStr[i]);
			}
		}
		
		return true;
	}
	
	public boolean solution2(String pattern, String str) {
		// Your runtime beats 39.66% of java submissions. Runtime 2ms
		String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
}
