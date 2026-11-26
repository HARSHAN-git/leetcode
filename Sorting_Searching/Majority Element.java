//ig we gotta use boyer's algorithm for finding the candidate
class Solution {
    int majorityElement(int arr[]) {
        int candidate = arr[0];
        int count = 1;
        // step 1:find the candidate
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // step2:verify the freq of the candidate
        int freq = 0;
        for (int i : arr) {
            if (i == candidate) {
                freq++;
            }
        }
        if (freq > arr.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}