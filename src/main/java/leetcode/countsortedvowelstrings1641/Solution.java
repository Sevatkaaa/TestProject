package leetcode.countsortedvowelstrings1641;

public class Solution {

    private static int times = 0;

    public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

//    public int countVowelStrings(int n) {
//        return count(n, 5);
//    }
//
//    private int count(int n, int count) {
//        times++;
//        if (count == 1) {
//            return 1;
//        }
//        int ans = 0;
//        for (int i = 0; i <= n; i++) {
//            ans += count(n - i, count - 1);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countVowelStrings(450); // 1746858751 -> overflows
        System.out.println(ans);
        System.out.println(times);
    }
}
