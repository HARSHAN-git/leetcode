//both are same
//leetcode->http://leetcode.com/problems/house-robber/description/
//gfg->https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
//you can think like in the word wrap problem
//without memoization it will become O(2^n) instead of O(n)
class Solution {
    public int rob(int arr[]) {
        //use memozization to avoid calculating again and again
        int[] dp=new int[arr.length]; 
        Arrays.fill(dp,-1);
        return fun(arr,0,dp);
    }
    public int fun(int arr[],int i,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(i==arr.length-1){
            return arr[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=arr[i]+fun(arr,i+2,dp);
        int skip=fun(arr,i+1,dp);
        dp[i]=Math.max(rob,skip);
        return dp[i];
    }
}