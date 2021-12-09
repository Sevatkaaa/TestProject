package leetcode.longestcomsubseq1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] ans = new int[n1 + 1][n2 + 1];
        int n = n1 + n2 - 1;
        for (int x = 0; x < n; x++) {
            for (int x1 = 0; x1 < n1; x1++) {
                int x2 = x - x1;
                if (x2 < 0 || x2 >= n2) {
                    continue;
                }
                if (text1.charAt(x1) == text2.charAt(x2)) {
                    ans[x1 + 1][x2 + 1] = ans[x1][x2] + 1;
                } else {
                    ans[x1 + 1][x2 + 1] = Math.max(ans[x1][x2 + 1], ans[x1 + 1][x2]);
                }
            }
        }
        return ans[n1][n2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.longestCommonSubsequence("abcde", "ace");
        System.out.println(ans);
    }
}
