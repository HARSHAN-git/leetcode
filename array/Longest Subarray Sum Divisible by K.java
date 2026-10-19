// https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
/* java mod behaviour
normally -2 mod 6 = 4 and 2 mod 6 = 2;
but in java -2 mod 6 = -2 and 2 mod 6 = 2;

for our hash map logic using prefix sum 

case 1(positive):
arr[]  = [2, 7, 6, 1, 4, 5], k = 3
pref[] = [2,9,15,16,20,25]
rem hash=[2,0, 0, 1, 2, 1]
if the key is 3 and the curr prefixsum is 20(20%3=2) we look for elments with remainder 2 ,if 2 is present before 20
in the array [2, 7, 6, 1, 4, 5] then simply remove the number with rem 2 from the subarray(cause 2%6=2)
so from 9 to 20 -> 9+15+16+20=60 which  is div by 3 ,which is the subarray length for key 3
so by removing that nonsense of a 2 helped us to build a sum of 60 instead of 62

case 2(negative):
arr=[-2,12]
prf=[-2,10]
if the key is 6 and the curr prefixsum is 10(10%6=4) we look for elements with remainder 4,if -2 is present before 10
in the array [-2,12] then ,simply removing -2 will make the currsum 12 which is div by 6

so do remainder=((cur%k)+k)%k
eg:
positive- ((2%6)+6)%6=2%6 (cause 2%6 is the same as 8%6)
negative-((-2%6)+6)%6=((-2)+6)%6=(4)%6=4 ,we get remainder 4 for -2 which is we want rather than -2%6=-2
*/
import java.util.HashMap;
import java.util.Map;

class Solution{
    static int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length, res = 0;
        Map<Integer, Integer> prefIdx = new HashMap<>();
        // int sum = 0;
        int pref=0;
        int rem=0;
        // Iterate over all ending points
        for (int i = 0; i < n; i++) {

            // prefix sum mod k (handling negative prefix sum)
            pref+=arr[i];
            rem=((pref%k)+k)%k;
            // sum = ((sum + arr[i]) % k + k) % k; //we dont use a prefix array cause doing prefix[i]=prefix[i]+arr[i]
            //can cause integerOverflow so we calculate it on the way

            // If sum == 0, then update result with the
            // length of subarray arr[0...i] cause 0 is divisibly by any value
            // if (sum == 0)
            //     res = i + 1;
            if(rem==0)
                res=Math.max(res, i + 1);

            // Update max length for repeating sum
            else if (prefIdx.containsKey(rem)) { //if you use sum then put sum
                res = Math.max(res, i - prefIdx.get(rem));
            }

            // Store the first occurrence of sum
            else {
                prefIdx.put(rem, i); //if you use sum then put some
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;

        System.out.println(longestSubarrayDivK(arr, k));
    }
}