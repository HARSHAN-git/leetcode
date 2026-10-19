//https://www.geeksforgeeks.org/problems/wildcard-pattern-matching/1?utm=codoliohttps://www.geeksforgeeks.org/problems/wildcard-pattern-matching/1?utm=codolio
class Solution {
    public boolean wildCard(String txt, String pat) {
        // code here
        int m=txt.length();
        int n=pat.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        
        //lets write a edge case were "*" comes first
        //we turn the entire first column to *s
        //so that while iterating stars we take T from either left or top
        for(int i=1;i<=n;i++){
            if(pat.charAt(i-1)=='*')
                dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<=n;i++){//paterns vertical
            for(int j=1;j<=m;j++){
                //for matching characters and '?'
                if(pat.charAt(i-1)==txt.charAt(j-1) || pat.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                //for *
                else if(pat.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];//putting true after we get the subsequence
                }
            }
        }
        return dp[n][m];
    }
}