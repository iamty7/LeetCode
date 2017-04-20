package easy;

public class ReverseStringII {
	/*
	 * Given a string and an integer k, you need to reverse the first k
	 * characters for every 2k characters counting from the start of the string.
	 * If there are less than k characters left, reverse all of them. If there
	 * are less than 2k but greater than or equal to k characters, then reverse
	 * the first k characters and left the other as original. 
	 * 
	 * Example: Input: s = "abcdefg", k = 2 
	 * Output: "bacdfeg" 
	 * 
	 * Restrictions: 
	 * The string consists of lower English letters only. 
	 * Length of the given string and k will in the
	 * range [1, 10000]
	 */
	
	public String reverseStr(String s, int k) {
		// Your runtime beats 74.59% of java submissions. Runtime 7ms
		char[] chars = s.toCharArray();
		int ks = s.length() / k;

		for (int i = 0; i < ks; i += 2) {
			int l = k * i, r = k * (i + 1) - 1;
			while (l < r) {
				char tmp = chars[l];
				chars[l] = chars[r];
				chars[r] = tmp;
				l++;
				r--;
			}
		}
		if (ks % 2 == 0) {
			int l = ks * k, r = chars.length - 1;
			while (l < r) {
				char tmp = chars[l];
				chars[l] = chars[r];
				chars[r] = tmp;
				l++;
				r--;
			}
		}
		return new String(chars);
	}
	
	 public String reverseStr2(String s, int k) {
		 // Your runtime beats 59.71% of java submissions. Runtime 8ms
	        char[] arr = s.toCharArray();
	        int n = arr.length;
	        int i = 0;
	        while(i < n) {
	            int j = Math.min(i + k - 1, n - 1);
	            swap(arr, i, j);
	            i += 2 * k;
	        }
	        return String.valueOf(arr);
	    }
	    private void swap(char[] arr, int l, int r) {
	        while (l < r) {
	            char temp = arr[l];
	            arr[l++] = arr[r];
	            arr[r--] = temp;
	        }
	    }
}
