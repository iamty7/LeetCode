package string.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	/*
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */

	public int solution(String s) {
		// Your runtime beats 38.03% of java submissions. Runtime 109ms
		int sum = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			switch (s.charAt(i)) {
			case 'I':
				sum += sum >= 5 ? -1 : 1;
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				sum += sum >= 50 ? -10 : 10;
				break;
			case 'L':
				sum += 50;
				break;
			case 'C':
				sum += sum >= 500 ? -100 : 100;
				break;
			case 'D':
				sum += 500;
				break;
			case 'M':
				sum += sum >= 5000 ? -1000 : 1000;
				break;

			default:
				break;
			}
		}

		return sum;
	}

	public int solution2(String s) {
		// Your runtime beats 13.52% of java submissions. Runtime 120ms
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			sum += map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)) ? map.get(s.charAt(i)) : -map.get(s.charAt(i));
		}
		sum += map.get(s.charAt(s.length() - 1));
		return sum;
	}

}
