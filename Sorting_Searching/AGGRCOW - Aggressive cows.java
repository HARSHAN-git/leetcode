//https://www.spoj.com/problems/AGGRCOW/
import java.util.*;
public class rough {
    public static void main(String[] args) {
        int[] arr={1,2,8,4,9};
        int cows=3;
        System.out.println(fun(arr,cows));
    }
    public static int fun(int[] arr,int cows){
        Arrays.sort(arr);
        //its our minimum distance
        int min=Integer.MIN_VALUE;
        //we need to check for each distance starting from 1 till the maximum possible distance
        int l=1;
        int r=arr[arr.length-1]-arr[0]; //maximum possible distance
        //classic binary search
        while(l<=r){//we need a exact distance so equal comes
            int mid=l+(r-l)/2;
            if(ispossible(arr,mid,cows)){
                min=Math.max(min,mid);
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return min;
    }
    //fun to check if the cows can be placed in the selected distance
    public static boolean ispossible(int[] arr,int dis,int cows){
        //we will calculate the distance for this (arr[i]-lostpos),if found then we update the new lastpos
        int lastpos=arr[0];
        //if all the cows are placed ,then no need to continue
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastpos>=dis){
                count++;
                lastpos=arr[i];
            }
            if(count>=cows){
                return true;
            }
        }
        return false;
    }
}
