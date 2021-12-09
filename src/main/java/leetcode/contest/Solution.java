package leetcode.contest;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
        System.out.println(ans);
    }

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean[] found = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (found[i]) {
                continue;
            }
            int curAns = 0;
            int cur = nums[i];
            found[cur] = true;
            do {
                cur = nums[cur];
                found[cur] = true;
                curAns++;
            } while (cur != nums[i]);
            ans = Math.max(curAns, ans);
        }
        return ans;
    }

}
