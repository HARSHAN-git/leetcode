//https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
//you will only understand if you simulate it 
class Solution {
    public int getLPSLength(String s) {
        // code here
        int[] lsp=new int[s.length()];
        int len=0;
        int i=1;
        while(i<s.length()){
            char si=s.charAt(i);
            char slen=s.charAt(len);
            if(si==slen){//match
                len++;  //we are doing this because we want the no of elements matched ,but len denotes the index
                lsp[i]=len;
                i++;
            }
            else{//if missMatch
                if(len==0){
                    lsp[i]=0;
                    i++;
                }
                else{
                    len=lsp[len-1]; //if there is a missmatch then revert to the previous match
                    //we dont have to look from the begining
                }
            }
        }
        return lsp[s.length()-1];
    }
}