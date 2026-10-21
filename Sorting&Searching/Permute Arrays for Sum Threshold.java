//https://www.geeksforgeeks.org/problems/permutations-in-array1747/1
//our idea here is to pair the smallest element in a with largest element in b
//so sort a in accending order and b in descending order
import java.util.*;
class Solution {
    public boolean isPossible(int k, int[] a, int[] b) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n=a.length;
        for(int i=0;i<n/2;i++){
            int temp=b[i];
            b[i]=b[n-i-1];
            b[n-i-1]=temp;
        }
        for(int i=0;i<n;i++){
            if(a[i]+b[i]<k){
                return false;
            }
        }
        return true;
    }
}