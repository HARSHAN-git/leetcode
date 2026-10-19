// https://www.geeksforgeeks.org/dsa/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
//its a basic add,recurse,backtrack problem
import java.util.*;
class subarray{
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int subarraysize=2;
        List<List<Integer>> res=new ArrayList<>();
        build(arr,res,subarraysize,0,new ArrayList<>());
        System.out.println(res);
        //res ->[[1, 2], [1, 2], [1, 2], [1, 3], [1, 3], [1, 4]]
    }
    public static void build(int[] arr,List<List<Integer>> res,int subarraysize,int start,List<Integer> curr){
        //base case
        if(subarraysize==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        //for every number
        for(int i=start;i<arr.length;i++){
            curr.add(arr[i]);                          //add
            build(arr, res, subarraysize-1,i+1, curr); //recurse
            curr.remove(curr.size()-1);                //backtrack   
        }
    }
}