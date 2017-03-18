package easy;


public class MergeSortedArray {

	public void solution(int[] nums1, int m, int[] nums2, int n) {
		
		// Your runtime beats 5.94% of java submissions. Runtime 1ms
		int i = 0, j = 0, k = 0;
		int[] tmp = new int[nums1.length];
		
		if(n==0)
			return;
		if(m==0){
			while(k<n){
				nums1[k] = nums2[k];
				k++;
			}
			return;
		}
		
		
		while(i<m && j<n){
			if(nums1[i] > nums2[j]){
				tmp[k] = nums2[j];
				++j;
				++k;
			}
			else if (nums1[i] < nums2[j]) {
				tmp[k] = nums1[i];
				++i;
				++k;
			}
			else {
				tmp[k] = nums1[i];
				tmp[k+1] = nums2[j];
				k+=2;
				++i;
				++j;
			}
		}
		
		//There still some nums left in nums1
		if(i!=m)
			while (i<m) {
				tmp[k] = nums1[i];
				k++;
				i++;
			}
		
		k = 0;
		while(k<i+j){
			nums1[k] = tmp[k];
			++k;
		}
		
		//There still some nums left in nums2
		while(j<n){
			nums1[k] = nums2[j];
			++j;
			++k;
		}
		
			
	}
	
	
	public void solution2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		while (j >= 0)
			nums1[k--] = nums2[j--];
	}
	
}
