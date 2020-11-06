import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {
	
	/* Given an array arr[] of size n where every element is in range from 0 to n-1. 
	Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space. */
	public static void rearrangeArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			arr[i]+=(arr[arr[i]]%n)*n;
		}
		
		for(int i=0;i<n;i++) {
			arr[i]/=n;
			System.out.print(arr[i]+" ");
		}
	}
	
	/* Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value,
	second minimum value, third second max, fourth second min and so on. */
	public static void rearrangeMaxMin(int[] arr) {
		int n=arr.length;
		int max_ind = n-1, min_ind = 0;
		int max_element = arr[n-1]+1;
		
		for(int i=0;i<n;i++) {
			
			if(i%2==0)
				arr[i]+=(arr[max_ind--]%max_element)*max_element;
			
			if(i%2!=0)
				arr[i]+=(arr[min_ind++]%max_element)*max_element;
		}
		
		for(int i=0;i<n;i++) {
			arr[i]/=max_element;
			System.out.print(arr[i]+" ");
		}
	}
}
