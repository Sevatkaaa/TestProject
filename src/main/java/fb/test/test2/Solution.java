package fb.test.test2;

import java.util.Arrays;

public class Solution {
    int[] countSubarrays(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > cur) {
                    break;
                }
                count++;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > cur) {
                    break;
                }
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.countSubarrays(new int[]{3, 4, 1, 6, 2});
        System.out.println(Arrays.toString(ans));
    }
}
