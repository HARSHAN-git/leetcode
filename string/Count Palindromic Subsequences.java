//https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1
/*You are required to complete below method */
class Solution {
    int countPS(String s) {
        // Your code here
        int n=s.length();
        int[][] dp=new int[n][n]; //this is used to calculate the no of occurances of each pair 
        //since every element is a palindorme of itself,lets increment the values of themselfs eg (a,a) to 1
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        //since we did single elements,lets do for length 2
        for(int len=2;len<=n;len++){ //yeah if n is 3 then there may be three pairs
            //for this length lets check every pairs from the start
            for(int i=0;i+len-1<n;i++){ //here i+lent-1 is for the right position
                int j=i+len-1; //right index
                if(s.charAt(i)==s.charAt(j)){
                    //number of occurances for the curr value in the dp is
                    //no of occurances of left element(left)+right element(down)+1(current pair e.g(a,a))
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
                }
                else{//if they are not same then curr value is
                //left value +right value -the already seen occurance of them which is [i-1][j-1]
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1]; //yeah the first row last column is the answer
    }
}