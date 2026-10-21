//https://www.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1
//this array is not sorted ,so no binary search
//we have to use something called jump search
//formula: jump=max(1,(arr[i]-x)/k)->pretty smart formula
//yeah it will select the first occurance correctly
class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        // code here
        int i=0;
        while(i<arr.length){
            if(arr[i]==x){
                return i;
            }
            //an edge case :gotta remember
            if(k==0){
                return -1;
            }
            //if the above edge case is not handled we will get divison by zero exception in the below formula
            //the 1 inside the formula ensures that the pointer moves atleast ones such that the loop does not run forver
            //we just need how far the target is from the curr value so we need the absolute value(abs)
            //eg:curr val=32 ,target=34 then 32-34 gives -2 then dividing it also results in negative that makes the pointer go backwards lol
            int jump=Math.max(1,Math.abs(arr[i]-x)/k);
            i+=jump;
        }
        return -1;
    }
}