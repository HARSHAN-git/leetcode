//https://www.geeksforgeeks.org/dsa/make-array-elements-equal-minimum-cost/
//by usine binary search
//here we change the values of l and r 2
class GfG {

    // Function to find the cost of changing
    // array values to mid.
    static int findCost(int[] arr, int mid) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(arr[i] - mid);
        }
        return ans;
    }

    // Function which finds the minimum cost 
    // to make array elements equal.
    static int minCost(int[] arr) {
        int n = arr.length;

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;

        // Find the minimum and maximum value.
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int s = mini, e = maxi;
        int ans = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int cost1 = findCost(arr, mid);
            int cost2 = findCost(arr, mid - 1);

            if (cost1 < cost2) {
                ans = cost1;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 101};
        System.out.println(minCost(arr));
    }
}

//by using recursion in binary search
class rough{
    public static void main(String[] args){
        int[] arr = {1, 100, 101};
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int x : arr) {
            mini = Math.min(mini, x);
            maxi = Math.max(maxi, x);
        }
        int ans = binarySearch(arr, mini, maxi, Integer.MAX_VALUE);
        System.out.println(ans);
    }
    //basic function to find cost
    public static int findcost(int[] arr,int mid){
        int cost=0;
        for(int i=0;i<arr.length;i++){
            cost+=Math.abs(mid-arr[i]); //finding the cost to change all elements in the array to mid
        }
        return cost;
    }

    //lets do binary search to find the element that costs the minimum 
    //for each mid we check if the ans lies in the right side or the left
    public static int binarySearch(int[] arr,int l,int r,int ans){
        if(l==r){
            return Math.min(ans,findcost(arr,l)); //you can use r also,cause the both are equal
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            int cost1=findcost(arr,mid); 
            int cost2=findcost(arr,mid-1);
            //if cost1 is less then ans lies in the right 
            //if cost2 is less then ans lies in the left
            if(cost1<cost2){
                ans=Math.min(ans,cost1);
                return binarySearch(arr,mid+1,r,ans);
            }
            else{
                ans=Math.min(ans,cost2);
                return binarySearch(arr,l,mid,ans);
            }
        }
        return ans;
    }
}