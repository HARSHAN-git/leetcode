//https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {
    public int characterReplacement(String s, int k) {
        int mxlength=0;//max window length
        int mxfreq=0; //max frequency of an element
        int l=0;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){  
            freq[s.charAt(i)-'A']++;
            mxfreq=Math.max(mxfreq,freq[s.charAt(i)-'A']);//we always keep the highest frequency of the element within the window
            //we keep tabs on only the high frequency element
            //cause if the window-maxfreq is greater than k ,then we used our k so we move the left and decrement its freq 
            //the maxfreq is not touched because something bigger than this should be encounter so its acts as the previous biggest freq
            if((i-l+1)-mxfreq>k){   
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            mxlength=Math.max(mxlength,i-l+1);
        }
        return mxlength;
    }
}