package example.leetcode;

public class Leetcode_58_Length_of_Last_Word {
    public  int lengthOfLastWord(String s) {
        int result = 0;
        char spaceLiteral = ' ';

        int i = s.length() - 1;

        while (s.charAt(i) == spaceLiteral) {
            i--;
        }

        while (i >= 0 && s.charAt(i) != spaceLiteral) {
            i--;
            result++;
        }

        return result;
    }
}
