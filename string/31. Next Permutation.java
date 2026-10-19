//https://leetcode.com/problems/next-permutation/submissions/2155037651/
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=-1; //if we didnt get any pivot then the number is already in increasing order so just swap from (0(pivot+1),lastelement)
        //find a pivot to swap it to its successor
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                pivot=i-1;
                break;
            }
        }
        //if we found a pivot then find a successor which is greater than it from the right(smallest to largest)
        if(pivot!=-1){
            int successor=0;
            for(int i=nums.length-1;i>pivot;i--){
                if(nums[i]>nums[pivot]){
                    successor=i;
                    break;
                }
            }
            //then swap the pivot and its successor to make the next greatest
            int temp=nums[successor];
            nums[successor]=nums[pivot];
            nums[pivot]=temp;
        }
        //since the element in the higher digits changed to the next lowest possible element
        //we have a condition were the elements after the pivot are in decending order
        //sort them in accening order so that we get the next permutation
        rev(nums,pivot+1,nums.length-1);
    }
    public void rev(int[] nums,int left,int right){
        while(left<=right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}