//https://leetcode.com/problems/number-of-islands/
class Solution {
    //using DSU(Disjoint Set Union) is a over kill for this problem ,but a nice start for dsu
    int[] parent;
    int[] size;
    public int numIslands(char[][] grid) {
        //DSU  requires parent array and size array
        int rl=grid.length;
        int cl=grid[0].length;
        int l=rl*cl;
        parent=new int[l];
        size=new int[l];
        //lets build the initial count as the number of 1's
        int count=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                int id=i*cl+j; //like 0,1,2 id for each cell
                parent[id]=id;  //every node is their own parent initially
                size[id]=1;     //every node has 1 connection initially which is themself
                if(grid[i][j]=='1'){
                    count++;    //updating the number of 1's 
                }
            }
        }
        //building directions
        int[][] directions={
            {1,0}, //down
            {0,1}, //right
            {-1,0},//up
            {0,-1} // left
        };
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                int id=i*cl+j;
                if(grid[i][j]=='1'){
                    for(int[] dir:directions){
                        int ni=i+dir[0];
                        int nj=j+dir[1];
                        if(ni<0 || nj<0 || ni>=rl || nj>=cl || grid[ni][nj]=='0'){
                            continue;
                        } 
                        else{
                            int neighbor=ni*cl+nj;
                            if(union(id,neighbor)){ //here is the magic where the cell of an island become as one component i.e the first cell becomes the parent of all other cells in the island
                                System.out.println("Merged " + id + " with " + neighbor +" count = " + count);
                                count--;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public int find(int x){ //lets find the parent of x
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]); //x's parent now will be the parent[x]->recusively 
    }
    public boolean union(int a,int b){
        int roota=find(a); //finds and return the appanukaaa appan i.e head parent of a
        int rootb=find(b);
        if(roota==rootb){  //same parent means belongs to the same component(here island)
            return false;  //dont decrease the count yet
        }
        else if(size[rootb]>size[roota]){
            parent[roota]=rootb;
            size[rootb]+=size[roota]; //children of roota now becomes the children of rootb cause even roota is the child of roob
        }
        else{
            parent[rootb]=roota; //by default the first cell becomes the head parent
            size[roota]+=size[rootb];
        }
        return true; //this means else if or else block executed then one 1 has become a part of the parent component (in dfs terms,it has become 0) so reduce the count,only the head parent count should be included in the ans which is one count for one island
    }
}
//using dfs 
//     int count=0;
//     int r=grid.length;
//     int c=grid[0].length;
//     for(int i=0;i<r;i++){
//         for(int j=0;j<c;j++){
//             if(grid[i][j]=='1'){
//                 count++;
//                 dfs(grid,i,j);
//             }
//         }
//     }
//     return count;
// }
// public void dfs(char[][] grid,int i,int j){
//     if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
//         return;
//     }
//     grid[i][j]='0';
//     dfs(grid,i-1,j);
//     dfs(grid,i+1,j);
//     dfs(grid,i,j-1);
//     dfs(grid,i,j+1);