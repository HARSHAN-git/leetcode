/*https://www.geeksforgeeks.org/problems/word-wrap1646/1 - read the problem and explanation
This is a super question to understand the dynamic programing
for eg- arr[3,2,2,5] and k=6
-like coin change problem where we note the change for each coins , here we note for each line
-we need the cost from index 0(3) till 3(5),but we can simply it by cost of curr + the next 
-in our case, the cost of starting from 3 is the cost of ind 0(3) + the optimal cost from ind 1(2)
-so we need to find the optimal cost of ind 1 but for that we need optimal cost of ind 2 and so on
-so we calculate the optimal cost of ind 4(5) which is the last ind first and move towards the first
 */
class Solution {
    public int solveWordWrap(int[] arr, int k) {
        // Code here
        int n=arr.length;
        // cause for the last ind we need the next one to calculate cost right 
        //so we set the next of last position cost as 0 , thats why the +1 
        int[] dp=new int[n+1]; 
        for(int i=n-1;i>=0;i--){//start by calculating the cost of last ind
            //set dp[i] as max to set it to a min cost later,cause it will be 0 initially
            dp[i]=Integer.MAX_VALUE;
            int linelen=0; //initially
            for(int j=i;j<n;j++){//we need to check all possiblities for each index
                int cost=0;
                linelen+=arr[j]; //add the word size
                if(j>i){//if a next word is being calculated then add an extra space between words
                    linelen++;
                }
                if(linelen>k){  //not possible to place the word
                    break;
                }
                if(j!=n-1){ //dont need to calculate cost for the last line
                    int extra=k-linelen;
                    cost+=extra*extra;
                }
                dp[i]=Math.min(dp[i],cost+dp[j+1]);
                //for eg if the curr cost is 9 for ind 0(3) then adding it with the 
                //optimal cost for ind 1(2) which is 1 makes sense
            }
        }
        return dp[0]; //what is the cost from intial to the end words
    }
}