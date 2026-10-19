//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
import java.util.*;
//revise the equations below
class Repeat_and_Missing_Number_Array{
    public static void main(String[] args) {
        int[] arr={1,2,2,4,5}; //it should have been {1,2,3,4,5},the number 3 is missing and the number 2 is repeated-> these are the answers
        int[] ans=repeatedNumber(arr);
        System.err.println(Arrays.toString(arr));
    }
    public static int[] repeatedNumber(final int[] A) {

        int n = A.length;

        long expectedSum = (long)n * (n + 1) / 2; //sum of n natural numbers

        long expectedSquareSum =
                (long)n * (n + 1) * (2L * n + 1) / 6; //sum of square of n natural numbers

        long actualSum = 0;     //sum of the given array
        long actualSquareSum = 0; //sum of square of elements of the given array

        for(int num : A) {
            actualSum += num;
            actualSquareSum += (long)num * num; //here type conversion to long cause num*num may exceed int
        }

        // R - M
        long difference = actualSum - expectedSum;

        // R² - M²
        long squareDifference =
                actualSquareSum - expectedSquareSum;

        // R + M
        long sum = squareDifference / difference;

        //(R+M)+(R-M)=R+R+M-M=2R
        //2R=(R+M)+(R-M)
        // R = ((R-M) + (R+M)) / 2
        long repeated = (difference + sum) / 2;
        
        //R+M=(R+M)
        // M = (R+M) - R
        long missing = sum - repeated;

        return new int[]{(int)repeated, (int)missing};
    }
}
