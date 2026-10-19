//https://leetcode.com/problems/maximum-subarray/
class Solution{
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
       int mx=nums[0],curr=nums[0]; //initialize both as the first element if in case there is only one element in the array
       for(int i=1;i<nums.length;i++){
            // curr+=nums[i];   //this vesion works if we are not handling negative values
            // if(curr<0){
            //     curr=0;      //classic reseting to 0 , kadane's version
            //     curr+=nums[i];
            // }
            curr=Math.max(nums[i],curr+nums[i]);    //should i start from this index or extend the previous index and this version handles negative values also i.e doesnt take 
            mx=Math.max(mx,curr);
       }
       return mx;
    }
}
//not good
// int n=nums.length;
// int sum=nums[0];
// int mx=nums[0];
// for(int i=1;i<n;i++){
//     if(sum<0){
//         sum=0;
//         sum+=nums[i];
//         mx=Math.max(sum,mx);
//     }
//     else{
//         sum+=nums[i];
//         mx=Math.max(sum,mx);

//     }
// }
// return mx;