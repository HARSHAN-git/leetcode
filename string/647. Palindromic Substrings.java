//https://leetcode.com/problems/palindromic-substrings/description/
//this is like leetcode 5 but just count whenever you find left character is right 
//dont forget to check for both odd and even places
class Solution {
    int count=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            isvalid(i,i,s);
            isvalid(i,i+1,s);
        }
        return count;
    }
    public void isvalid(int l,int r,String s){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}