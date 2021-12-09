package leetcode.arprog1502;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return true;
        }
        int min = arr[0];
        int sum = min;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            sum += arr[i];
        }
        sum -= min * n;
        int x = 2 * sum / n / (n - 1);
        int realSum = x * n * (n-1) / 2;
        if (realSum != sum) {
            return false;
        }
        if (x == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        boolean[] data = new boolean[n];
        for (int i = 0; i < n; i++) {
            int current = arr[i] - min;
            if (current / x * x != current) {
                return false;
            }
            data[current / x] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!data[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 5, 1};
        boolean b = s.canMakeArithmeticProgression(arr);
        System.out.println(b);
    }
}
