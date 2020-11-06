/* Given an array containing only 0s and 1s, find the largest subarray
 which contains equal no of 0s and 1s. The expected time complexity is O(n).*/

import java.util.HashMap;

public class EqualIntegers {
	
	public static int maxLengthWithEqual01(int[] arr) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int n=arr.length;
		int sum=0;
		int max_len=0;
		int end_index = -1;
		int start_index = 0;
		
		for(int i=0;i<n;i++) {
			arr[i]=(arr[i]==0?-1:1);
		}
		
		
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			
			if(sum==0) {
				max_len=i+1;
				end_index=i;
			}
				
			if(map.containsKey(sum+n)) {
				if(max_len<i-map.get(sum+n)) {
					max_len = i-map.get(sum+n);
					end_index=i;
				}
			}else
				map.put(sum+n,i);
		}
		
		
		for(int i=0;i<n;i++) {
			arr[i]=(arr[i]==-1?0:1);
		}
		
		return max_len;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 0, 1, 0, 1, 1};
		System.out.println(maxLengthWithEqual01(arr));
	}
}