// https://www.geeksforgeeks.org/problems/interesting-queries4742/1
//i have no words for this question ,gambare!
import java.util.*;
class Query {
    int l;
    int r;
    int index;

    Query(int l, int r, int index) {
        this.l = l;
        this.r = r;
        this.index = index;
    }
}
class Solution {
    //Mo's algorithm
    public ArrayList<Integer> solveQueries(int[] arr, int[][] queries, int k) {
        int[] res = new int[queries.length]; //cause we retrieve the query index and put its answer accordingly
        int[] freq=new int[1001];// cause there are only thousand values(constriant)
        int blocksize=(int)Math.sqrt(arr.length);
        //if we are modifiying the query order for complexity then we need to remember them to answer the res in that order
        Query[] qry=new Query[queries.length];
        for(int i=0;i<queries.length;i++){
            qry[i]=new Query(queries[i][0]-1,queries[i][1]-1,i);//we convert into zero index
        }
        //in this sorting for eg:
        //Q1 = [1, 5]  Q2 = [2, 7] Q3 = [3, 6] Q4 = [9,12]
        //the quries 1,2,3 will go to block 0 and 4th query [9,12] will go to block 2
        //this block business will keep them in that relative order search that [9,12] comes after the first 3 which is what we want
        //for the quries in the same block we order them by their right values like in merge intervals,so finally they are ordred like this
        // [[1,5],[3,6],[2,7],[9,12]] ->sort left elements by block and use the rights elements to order ranges in the same block 
        Arrays.sort(qry,(a,b)->{
            int blockA=a.l/blocksize;
            int blockB=b.l/blocksize;
            if(blockA!=blockB){
                return Integer.compare(blockA,blockB);
            }
            return Integer.compare(a.r,b.r); //same block means compare the R values of the queries
        });
        //we need a initial window and we will increase or decrease find the frequencies for each range in the qry
        int l=qry[0].l;
        int r=qry[0].r;
        for(int i=l;i<=r;i++){
            freq[arr[i]]++;
        }
        int count=0;
        for(int i:freq){
            if(i>=k){
                count++;
            }
        }
        Query first=qry[0];
        res[first.index]=count;
        //for the remaining ones->
        for(int i=1;i<qry.length;i++){
            Query curr=qry[i];
            int currL=curr.l;
            int currR=curr.r;
            if(l<currL){ //L++  → remove arr[L]
                while(currL!=l){
                    int x=arr[l];
                    if(freq[x]==k){
                        count--;    
                    }
                    //for removing we check the freq before removing
                    freq[x]--;
                    l++;
                }
            }
            if(currL<l){//L--  → add arr[L]
                while(currL!=l){
                    l--;
                    int x = arr[l];
                    //for adding we add the value and we check the freq after adding
                    freq[x]++;
                    
                    if(freq[x] == k){
                        count++;
                    }
                }
            }
            if(currR<r){//R--  → remove arr[R]
                while(currR!=r){
                    int x=arr[r];
                    if(freq[x]==k){
                        count--;
                    }
                    freq[x]--;
                    r--;
                }
            }
            if(r<currR){//R++  → add arr[R]
                while(currR!=r){
                    r++;
                    int x=arr[r];
                    freq[x]++;
                    if(freq[x]==k){
                        count++;
                    }
                }
            }
            //after all this the qry range is changed from qry[0] to qry[1] so the curr count is the answer for the qry[1] so add it to the res
            res[curr.index]=count;
        }
        //yeah we need to return it as a list not as an array
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i:res){
            ans.add(i);
        }
        return ans;
    }
}