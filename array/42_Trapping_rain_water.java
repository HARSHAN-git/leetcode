// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        //we need to keep track of leftmax and rightmax while moving left and right
        //if value of left<=right move left else right
        int mxarea=0;
        int left=0;
        int right=height.length-1;
        int leftmax=0;
        int rightmax=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>leftmax){
                    leftmax=height[left];
                }
                else{
                    mxarea+=leftmax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>rightmax){
                    rightmax=height[right];
                }
                else{
                    mxarea+=rightmax-height[right];
                }
                right--;
            }
        }
        return mxarea;
    }
}