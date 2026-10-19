// https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
/*The key idea is to sort strings such that their concatenation forms the largest number.

For any two strings X and Y, compare the values of XY = X + Y and YX = Y + X

If XY > YX, then X should come before Y in the final arrangement.
Otherwise, Y should come before X.
This ensures that we always place the number that leads to a larger combined value in front.

Example:

Let X = "2" and Y = "20"
=> XY = "220"
=> YX = "202"
Since "220" > "202", "2" should come before "20". So final result becomes "3220", not "3202"*/
import java.util.*;
class Solution {
    public String findLargest(int[] arr) {
        //arr[] = [3, 30, 34, 5, 9]
        // we need to do the comparisions in string so we dont have any limit for values as in int and long
       String[] s=new String[arr.length];
       for(int i=0;i<arr.length;i++){
           s[i]=Integer.toString(arr[i]);
       }
       //("3"+"30").compareTo("30"+"3") is ("330").compareTo("303") 
       //since the left number 330 > 303 (right number), the comparator returns positive
       //    positive → b(right side) comes before a(left side)
       //    negative → a comes before b
       //    zero     → equal

       //thi here is kinda like a decending order thing [b.compareTo(a)] 
       Arrays.sort(s,(a,b)->(b+a).compareTo(a+b)); //if positive (a+b) comes first
       //in this sorting it just tells that in each pair which should come before which
       //hence the relative order is remembered and the elements are arranged according to this ordered
       StringBuilder sb=new StringBuilder();
       for(String string:s){
           sb.append(string);
       }
       //dont print "0000" just one is enough "0" if the number starts with 0
       if(sb.charAt(0)==('0')){
           return "0";
       }
       return sb.toString(); //yeah they asked to print in string
    }
}
