//https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
//cannot use .indexOf() for primitive datatypes
// Complexity
// - Time: O(|s| + |p|) — i and l each move only forward.
// - Space: O(1) auxiliary — both arrays have fixed size 26.
class Solution {
    public static String minWindow(String s, String p) {
        // code here
        if(s.length()<p.length()){
            return "";
        }
        int n=s.length();
        int[] need=new int[26];
        int[] have=new int[26];
        int ans=0;
        int l=0;
        int formed=0;
        int req=0;
        int len=n;
        char[] pp=p.toCharArray();
        for(char c:pp){
            if(need[c-'a']==0){ //finding the distinct no of characters
                req++;
            }
            need[c-'a']++;
        }
        for(int i=0;i<n;i++){
            int curr=s.charAt(i)-'a';
            if(need[curr]>0){//we encountered a required character
                have[curr]++;
                if(have[curr]==need[curr]){
                    formed++;
                }
            }
            while(formed==req){//srinking from left if we have all need elements
                if(i-l+1 < len){
                    len = i-l+1;
                    ans = l;
                }
                int leftChar = s.charAt(l)-'a';
                if(need[leftChar]>0){ //we encountered a needed element
                    have[leftChar]--;
                    if(have[leftChar]<need[leftChar]){
                        formed--;
                    }
                }
                l++;
            }
        }
        if(len == n && formed != req){ //what if there is no valid sequence
            return "";
        }
        return s.substring(ans,ans+len);
    }
}