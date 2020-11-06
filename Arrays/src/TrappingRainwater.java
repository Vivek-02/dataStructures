public class TrappingRainwater {
	
	/* Given n non-negative integers representing an elevation map where the width of each bar is 1,
	compute how much water it is able to trap after raining */
	public static int getRainwater(int[] height) {
        int n = height.length;
        
        int[] left = new int[n];
        left[0] = height[0];
        
        int[] right = new int[n];
        right[n-1] = height[n-1];
        
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        
        int water = 0;
        
        for(int i=0;i<n;i++){
            water+=Math.min(left[i],right[i])-height[i];
        }
        
        return water;     
    }
	
	//Leetcode
	/*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
	 * n vertical lines are drawn such that the two end-points of the line i is at (i, ai) and (i, 0).
	 *  Find two lines, which, together with the x-axis forms a container, such that the container contains
	 *   the most water.*/
	
	public int maxArea(int[] height) {
        int maxarea=Integer.MIN_VALUE;
        
        int i=0,j=height.length-1;
        
        while(i<j){
            int area = Math.min(height[i],height[j])*(j-i);
            maxarea = Math.max(maxarea,area);
            if(height[i]<=height[j])
                i++;
            else
                j--;
        }
        
        return maxarea;
    }
}
