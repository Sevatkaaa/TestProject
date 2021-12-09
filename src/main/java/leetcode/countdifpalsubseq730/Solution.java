package leetcode.countdifpalsubseq730;

public class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] count = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            count[i][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                boolean found = false;
                int increment = count[j][i - 1];
                char symbol = s.charAt(i - 1);
                String newS = s.substring(j, i - 1);
                for (int k = 0; k < newS.length(); k++) {
                    if (newS.charAt(k) == symbol) {
                        found = true;
                        increment = (increment + count[j + k + 1][i - 1]) % mod;
                    }
                }
                if (!found) {
                    increment++;
                }
                count[j][i] = increment;
            }
        }
        return count[0][n] - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba");
        System.out.println(ans);
    }
}
