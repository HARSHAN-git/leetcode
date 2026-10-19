//https://leetcode.com/problems/spiral-matrix/
//just straight forward apprach here
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l=0;
        int r=matrix[0].length-1;
        int t=0;
        int b=matrix.length-1;
        ArrayList<Integer> lst=new ArrayList<>();
        while(l<=r && t<=b){
            //left to right
            for(int i=l;i<=r;i++){
                lst.add(matrix[t][i]);
            }
            t++;
            //top to bottom
            for(int i=t;i<=b;i++){
                lst.add(matrix[i][r]);
            }
            r--;
            //right to left
            if(t<=b){ //doing this so that we dont iterate the same row twice
                for(int i=r;i>=l;i--){
                    lst.add(matrix[b][i]);
                }
                b--;
            }
            //bottom to top
            if(l<=r){   //doing this so that we dont iterate the same col twice
                for(int i=b;i>=t;i--){
                    lst.add(matrix[i][l]);
                }
                l++;
            }
        }
        return lst;
    }
}
