//https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
//1.i am gonna do dfs and check if a path leads to the boundary
//2.if yes then i will leave it alone ,if no then i will change then into 'X'
//3.by changing  the path rather than a single character i avoid rechecking the same path
//4.(not needed because we have safe)->i dont want to visit the path i came in so i am gonna use a visited dp array
//5.(no need for backtrack here)->what if the curr path doesnt lead to the boundary , so i wanna backtrack too
//6.instead of searching all O's,lets dfs from the boundary ones and mark them as true
//7.all the other O's which are not true in the dp array will be converted to X

//this problem is knida like the ocean problem
class Solution {
    boolean[][] safe;
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public void fill(char[][] grid) {
        // Code here
        int row=grid.length;
        int col=grid[0].length;
        safe=new boolean[row][col];
        //check the left and right columns for O's
        for(int r=0;r<row;r++){
            char left=grid[r][0]; //first col
            if(left=='O'){
                dfs(grid,r,0,safe);
            }
            char right=grid[r][col-1]; //last col
            if(right=='O'){
                dfs(grid,r,col-1,safe);
            }
        }
        //check the top and bottom rows for O's
        for(int c=0;c<col;c++){
            char top=grid[0][c]; //first row
            if(top=='O'){
                dfs(grid,0,c,safe);
            }
            char bottom=grid[row-1][c]; //last row
            if(bottom=='O'){
                dfs(grid,row-1,c,safe);
            }
        }
        //change all the "cannot reach boundary" O's to 'X'
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='O'){
                    if(safe[r][c]==false){
                        grid[r][c]='X';
                    }
                }
            }
        }
    }
    public void dfs(char[][] grid,int r,int c,boolean[][] safe){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || safe[r][c]==true || grid[r][c]=='X'){
            return;
        }
        safe[r][c]=true;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            dfs(grid,nr,nc,safe);
        }
    }
}
