package leetcode.mediansortedarrays4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        int mIndex = 0;
        int nIndex = 0;
        for (int i = 0; i < ans.length; i++) {
            if (mIndex == m) {
                ans[i] = nums2[nIndex++];
            } else if (nIndex == n) {
                ans[i] = nums1[mIndex++];
            } else {
                if (nums1[mIndex] < nums2[nIndex]) {
                    ans[i] = nums1[mIndex++];
                } else {
                    ans[i] = nums2[nIndex++];
                }
            }
        }
        if (ans.length % 2 == 1) {
            return ans[ans.length / 2];
        } else {
            return (ans[ans.length / 2 - 1] + ans[ans.length / 2]) / 2.0;
        }
    }
}
