//https://www.geeksforgeeks.org/dsa/find-duplicates-in-on-time-and-constant-extra-space/
//approach 1:since the elements are from 0 to n-1 we can use freq array to calculate duplicates
import java.util.*;
class GfG {

    static int[] findDuplicates(int[] arr) {

        int n = arr.length;
        int[] freqArr = new int[n]; 
        List<Integer> result = new ArrayList<>();

        // Step 2: Iterate through the array
        // and count element frequencies
        for (int i = 0; i < n; i++) {
            freqArr[arr[i]]++;
        }

        // Step 3: Iterate through all the possible
        // elements to check duplicates
        for (int i = 0; i < n; i++) {
            if (freqArr[arr[i]] > 1) {
                result.add(arr[i]);
                freqArr[arr[i]]
                    = 0; // To avoid adding duplicates again
            }
        }

        // Step 4: If no duplicates found, add -1 to the
        // result
        if (result.isEmpty()) {
            result.add(-1);
        }

        // Convert the result list to an array and return
        return result.stream().mapToInt(i -> i).toArray();
    }
}

//approach 2:classic hashmap for finding duplicates
// Java code to find duplicates in an array
// using hashmap
class GfG2 {

    static List<Integer> findDuplicates(Integer[] arr) {

        // Step 1: Create an empty hashmap to store
        // element frequencies
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 2: Iterate through the array and
        // count element frequencies
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i],
                        freqMap.getOrDefault(arr[i], 0)
                            + 1);
        }

        // Step 3: Iterate through the hashmap to find
        // duplicates
        for (Map.Entry<Integer, Integer> entry :
             freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        // Step 4: If no duplicates found, add -1 to the
        // result
        if (result.isEmpty()) {
            result.add(-1);
        }

        // Step 6: Return the result list containing
        // duplicate elements or -1
        return result;
    }
}