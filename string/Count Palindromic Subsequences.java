//https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1
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
            for(int i=0;i+len-1<n;i++){ //here i+len-1 is for the right position
                int j=i+len-1; //right index
                if(s.charAt(i)==s.charAt(j)){
                /*
                Suppose the current substring is "aba"
                We already know the answers for its smaller substrings:
                - dp[i][j-1] → "ab" has 2 palindromic subsequences: a, b
                - dp[i+1][j] → "ba" has 2: b, a
                we have to count the subsequence formed by taking both matching endpoints, "aa"
                */                    
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
                }
                else{
                /*
                Let's use "abc"
                The endpoints differ, so we cannot form a palindrome by taking both endpoints.
                First, count the smaller substrings:
                - "ab" → a, b → 2
                - "bc" → b, c → 2
                The subsequence b appears in both lists. We counted it twice!
                The overlapping interval is the middle substring "b"
                So subtract its count
                */
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1]; //yeah the first row last column is the answer
    }
}