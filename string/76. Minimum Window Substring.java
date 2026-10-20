https://leetcode.com/problems/minimum-window-substring/description/
/*
-use frequency arrays and req number and increase or decrease it, if the req character is found
-maintain the min window and if the req is equal to our req string length then shrink the window
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length() || t.isEmpty()){
            return "";
        }
        //here upper and lower case are different things(case sensitive)
        int[] freq=new int[128];
        int[] need=new int[128];
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            int ind=c;  //Java automatically converts a char into its numeric Unicode value when you use it as an array index.
            need[ind]++;
        }
        int l=0;
        int req=t.length();
        int start=0;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int ind=c;
            freq[ind]++; //adding this cause we dont wanna count 0's
            if(freq[ind]<=need[ind]){ //cause the elements that are not needed will have freq 0 in needed array making cond (freq[ind]>need[ind])
                req--;  //yehh we got something we need
            }
            while(req==0){  //damn we got everything
                //1.update minlen
                int currlen=i-l+1;
                if(currlen<minlen){
                    minlen=currlen;
                    start=l;
                }

                //2.shrink the window
                char lc=s.charAt(l);
                int left=lc;
                freq[left]--; //moving left means strinking the window so decreace the frequency of the removed character
                if(freq[left]<need[left]){  //if you do == then we may miss the lower posibilities
                    req++;
                }
                l++;
            }
        }
        return minlen==Integer.MAX_VALUE ? "":s.substring(start,start+minlen);
    }
}