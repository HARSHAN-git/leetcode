//https://www.geeksforgeeks.org/problems/minimum-swaps/1
//new topic-> cycle decomposistion
//A cycle containing n elements requires exactly n - 1 swaps
//this is a genius logic 
/*
1.create a pairs 2d array where each element is mapped with its initial index before sorting
Before sorting-> [2->0,8->1,5->2,4->3]
After sorting -> [2->0,4->3,5->2,8->1]
see here , the Arrays.sort(compare a[0],b[0]) actually sorted the column 1 alongside column 0
now we just detect the cycle here in our case
-4 is the first iteration(i=1) but it has index 3 ,now mark j=1
(here j acts a temporary traversal pointer starting from i when a sorted element is found during each iteration) 
as visited and move to the 3rd index , here the cycle length increase by 1 (clen=1)
-8 is the current index(j=3) now mark its index(3) as visited and move to its original index(1)
-since the index j=1 is marked as visited ,now calculate the length as clen-1 and move on
*/
import java.util.*;
class Solution {
    public int minSwaps(int arr[]) {
        int n=arr.length;
        //creating the map to store the original index before sorting
        int[][] pairs=new int[n][2]; //first column is the number and second col is its original index
        for(int i=0;i<n;i++){
            pairs[i][0]=arr[i];
            pairs[i][1]=i;
        }
        //now sort the pairs array for each row ,along with its columns
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int swaps=0; //our answer
        boolean[] visited=new boolean[n]; //dp to note visited paths to avoid repeated travel
        for(int i=0;i<n;i++){
            //if the element is already visited or it is already in its sorted position 
            //then skip the element as it is not swapped or alread checked through a cycle
            if(visited[i] || pairs[i][1]==i){
                continue;
            }
            int j=pairs[i][1]; //pointer to traverse the cycle
            int cyclelen=0; //cycle length if an element is sorted
            //putting else is your choice my dumb brother
            while(!visited[j]){
                cyclelen++;
                visited[j]=true; //update the dp to avoid repeating the traversal
                j=pairs[j][1]; //update j to the swaped element's original position
            }
            swaps+=cyclelen-1;
        }
        return swaps;
    }
}