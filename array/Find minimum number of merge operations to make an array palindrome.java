// Java program to find number of operations
// to make an array palindrome
//for reference-> https://www.geeksforgeeks.org/dsa/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/ 
class GFG
{
    // Returns minimum number of count operations
    // required to make arr[] palindrome
    static int findMinOps(int[] arr, int n)
    {
        int ans = 0; // Initialize result
        int left=0;
        int right=arr.length-1;
        // Start from two corners
        while(left<=right)
        {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[left] == arr[right]){
                left++;
                right--;
            }

            // If left element is greater, then
            // we merge right two elements
            else if (arr[left] > arr[right]){
                // need to merge from tail.
                right--;
                arr[right] += arr[right+1] ; //its an operation so increase the count
                ans++;
            }

            // right element greater or equal we merge left two elements
            else{
                left++;
                arr[left] += arr[left-1];
                ans++;
            }
        }

        return ans;
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 4, 5, 9, 1} ;
        System.out.println("Count of minimum operations is "+
                                findMinOps(arr, arr.length));
    
    }
}