//https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
//using min and max heap to maintain active left and right sides
import  java.util.*;
class Solution{
    public ArrayList<Double> getMedian(int[] arr){
        PriorityQueue<Integer> right=new PriorityQueue<>();
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Double> lst=new ArrayList<>();
        for(int i:arr){
            //inserting the elments to the heap
            if(left.isEmpty() || left.peek()>=i){
                left.offer(i);
            }
            else{
                right.offer(i);
            }
            
            //balancing the heaps
            if(left.size()>right.size()+1){
                right.offer(left.poll());
            }
            else if(right.size()>left.size()+1){ //note:balance only when they are unbalanced
                left.offer(right.poll());
            }
            
            //calculate the median and append it to the lst
            if(left.size()==right.size()){
                double num=(left.peek()+(double)right.peek())/2.0;
                lst.add(num);
            }
            else if(left.size()>right.size()){
                lst.add((double)left.peek());
            }
            else{//right heap is larger , so it contains the medain
                lst.add((double)right.peek());
            }
        }
        return lst;
    }
}
//brute force -> this leads to TLE
// class Solution {
//     public ArrayList<Double> getMedian(int[] arr) {
//         // code here
//         List<Double> lst=new ArrayList<>();
//         double[] ans=new double[arr.length];
//         for(int i=0;i<arr.length;i++){
//             int e=arr[i];
//             lst.add((double)e);
//             Collections.sort(lst);
//             int size=lst.size();
//             if(size%2==0){
//                 double mid=lst.get(size/2);
//                 double pre=lst.get(size/2-1);
//                 ans[i]=(mid+pre)/2.0;
//             }
//             else{
//                 double mid=lst.get(size/2);
//                 ans[i]=mid;
//             }
//         }
//         ArrayList<Double> res=new ArrayList<>();
//         for(double i:ans){
//             res.add(i);
//         }
//         return res;
//     }
// }