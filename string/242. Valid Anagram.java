// https://leetcode.com/problems/valid-anagram/
class Solution {
    //array method more effecient 
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];
        for (char ch : s.toCharArray()) {
            sChar[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            tChar[ch-'a']++;
        }

        return Arrays.equals(sChar,tChar);
    }
}
//HashMap approach
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()){
//             return false;
//         }
//         HashMap<Character,Integer> hm1=new HashMap<>();
//         HashMap<Character,Integer> hm2=new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             char c1=s.charAt(i);
//             char c2=t.charAt(i);
//             hm1.put(c1,hm1.getOrDefault(c1,0)+1);
//             hm2.put(c2,hm2.getOrDefault(c2,0)+1);
//         }
//         return hm1.equals(hm2);
//     }
// }