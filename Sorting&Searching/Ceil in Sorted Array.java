//lets try a simple for loop first
//easiest question ever to exist
class Solution {
    public int findCeil(int[] arr, int x) {
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>=x){
                return i;
            }
        }
        return -1;
    }
}
