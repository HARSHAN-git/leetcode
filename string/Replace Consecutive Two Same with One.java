//https://www.geeksforgeeks.org/problems/consecutive-elements2306/1
class Solution {
    public String removeDuplicates(String s) {
        // code here
        if(s.length()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char curr=s.charAt(i);
            if(i+1<s.length() && curr==s.charAt(i+1)){
                while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                    i++;
                }
                sb.append(curr);
            }
            else{
                sb.append(curr);
            }
            i++; //yeah after adding curr you should move to the next element
        }
        return sb.toString();
    }
}