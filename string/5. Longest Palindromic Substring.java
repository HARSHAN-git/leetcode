//https://leetcode.com/problems/longest-palindromic-substring/
public class Solution {
    // Global variables to store the boundaries of the longest palindrome found so far
    private int start;
    private int maxLength;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        start = 0;
        maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (centered at a single character)
            extendPalindrome(s, i, i);
            // Check for even-length palindromes (centered between two characters)
            extendPalindrome(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void extendPalindrome(String s, int left, int right) {
        // Expand as long as the left and right characters match and are within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //now both left and right will be out of boundary or not in the position when they discovered the substring
        // Calculate the current palindrome's length
        int currentLength = right - left - 1;

        // Update the global variables if a longer palindrome is found
        if (currentLength > maxLength) {
            maxLength = currentLength;
            start = left + 1;
        }
    }
}
