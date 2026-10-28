//gfg->https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
//leetcode->https://leetcode.com/problems/product-of-array-except-self/description/
//lets create prefix and sufix product array and multiply them to get product array
import java.util.*;
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n=arr.length;
        //create prefix array
        int[] pfx=new int[n];
        Arrays.fill(pfx,1); //cause we are gonna do product not sum
        for(int i=1;i<n;i++){
            pfx[i]=pfx[i-1]*arr[i-1];
        }
        //create sufix array
        int[] sfx=new int[n];
        Arrays.fill(sfx,1); 
        for(int i=n-2;i>=0;i--){
            sfx[i]=sfx[i+1]*arr[i+1];
        }
        //create product array which is the answer
        int[] prod=new int[n];
        for(int i=0;i<n;i++){
            prod[i]=pfx[i]*sfx[i];
        }
        return prod;
    }
}
