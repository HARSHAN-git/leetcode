//yeah the classic 4 sum using sorting,duplicate skipping and 4 pointers
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=arr.length;
        if(arr.length<4){
            return res;
        }
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                int l=j+1;
                int r=n-1;
                while(l<r){
                    int sum=arr[i]+arr[j]+arr[l]+arr[r];
                    if(sum==target){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[l]);
                        temp.add(arr[r]);
                        res.add(temp);
                        l++;
                        r--;
                        while(l<r && arr[l]==arr[l-1]){
                            l++;
                        }
                        while(l<r && arr[r]==arr[r+1]){
                            r--;
                        }
                    }
                    else if(sum<target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
}