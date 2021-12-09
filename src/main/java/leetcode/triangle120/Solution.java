package leetcode.triangle120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        int ans = s.minimumTotal(Arrays.asList(l1, l2, l3, l4));
        System.out.println(ans);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = triangle.size();
        ans.add(triangle.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> curLine = triangle.get(i);
            List<Integer> nextLineMin = ans.get(0);
            List<Integer> curAns = new ArrayList<>();
            for (int j = 0; j < curLine.size(); j++) {
                Integer cur = curLine.get(j);
                curAns.add(Math.min(nextLineMin.get(j), nextLineMin.get(j + 1)) + cur);
            }
            ans.add(0, curAns);
        }
        return ans.get(0).get(0);
    }

}
