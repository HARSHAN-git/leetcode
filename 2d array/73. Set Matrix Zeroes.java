//https://leetcode.com/problems/set-matrix-zeroes/
//easy peasy 
//before altering the first row or column to note that the corresponding line has zero just make sure to take a note of zeros in the first row and col
//and procced with changing the elements from [1,1]
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean colzero=false;
        boolean rowzero=false;
        int r=matrix.length;
        int c=matrix[0].length;
        //check if there are zeros in first row
        for(int i=0;i<r;i++){
            if(matrix[i][0]==0){
                rowzero=true;
            }
        }
        //check if there are zeros in first col
        for(int i=0;i<c;i++){
            if(matrix[0][i]==0){
                colzero=true;
            }
        }
        //set the first row and col cell zero if we encounter a cell with zero
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //if the first row or col is zero then set the element to zero
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[0][j]==0){
                    matrix[i][j]=0;
                }
                else if(matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //set the first row to zero if we found any zeros earlier 
        if(rowzero==true){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }    
        //set the first col to zero if we found any zeros earlier 
        if(colzero==true){
            for(int i=0;i<c;i++){
                matrix[0][i]=0;
            }
        }    
    }
}