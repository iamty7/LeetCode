package easy;

public class StudentAttendanceRecordI {
	/*
	 * You are given a string representing an attendance record for a student.
	 * The record only contains the following three characters:
	 * 
	 * 'A' : Absent. 'L' : Late. 'P' : Present. A student could be rewarded if
	 * his attendance record doesn't contain more than one 'A' (absent) or more
	 * than two continuous 'L' (late).
	 * 
	 * You need to return whether the student could be rewarded according to his
	 * attendance record.
	 * 
	 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL"
	 * Output: False
	 */

	public boolean checkRecord(String s) {
		// Your runtime beats 50.27% of java submissions. Runtime 10ms
		char[] chars = s.toCharArray();
		int as = 0, ls = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'A') {
				as++;
				if (as > 1)
					return false;
				ls = 0;
			} else if (chars[i] == 'L') {
				ls++;
				if (ls == 3)
					return false;
			} else
				ls = 0;
		}
		return true;
	}
}
