package leetcode.longestpalindrom5;

class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = n; i > 1; i--) {
            int palNum = n - i + 1;
            for (int j = 0; j < palNum; j++) {
                if (chekPal(chars, i, j)) {
                    return s.substring(j, i + j);
                }
            }
        }
        return s.substring(0, 1);
    }

    private boolean chekPal(char[] chars, int len, int start) {
        for (int i = start; i < start + len / 2; i++) {
            if (chars[i] != chars[len + 2 * start - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.longestPalindrome("abcdcb");
        System.out.println(ans);
    }
}
