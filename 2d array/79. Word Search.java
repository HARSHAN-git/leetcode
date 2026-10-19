//https://leetcode.com/problems/word-search/description/
//1.[DFS,counter] i am gonna try dfs first and make a counter for matching the words 
//2.[visited DP array] since we cannot use the same letter twice -> we should not visit the path we came in so we need to use dp to remember our path
//3.[backtrack] one more problem this is like n queens , if we dont get one path right then we have to backtrack so lets do that too->if you dont do this then the 85th test case will fail
class Solution {
    boolean found=false;
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                int count=0;
                //to remeber the path and avoid going back again so that we dont count the letters again and again
                boolean[][] visited=new boolean[board.length][board[0].length]; 
                if(word.charAt(0)==board[r][c]){
                    dfs(board,count,word,r,c,visited);
                }
            }
        }
        return found;
    }
    public void dfs(char[][] board,int count,String word,int r,int c,boolean[][] visited){
        //if the letter does not match then the curr word is not our target word
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || word.charAt(count)!=board[r][c] || visited[r][c]==true){
            return;
        }
        visited[r][c]=true;
        count++;    //lets match the next character
        if(count==word.length()){ //we got the word
            found=true;
            return;
        }
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            dfs(board,count,word,nr,nc,visited);
        }
        //this one line is literal magic->
        visited[r][c] = false; //lets try backtracking
    }
}