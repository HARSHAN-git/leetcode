import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
public class Chocolate_Distribution_Problem {
    public int findMinDiff(int arr[], int m) {
        // code here
        int min=Integer.MAX_VALUE;
        //the no of packets is less than the no of students so we cant satisfy every one
        if(arr.length<m){
            return 0;
        }
        //before sorting->[3, 4, 1, 9, 56, 7, 9, 12]
        Arrays.sort(arr);
        //after sorting->[1,3,4,7,9,9,12,56]
        int left=0;
        int right=m-1;
        //left is 1 and right element is the first 9
        //by default after sorting the right element is the max in the interval and left is the min
        //the question asks to get the min difference so we just need to find the lowest mx-min value
        //we do these by moving the interval
        //iteration 1: 9-1=8 then 3 becomes the next left and the next 9 becomes the next right
        //iteration 2: 9-3=6 which is the ans but we check for other possiblities too
        while(right<arr.length){        
            min=Math.min(min,arr[right]-arr[left]);
            left++;
            right++;
        }
        return min;
    }
}
