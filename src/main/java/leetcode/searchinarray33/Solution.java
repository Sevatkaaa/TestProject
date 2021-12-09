package leetcode.searchinarray33;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.search(new int[]{3, 1}, 0);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        return pivotSearch(nums, target, 0, nums.length - 1);
    }

    private int pivotSearch(int[] nums, int target, int l, int r) {
        int n = r - l + 1;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[l] == target ? l : -1;
        }
        if (n == 2) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            return -1;
        }
        int left = nums[l];
        int right = nums[r];
        if (left < right) {
            return binarySearch(nums, target, l, r);
        }
        if (target == left) {
            return l;
        }
        if (target == right) {
            return r;
        }
        int m = (l + r) / 2;
        int mid = nums[m];
        if (target == mid) {
            return m;
        }
        if (target < left) {
            if (mid < left) {
                if (target < mid) {
                    return pivotSearch(nums, target, l, m);
                } else {
                    return pivotSearch(nums, target, m, r);
                }
            } else {
                return pivotSearch(nums, target, m, r);
            }
        } else {
            if (mid < left) {
                return pivotSearch(nums, target, l, m);
            } else {
                if (target < mid) {
                    return pivotSearch(nums, target, l, m);
                } else {
                    return pivotSearch(nums, target, m, r);
                }
            }
        }
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        int n = r - l + 1;
        if (n == 1) {
            return nums[l] == target ? l : -1;
        }
        if (n == 2) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            return -1;
        }
        int m = (l + r) / 2;
        int mid = nums[m];
        if (target == mid) {
            return m;
        }
        if (target < mid) {
            return binarySearch(nums, target, l, m);
        } else {
            return binarySearch(nums, target, m, r);
        }
    }

}
