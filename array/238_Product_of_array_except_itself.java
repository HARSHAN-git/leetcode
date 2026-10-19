//https://leetcode.com/problems/product-of-array-except-self/description/
import java.util.*;
class Solution {
    //this is an easy approach using auxiliary arrays with O(n) time and space complexity  
    public int[] productExceptSelf(int[] nums) {
        int[] prefix=new int[nums.length];
        Arrays.fill(prefix,1); //prefix= [1,1,1,1]
        //nums  = [1,2,3,4]
        //prefix->[1,1,2,6] //after
        for(int i=0;i<nums.length-1;i++){
            prefix[i+1]=prefix[i]*nums[i];
        }
        int[] suffix=new int[nums.length];
        Arrays.fill(suffix,1); //suffix= [1,1,1,1]
        //nums  = [1,2,3,4]
        //suffix->[24,12,4,1] //after
        for(int i=nums.length-1;i>0;i--){
            suffix[i-1]=suffix[i]*nums[i];
        }
        //merge->[224,12,8,6]
        for(int i=0;i<nums.length;i++){
            prefix[i]=prefix[i]*suffix[i];
        }
        return prefix;
    }
}
// //this is a hard approach without using using auxilary arrays runs at O(n) time complexity and O(1) space complexity
// public int[] productExceptSelf(int[] nums) {
//     int[] ans=new int[nums.length];
//     Arrays.fill(ans,1);
//     //ans=[1,1,1,1] //before
//     //ans ->[1,1,2,6] //after
//     for(int i=0;i<nums.length-1;i++){
//         ans[i+1]=ans[i]*nums[i];
//     }
//     int suffix=1; //set suffix as 1 initially
//     for(int i=nums.length-1;i>=0;i--){
//         ans[i]*=suffix;
//         suffix*=nums[i];
//     }
//     return ans;
// }
