package leetcode.decodeways91;

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int i = 2;
        int[] ways = new int[n + 1];
        if (s.charAt(n - 1) != '0') {
            ways[0] = ways[1] = 1;
        } else {
            if (s.charAt(n - 2) > '2' || s.charAt(n - 2) == '0') {
                return 0;
            }
            ways[2] = 1;
            i++;
        }
        for (; i <= n; i++) {
            if (s.charAt(n - i) == '0') {
                if (s.charAt(n - i - 1) > '2' || s.charAt(n - i - 1) == '0') {
                    return 0;
                }
                ways[i + 1] = ways[i - 1];
            } else if (s.charAt(n - i) > '2' || (s.charAt(n - i + 1) > '6' && s.charAt(n - i) != '1')) {
                ways[i] = ways[i - 1];
            } else {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.numDecodings("2611055971756562");
        System.out.println(ans);
    }
}
