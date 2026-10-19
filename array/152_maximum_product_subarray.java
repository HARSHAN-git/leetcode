//https://leetcode.com/problems/maximum-product-subarray/
//need to remeber
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return -1;
        }
       int mx=nums[0],currmx=nums[0],currmin=nums[0]; 
       for(int i=1;i<nums.length;i++){
            int tempmx=currmx;
            int tempmin=currmin;
            //1.check if we take curr element
            //2.max extend curr using mx curr or min curr 
            //3.min extend curr using mx curr or min curr
            currmx=Math.max(nums[i],Math.max(tempmx*nums[i],tempmin*nums[i]));
            currmin=Math.min(nums[i],Math.min(tempmx*nums[i],tempmin*nums[i]));
            mx=Math.max(mx,currmx); //atlast we will have currmx doing the heavy lifting 
       }
       return mx;
    }
}