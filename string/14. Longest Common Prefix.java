//https://leetcode.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        String first=strs[0];
        for(int i=0;i<first.length();i++){
            char curr=first.charAt(i);
            boolean isvalid=true;
            for(int j=1;j<strs.length;j++){
                String currword=strs[j];
                if(i>=currword.length() || curr!=currword.charAt(i)){
                    isvalid=false;
                    break;
                }
            }
            if(isvalid){
                sb.append(curr);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}