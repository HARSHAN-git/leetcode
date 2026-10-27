//gonna try merge sort and count the number of inversions 
//inversions->how many elements are remaining in left array when left[i]>right[j]
//the inversions in arr[] = [2, 4, 1, 3, 5] are
// {2,1} ,{4,1} ,{4,3} so total 3 inversions
class Solution {
    int count=0;
    public int inversionCount(int arr[]) {
        merge(arr,0,arr.length-1);
        return count;
    }
    public void merge(int[] arr,int l,int r){
        if(l<r){
            int m=l+(r-l)/2;
            //create two halfes 
            merge(arr,l,m);
            merge(arr,m+1,r); //here m=3
            //now sort them
            sort(arr,l,m,r); //here m=2 not 3
        }
    }
    public void sort(int[] arr,int l,int m,int r){
        int n1=m-l+1; //length of arr1
        int n2=r-m; //length of arr2 ,here m=2 not 3
        
        //create a copy of left and right arrays
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=arr[m+i+1];
        }
        
        //compare the arrays and place the smallest element in the original array
        int i=0,j=0,k=l; //yeah ind of original arr is initially the left ind
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){ //first left only so equals 
                arr[k]=left[i];
                i++;
            }
            else{
                //count inversions
                count+=n1-i; //remaining elements in left half
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        
        //add the remaining elements to the original array(due to he difference in length of both arrs)
        //remaining elements in left half
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        //remaining elements in right half
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    } 
}