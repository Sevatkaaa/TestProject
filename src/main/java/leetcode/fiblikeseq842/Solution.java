package leetcode.fiblikeseq842;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> splitIntoFibonacci(String s) {
        int n = s.length();
        for (int i = 1; i < Math.min(n / 2 + 1, 10); i++) {
            for (int j = 1; j < Math.min(n / 2 + 1, 10); j++) {
                List<Integer> checkFib = checkFib(s, i, j);
                if (!checkFib.isEmpty()) {
                    return checkFib;
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> checkFib(String s, int i, int j) {
        if (s.length() - i - j < Math.max(i, j)) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int f1 = Integer.parseInt(s.substring(0, i));
        int f2 = Integer.parseInt(s.substring(i, i + j));
        ans.add(f1);
        ans.add(f2);
        s = s.substring(i + j);
        while (!s.isEmpty()) {
            int next = f1 + f2;
            if (s.startsWith(next + "")) {
                s = s.substring((next + "").length());
                ans.add(next);
                f1 = f2;
                f2 = next;
            } else {
                return new ArrayList<>();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans = s.splitIntoFibonacci("214748364721474836422147483641");
        System.out.println(ans);
    }
}
