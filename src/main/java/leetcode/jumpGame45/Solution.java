package leetcode.jumpGame45;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.jumps(new int[]{3, 2, 1, 1, 4});
        System.out.println(ans);
    }

    public int jumps(int[] nums) {
        return jumps(nums, nums.length - 1);
    }

    private int jumps(int[] nums, int n) {
        if (n <= 0) {
            return 0;
        }
        int min = n;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + i >= n) {
                min = i;
            }
        }
        return jumps(nums, min) + 1;
    }

//    public boolean canJump(int[] nums) {
//        if (nums[0] == 0) {
//            return nums.length == 1;
//        }
//        boolean[] isJumped = new boolean[nums.length];
//        Set<Integer> added = new HashSet<>();
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        isJumped[0] = true;
//        while(!q.isEmpty()) {
//            Integer cur = q.poll();
//            if (added.contains(cur)) {
//                continue;
//            }
//            added.add(cur);
//            int maxSteps = nums[cur];
//            for (int i = cur + 1; i < Math.min(nums.length, cur + maxSteps + 1); i++) {
//                if (!added.contains(i)) {
//                    q.add(i);
//                    isJumped[i] = true;
//                }
//            }
//        }
//        return isJumped[nums.length - 1];
//    }
}
