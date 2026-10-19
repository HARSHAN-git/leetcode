// https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        int pivot=findpivot(arr);
        //here the right=peak and left=peak+1
        //be aware tho while doing peak+1 you may go out of bound so do (peak+1)%arr.length
        //if you take min as pivot then while doing peak-1 you may go to -1 ,so do (peak-1+arr.length)%arr.length
        //same increament and decremeat technique of left and right also
        return circularbinarysearch(arr,pivot,(pivot-1+arr.length)%arr.length,target); 
        //here (pivot-1+arr.length)%arr.length because what if the arr is not rotated and the right goes -1
    }
    //since the array contains duplicates use (duplicate aware findpivot) ->always use this algorithm
    static int findpivot(int[] arr){
        int left=0;
        int right=arr.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid in left partition
            if (arr[mid] > arr[right]) {
                // Pivot is in the right half
                left = mid + 1;
            } 
            //mid in right partition
            else if (arr[mid] < arr[right]) {
                // Pivot is in the left half (mid could be the pivot)
                right = mid;
            } else {
                // arr[mid] == arr[right] → can't decide, shrink from the right
                right--;
            }
        }
        return left; 
    }
    static boolean circularbinarysearch(int[] arr,int left,int right,int target){
        while(left!=right){
            int currsum=arr[left]+arr[right];
            if(currsum==target){
                return true;
            }
            else if(currsum<target){
                left=(left+1)%arr.length;
            }
            else{
                right=(right-1+arr.length)%arr.length;
            }
        }
        return false;
    }
}
            