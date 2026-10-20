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
            //window length - mxfreq = minimum number of replacements needed to make the entire window contain the same character(this is just genius)
            //suppose window=ABCA since A has mxfreq=2 then we need 2 operations to make B & C to A ,which is windowlen(4)-mxfreq(which is A(2))=2
            if((i-l+1)-mxfreq>k){   //trying to shrink the window
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            mxlength=Math.max(mxlength,i-l+1);
        }
        return mxlength;
    }
}