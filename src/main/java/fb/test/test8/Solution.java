package fb.test.test8;

public class Solution {
    int minOverallAwkwardness(int[] arr) {
        int n = arr.length;
        int minEl = arr[0];
        int maxEl = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < minEl) {
                minEl = arr[i];
            }
            if (arr[i] > maxEl) {
                maxEl = arr[i];
            }
        }
        int ans = maxEl - minEl;
        int ans2 = ans;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int minDif = Math.abs(cur - minEl);
            int maxDif = Math.abs(cur - maxEl);
            int curAns = Math.max(minDif, maxDif);
            if (curAns < ans) {
                ans2 = ans;
                ans = curAns;
            } else if (curAns < ans2) {
                ans2 = curAns;
            }
        }
        return Math.max(ans, ans2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.minOverallAwkwardness(new int[]{1, 2, 5, 3, 7});
        System.out.println(ans);
    }
}
