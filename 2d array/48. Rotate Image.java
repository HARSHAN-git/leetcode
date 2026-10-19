//https://leetcode.com/problems/rotate-image/description/
//transpose and then reverse every rows
class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){ //here j=i cause we dont wanna do j=0 again after doint i=0 right?
                //swap the values not copy them
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse every row
        for(int i=0;i<matrix.length;i++){
            rev(i,matrix);
        }
    }
    public void rev(int row,int[][] matrix){
        int l=0;
        int r=matrix.length-1;
        while(l<=r){
            int temp=matrix[row][l];
            matrix[row][l]=matrix[row][r];
            matrix[row][r]=temp;
            l++;
            r--;
        }
    }
}