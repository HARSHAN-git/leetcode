//https://www.geeksforgeeks.org/problems/common-elements1132/1
//there are negative elements too so dont use freq array
//since there are duplicates and have to check three numbers lets use 3 pointers like in 3sum
//using 3 pointers instead of hashmap ,cause to eliminate extra space
//we can use the info that arrays are sorted to our advantage and move the pointers
import  java.util.*;
class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                res.add(a[i]);
                int val = a[i];
                //duplicate skip and increment too
                while (i < a.length && a[i] == val) i++;
                while (j < b.length && b[j] == val) j++;
                while (k < c.length && c[k] == val) k++;
            } 
            //now lets move the pointer with the smallest element first
            else if (a[i] < b[j]) {
                i++;
            } 
            else if (b[j] < c[k]) {
                j++;
            } 
            else {
                k++;
            }
        }
        return res;
    }
}