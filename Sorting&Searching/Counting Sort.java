//https://www.geeksforgeeks.org/problems/counting-sort/1
//use freq array to sort 
class Solution {
    public static String countSort(String s) {
        // code here
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            int ind=c-'a';
            freq[ind]++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                //type cast to get the char
                char c=(char)(i+'a'); //yeah add here not subtract
                for(int j=0;j<freq[i];j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}