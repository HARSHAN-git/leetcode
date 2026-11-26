//https://www.geeksforgeeks.org/dsa/print-all-subarrays-with-0-sum/
//we use prefix sum to solve the problem, you just have to add the numbers from 
//the previous prefix sum ind+1 index till the current repeated prefix sum index to get the sum 0
//eg:arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7}
//prefsum={6->0,9->1,8->2,5->3,9->4,7->5,9->6,13->7,19->8,7->9,0->10}
//if you add numbers from ind 2(prefix sum 9 was at ind 1 so) till 4 , then we get sum 0
import java.util.*;
public class rough {
   public static void main(String[] args){
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        fun(arr);
   }  
   public static void display(ArrayList<int[]> lst){
        for(int[] curr:lst){
            int start=curr[0];
            int end=curr[1];
            System.out.println("Subarray starts from "+start+" to "+end);
        }
   }
   public static void fun(int[] arr){
        Map<Integer,ArrayList<Integer>> hm=new HashMap<>();
        ArrayList<int[]> lst=new ArrayList<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                lst.add(new int[]{0,i});
            }
            ArrayList<Integer> curr=new ArrayList<>();
            if(hm.containsKey(sum)){
                curr=hm.get(sum);
                for(int ind:curr){
                    lst.add(new int[]{ind+1,i});
                }
            }
            curr.add(i);
            hm.put(sum,curr);
        }
        display(lst);
   }
}
