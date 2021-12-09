package fb.test.test7;

import java.util.Arrays;

public class Solution {
    int getTotalTime(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length;
        Arrays.sort(arr);
        int sum = (n - 1) * (arr[n - 1] + arr[n - 2]);
        for (int i = n - 3; i >= 0 ; i--) {
            sum += (i + 1) * arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.getTotalTime(new int[]{2, 3, 9, 8, 4});
        System.out.println(ans);
    }
}
