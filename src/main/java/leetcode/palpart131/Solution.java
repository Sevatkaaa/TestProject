package leetcode.palpart131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 1) {
            List<String> ans1 = new ArrayList<>();
            ans1.add(s);
            ans.add(ans1);
            return ans;
        }
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(0, i + 1);
            if (isPal(cur)) {
                List<List<String>> partition = partition(s.substring(i + 1));
                if (partition != null) {
                    partition.stream().peek(p -> p.add(0, cur)).forEach(ans::add);
                }
            }
        }
        if (s.length() > 1 && isPal(s)) {
            List<String> sAns = new ArrayList<>();
            sAns.add(s);
            ans.add(sAns);
        }
        return ans;
    }

    private boolean isPal(String cur) {
        StringBuilder sb = new StringBuilder(cur);
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ans = s.partition("aab");
        System.out.println(ans);
    }
}
