package leetcode.generateParentheses22;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans = s.generateParenthesis(8);
        System.out.println(ans);
    }

    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> answers = new HashMap<>();
        answers.put(0, Collections.singletonList(""));
        for (int i = 0; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int cur = i * (n + 1) + j;
                List<String> ans;
                if (i == 0) {
                    ans = answers.get(cur - 1).stream().map(t -> t + "(").collect(Collectors.toList());
                    answers.put(cur, ans);
                    continue;
                }
                if (i == j) {
                    ans = answers.get(cur - n - 1).stream().map(t -> t + ")").collect(Collectors.toList());
                    answers.put(cur, ans);
                    continue;
                }
                ans = answers.get(cur - 1).stream().map(t -> t + "(").collect(Collectors.toList());
                ans.addAll(answers.get(cur - n - 1).stream().map(t -> t + ")").collect(Collectors.toList()));
                answers.put(cur, ans);
            }
        }
        return answers.get(n * n + 2 * n);
    }
}
