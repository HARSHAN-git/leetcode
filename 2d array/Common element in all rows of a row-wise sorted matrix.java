//https://www.geeksforgeeks.org/dsa/find-common-element-rows-row-wise-sorted-matrix/
//the thought of using a hashmap was cool (if element freq==no of rows ,then its the output)
//and checking for duplicates like 3sum is also cool
import java.util.HashMap;
import java.util.Map;

class GFG {

    static int findCommon(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // A hash map to store count of elements
        Map<Integer, Integer> cnt = new HashMap<>();

        int i, j;

        for (i = 0; i < n; i++) {

            // Increment the count of first
            // element of the row
            cnt.put(arr[i][0], cnt.getOrDefault(arr[i][0], 0) + 1);

            // Starting from the second element
            // of the current row
            for (j = 1; j < m; j++) {

                // count only distinct elements in the same row
                if (arr[i][j] != arr[i][j - 1]) {
                    cnt.put(arr[i][j], cnt.getOrDefault(arr[i][j], 0) + 1);
                }
            }
        }

        // Find element having count equal to number of rows
        for (Map.Entry<Integer, Integer> ele : cnt.entrySet()) {
            if (ele.getValue() == n) {
                return ele.getKey();
            }
        }

        // No such element found
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {
            { 1, 2, 3, 4, 5 },
            { 2, 4, 5, 8, 10 },
            { 3, 5, 7, 9, 11 },
            { 1, 3, 5, 7, 9 }
        };

        int result = findCommon(arr);
        System.out.println(result);
    }
}
