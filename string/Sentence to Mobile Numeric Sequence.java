//https://www.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1
//this is optimal dude
class Solution {
    public String printSequence(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            c=Character.toLowerCase(c);
            String code = switch(c) {
                case 'a' -> "2";
                case 'b' -> "22";
                case 'c' -> "222";
                case 'd' -> "3";
                case 'e' -> "33";
                case 'f' -> "333";
                case 'g' -> "4";
                case 'h' -> "44";
                case 'i' -> "444";
                case 'j' -> "5";
                case 'k' -> "55";
                case 'l' -> "555";
                case 'm' -> "6";
                case 'n' -> "66";
                case 'o' -> "666";
                case 'p' -> "7";
                case 'q' -> "77";
                case 'r' -> "777";
                case 's' -> "7777";
                case 't' -> "8";
                case 'u' -> "88";
                case 'v' -> "888";
                case 'w' -> "9";
                case 'x' -> "99";
                case 'y' -> "999";
                case 'z' -> "9999";
                case ' ' -> "0";
                default -> "";
            };
            sb.append(code);
        }
        return sb.toString();
    }
}