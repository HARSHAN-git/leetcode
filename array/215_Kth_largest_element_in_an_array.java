//https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.*;
class Solution {
    //its exactly like 703. Kth Largest Element in a Stream
    //using min heap to store values and maintaining the size of the queue < k
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}