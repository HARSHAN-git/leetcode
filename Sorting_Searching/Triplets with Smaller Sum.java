/*
lets try like three sum 
the question says that there are no duplicates 
If arr[i] + arr[left] + arr[right] < sum, then every element 
between left + 1 and right can also form a valid triplet 
with arr[i] and arr[left]
*/
import java.util.*;
class Solution {
    int countTriplets(int sum, int arr[]) {
        int count=0;
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int currsum=arr[i]+arr[l]+arr[r];
                if(currsum<sum){
                    count+=r-l; //just this small correction
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}