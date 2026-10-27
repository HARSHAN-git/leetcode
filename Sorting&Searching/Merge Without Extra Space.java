import java.util.*;
class Solution {
    public static void main(String[] args){
        int[] a={2, 4, 7, 10};
        int[] b={2,3};
        mergeArrays(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    public static void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int len = n + m;

        int gap = (len + 1) / 2;

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < len) {
                int val1 = (i < n) ? a[i] : b[i - n];
                int val2 = (j < n) ? a[j] : b[j - n];

                if (val1 > val2) {
                    //both values in a
                    if (i < n && j < n) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                    //val1 in a and val2 in b 
                    else if (i < n) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }
                    //both val in b 
                    else {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }

                i++;
                j++;
            }

            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap + 1) / 2;
            }
        }
    }
}