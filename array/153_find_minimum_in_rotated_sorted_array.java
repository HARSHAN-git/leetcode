//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    //they are just asking the pivot value (next to peak in a rotated array)
    //if the array is not rotated then return pivot as 0 ,cause thats the smallest element
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int pivot=findPivotSmall(nums);
        return nums[pivot];
    }
    public int findPivotSmall(int[] nums){
        int left=0;
        int right=nums.length-1;
        //you can also use the duplicate free version here
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid>left && nums[mid]<nums[mid-1]){
                return mid;
            }
            else if(mid<right && nums[mid]>nums[mid+1]){
                return mid+1;
            }
            else if(nums[mid]>nums[left]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return 0;
    }
}
// //duplicate free version
// public int findPivotSmall(int[] nums){
//     int left=0;
//     int right=nums.length-1;
//     while(left<right){
//         int mid=left+(right-left)/2;
//         if(nums[mid]>nums[right]){
//             left=mid+1;
//         }
//         else if(nums[mid]<nums[right]){
//             right=mid;
//         }
//         else{
//             right--;
//         }
//     }
//     return left;
// }