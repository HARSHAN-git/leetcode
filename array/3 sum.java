// https://leetcode.com/problems/3sum/description/
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> lst=new ArrayList<>();
       if(nums==null || nums.length<3){
         return lst;
       } 
       Arrays.sort(nums); //we need to apply binary search so
       //loop starts here
       for(int i=0;i<nums.length-2;i++){
         if(i>0 && nums[i]==nums[i-1]){ //skip duplicates
             continue;
         }
         int l=i+1;
         int r=nums.length-1;
         while(l<r){
             int sum=nums[i]+nums[l]+nums[r];
             if(sum==0){
                 lst.add(Arrays.asList(nums[i],nums[l],nums[r]));
                 while(l<r && nums[l]==nums[l+1]){ //skip duplicates
                     l++;
                 }
                 while(l<r && nums[r]==nums[r-1]){ //skip duplicates
                     r--;
                 }
                 l++;
                 r--;
             }
             else if(sum<0){
                 l++;
             }
             else if(sum>0){
                 r--;
             }
          }
       }   
    return lst;
    }
}