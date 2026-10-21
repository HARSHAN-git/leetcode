//https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
//its not binary search ,its kinda two pointers
//moving the pointers based on the curr diff
import java.util.*;
class Solution {
    public boolean findPair(int[] arr, int x) {
        Arrays.sort(arr);
        int l=0;
        //lets use two pointers 
        int r=1;
        int n=arr.length;
        while(l<n && r<n){ //here just two pointers
            if(l==r){
                r++;
                continue; //cuase we need to check if r is within the boundary
            }
            int diff=arr[r]-arr[l];
            if(diff==x){
                return true;
            }
            else if(diff<x){ //to the next big element
                r++;
            }
            else{ //to decrease the sum ,we need a greater value of l
                l++;
            }
        }
        return false;
    }
}
