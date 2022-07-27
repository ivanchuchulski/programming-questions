// 28-implement-strStr.java

class Main {
    public static void main(String[] args) {
        var sol = new Solution();
        
        System.out.println(sol.strStr("hello", "ll"));
        System.out.println(sol.strStr("hello", "dsada"));
        System.out.println(sol.strStr("aaaaaaa", "blala"));
        System.out.println(sol.strStr("hello", "oo"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isBlank() || haystack.isBlank()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int result = i;
                boolean mismatch = false;

                int k = 1;
                int j = i + 1;

                while (k < needle.length() && j < haystack.length()) {
                    if (needle.charAt(k) == haystack.charAt(j)) {
                        k++;
                        j++;
                    } else {
                        mismatch = true;
                        break;
                    }
                }

                if (!mismatch) {
                    // case when there is not mismatch, but needle is not finished and the main
                    // string has
                    if (k < needle.length()) {
                        return -1;
                    }
                    else {
                        return result;
                    }
                }
            }
        }

        return -1;
    }
}