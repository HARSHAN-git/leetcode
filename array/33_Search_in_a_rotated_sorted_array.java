//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution{
    //this problem is easy
    //1.find the pivot where the change actually happens (pivot is greater than its next elment)
    //2.obviously if the target value is less than the last element in the array means it in the range-> pivot + 1(e.g=0) till arr.length-1(eg=2) ->use binary search for this boundary
    //3.if the target value is greater than the last element then the target is in the rotated part,range-> 0 till pivot(e.g=4) till arr[pivot](eg=7)->use binary search 
    public int search(int[] nums, int target) {
        //edge case if there is only one elment
        if(nums.length==1 && nums[0]==target){
            return 0;
        }
        else if(nums.length==1 &&  nums[0]!=target){
            return -1;
        }
        int pivot=findPivot(nums);
        System.out.print(pivot);
        int ans=-1;
        if(target<=nums[nums.length-1]){
            ans=binarySearch(nums,target,pivot+1,nums.length-1);
        }
        else{
            ans=binarySearch(nums,target,0,pivot);
        }
        return ans;
    }
    //if there are no duplicates
    //this fun return max(7)
    public int findPivot(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //pivot is in the left
            if(mid>left && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            //pivot in the right
            else if(mid<right && arr[mid]>arr[mid+1]){
                return mid;
            }
            //if we are in the right partition
            else if(arr[left]>arr[mid]){
                right=mid-1;
            }
            //if we are at the left partition
            else{
                left=mid+1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] arr,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}
// //if the array contains duplicates use (duplicate aware findpivot) ->always use this algorithm
//this fun return min(0)
// static int dupfindpivot(int[] arr){
//     int left=0;
//     int right=arr.length-1;
//     while (left < right) {
//         int mid = left + (right - left) / 2;
//         if (arr[mid] > arr[right]) {
//             // Pivot is in the right half
//             left = mid + 1;
//         } else if (arr[mid] < arr[right]) {
//             // Pivot is in the left half (mid could be the pivot)
//             right = mid;
//         } else {
//             // arr[mid] == arr[right] → can't decide, shrink from the right
//             right--;
//         }
//     }
//     return left; 
// }