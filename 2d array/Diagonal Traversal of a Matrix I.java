// Java program to find Diagonal Traversal of a Matrix
//https://www.geeksforgeeks.org/dsa/zigzag-or-diagonal-traversal-of-matrix/
import java.util.*;
//mathametical approach
class GfG {
    static ArrayList<Integer> diagonalOrder(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        // There will be n+m-1 diagonals in total ->fact
        for (int line = 1; line <= (n + m - 1); line++) {
            int startCol = Math.max(0, line - n); //at the bottom the column starts to move after the mid diagonal
            //1.the no of elements till mid is equal to the line number(diagonal no)->line
            //2.if the start col decreses then the diagonal no also decreses->m-startcol
            //3.and abvoiusly the no is not greater then the no of rows(boundary)
            int count = Math.min(Math.min(line, m - startCol), n);

            for (int j = 0; j < count; j++) {
                //-1 because to calculate the index(line starts from 1 so)
                //here n acts as a boundary again
                int row = Math.min(n, line) - j - 1;//as we traverse the diagonal we decrement the rows 
                int col = startCol + j;//as we traverse the diagonal we increment the cols
                res.add(mat[row][col]);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] mat = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
            { 17, 18, 19, 20 }
        };
        ArrayList<Integer> res = diagonalOrder(mat);
        for (int val : res) System.out.print(val + " ");
        System.out.println();
    }
}
//simple approach divide it into upper half (until mid) and lower half (just calculating the last row)
class Solution {
    static ArrayList<Integer> diagonalOrder(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        // Start diagonals from the left column
        for (int r = 0; r < n; r++) {
            int i = r, j = 0;

            while (i >= 0 && j < m) {
                res.add(mat[i][j]);
                i--;
                j++;
            }
        }

        // Start remaining diagonals from the bottom row
        for (int c = 1; c < m; c++) {
            int i = n - 1, j = c;

            while (i >= 0 && j < m) {
                res.add(mat[i][j]);
                i--;
                j++;
            }
        }

        return res;
    }
}