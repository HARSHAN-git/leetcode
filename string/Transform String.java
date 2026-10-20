//https://www.geeksforgeeks.org/problems/transform-string5648/1
class Solution {
    int transform(String s1, String s2) {
        // code here
        if(s1.length()!=s2.length()){
            return -1;
        }
        // create a freq map (here we are using array instead of hashmap)
        int[] freq=new int[26]; //there are 26 alphabets
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            //if you dont convert to lower case then you should use 128 instead of 26 as storage space
            freq[Character.toLowerCase(c1)-'a']++;
            freq[Character.toLowerCase(c2)-'a']--;
        }
        //if they have the same frequency then freq should only contains 0s
        for(int count:freq){
            if(count!=0)
                return -1; //there is a mismatch in frequency
        }
        //we will iterate from the right
        //only s1 pointer will move if there is a missmatch
        //you will know once you simulate it and the s2 pointer position is the ans
        int i=s1.length()-1; //s1 pointer
        int j=s2.length()-1; //s2 pointer
        int operations=0;    //each time i moves while j waits is the no of operations
        //made due to a mismatch so just count it
        while(i>=0 && j>=0){
            if(s1.charAt(i)==s2.charAt(j)){
                i--;
                j--;
            }
            else{
                i--;
                operations++;
            }
        }
        return operations; //or else simply return j+1
    }
}