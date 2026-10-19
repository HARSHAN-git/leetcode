// https://leetcode.com/problems/merge-intervals/description/
//using List<Int[]<Integer>>
import java.util.*;
//using List<int[]>
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> lst=new ArrayList<>();  //we use int[] here because we know that each interval inside a list contains only two elements ,easy to point to them (interval[0],interval[1])

        Arrays.sort(intervals,(a,b)->a[0]-b[0]); //compares [1,5] , [2,4]--> compares which array should come first ,by comparing 1 & 2

        lst.add(intervals[0]);    //lst=[[1,3]] now
        for(int i=1;i<intervals.length;i++){  // iterating from second element ,i=1
            int[] last=lst.get(lst.size()-1); //lst=[1,3]
            if(last[1]>=intervals[i][0]){      //3>2      
                last[1]=Math.max(last[1],intervals[i][1]);//lst=[[1,max(3,6)]]=[[1,6]]
            }
            else{
                lst.add(intervals[i]); //iteration two -->6<8 so,lst=[[1,6],[8,10]]
            }
        }
        return lst.toArray(new int[lst.size()][]); //convert the list to an array
    }
}
//using List<List<Integer>>
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        res.add(Arrays.asList(intervals[0][0],intervals[0][1]));
        for(int i=1;i<intervals.length;i++){
            int[] curr=intervals[i];
            if(res.get(res.size()-1).get(1)>=curr[0]){
                res.get(res.size()-1).set(1,Math.max(res.get(res.size()-1).get(1),curr[1]));
            }
            else{
                res.add(Arrays.asList(curr[0],curr[1]));
            }
        }
        //the standard res.toArray(new int[res.size()][]) only works for List<int[]<Integer>> not for List<List<Integer>> because during run time the java does not remember the type of the data so java does not perform any type conversions from list to int[] here and only gets elements from int[] to your new int[][] during run time
        int[][] ans = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i][0]=res.get(i).get(0);
            ans[i][1]=res.get(i).get(1);
        }
        return ans;
    }
}