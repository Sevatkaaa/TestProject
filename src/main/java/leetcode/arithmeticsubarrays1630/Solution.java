package leetcode.arithmeticsubarrays1630;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(isArSubArray(nums, l[i], r[i]));
        }
        return ans;
    }

    private boolean isArSubArray(int[] nums, int l, int r) {
        int n = r - l + 1;
        int min = nums[l];
        int sum = nums[l];
        for (int i = l + 1; i < l + n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        sum -= min * n;
        int x = sum / (n * (n - 1) / 2);
        int realSum = x * (n * (n - 1) / 2);
        if (sum != realSum) {
            return false;
        }
        if (x == 0) {
            for (int j = 0; j < n - 1; j++) {
                if (nums[j + l] != nums[j + l + 1]) {
                    return false;
                }
            }
            return true;
        }
        boolean[] isNum = new boolean[n];
        for (int i = l; i < l + n; i++) {
            int value = nums[i] - min;
            int current = value / x;
            if (current * x != value || current >= n) {
                return false;
            }
            isNum[current] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!isNum[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> ans = s.checkArithmeticSubarrays(new int[]{1,2,10,-6,-7,8,16,0,0,10,20,15,-2,-3,-1,-4,-4,-8,-2}, new int[]{14,5,11,15,12,13,9,7,0}, new int[]{15,8,14,18,15,16,12,8,1});
        System.out.println(ans);
    }
}
