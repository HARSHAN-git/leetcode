//https://leetcode.com/problems/group-anagrams/
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //for checking i will convert string to charArray
        // and compare it with key value in the hashmap
        //if there is no hash map then create one or else update its string list
        HashMap<String,List<String>> hm=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] sorted=strs[i].toCharArray();
            Arrays.sort(sorted);
            String s=new String(sorted);
            if(hm.containsKey(s)){
                List<String> lst=hm.get(s);
                lst.add(strs[i]);
            }
            else{
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                hm.put(s, lst);
            }
        }
        for(List<String> values:hm.values()){
            res.add(values);
        }
        return res;
    }
}