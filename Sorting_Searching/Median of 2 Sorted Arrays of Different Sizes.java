// https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1
//idk how this is a hard question 
//dont merge the arrays , instead use pointers to find the median in an accending order
class Solution {
    public double medianOf2(int[] a, int[] b) {
        // a = {1, 3, 8}
        // b = {2, 5, 10, 11}
        int n = a.length;
        int m = b.length;

        //find the median index
        int total = n + m;
        int median = total / 2;

        //using pointers instead of merging arrays
        int i = 0, j = 0;
        int prev = 0, curr = 0; //here prevoius is there to find median for even length arrays

        for (int count = 0; count <= median; count++) {

            prev = curr;

            if (i < n && j < m) {
                if (a[i] < b[j]) {
                    curr = a[i++]; 
                } else {
                    curr = b[j++];
                }
            }
            else if (i < n) {
                curr = a[i++];
            }
            else {
                curr = b[j++];
            }
        }


        if (total % 2 == 0) {
            return (double)(prev + curr) / 2;
        }

        return curr;
    }
}