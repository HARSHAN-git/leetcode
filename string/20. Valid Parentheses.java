///https://leetcode.com/problems/valid-parentheses/
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        Map<Character,Character> hm=new HashMap<>();
        hm.put(')','(');
        hm.put(']','[');
        hm.put('}','{');
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray()){
            if(!hm.containsKey(c)){
                stk.push(c);
            }
            else{
                if(!stk.isEmpty() && stk.peek().equals(hm.get(c))){
                    stk.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}