//important algorithm that i personally use
/*
for eg: Consider the following
text=AABAACAABAA    
pat=AABAA
1.find the lsp array for the pattern -lsp[0,1,0,1,2] here lsp[4]=2 cause the proper prefix "AA"
matches with the proper suffix "AA"
FYI- proper prefixes ="A,AA,AAB,AABA"
     proper sufixes ="A,AA,BAA,ABAA"
     there the longest common is "AA" thats y we have 2 at the last and we set j as lsp[j-1] in our 
     code for reset
2.so during a mismatch (here at ind-5 'C' != pat(j=2)->'B') ->see we are comparing B with C not 
starting from A again from the start this makes us automatically take the AA's infront of C into 
account [cool right ;)]
3.no the pointer to the text(i) stays in 'C' as the j looks for any previous matchup and ultimately
ends up as 0 
4.then from the 6th index onwards the pattern matching continues .... 
 */
class Solution {
    static void search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];

        // Build the LPS array
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        // Search for the pattern
        i = 0;
        int j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
}