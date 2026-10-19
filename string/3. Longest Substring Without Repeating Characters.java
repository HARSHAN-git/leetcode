//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int mx=1;
        int l=0;    //counter for the substring in s
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(sb.indexOf(String.valueOf(c))!=-1){
                while(sb.indexOf(String.valueOf(c))!=-1){
                    l++;
                    sb=new StringBuilder(sb.substring(1,sb.length()));  //for sb dont use l
                }
                sb.append(c);
            }
            else{
                sb.append(c);
            }
            mx=Math.max(mx,i-l+1);
        }
        return mx;
    }
}
// //HashSet method:
// if(s.length()==0){
//     return 0;
// }
// Set<Character> set=new HashSet<>();
// int mx=0;
// int left=0;
// for(int right=0;right<s.length();right++){
//     while(set.contains(s.charAt(right))){   //we use while here instead of if cause consider the eg:abba
//         set.remove(s.charAt(left));
//         left++;
//     }
//     set.add(s.charAt(right));
//     mx=Math.max(mx,right-left+1);
// }
// return mx;

////HashMap method
// HashMap<Character,Integer> hm=new HashMap<>();
// int mx=0;
// int left=0;
// for(int right=0;right<s.length();right++){
//     char c=s.charAt(right);
//     if(hm.containsKey(c)){
//         left=Math.max(left,hm.get(c)+1);    //eg:"abba" if a occurs the second time and u just do left=hm.get(c)+1 then the left will be 1,how the hell left is 1 at the last element
//     }
//     hm.put(c,right);
//     mx=Math.max(mx,right-left+1);
// }
// return mx;

