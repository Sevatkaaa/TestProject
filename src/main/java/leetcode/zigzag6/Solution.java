package leetcode.zigzag6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.convert("ABC", 2);
        System.out.println(ans);
    }
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new StringBuilder());
        }
        convert(s, numRows, ans);
        return ans.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }

    private void convert(String s, int numRows, List<StringBuilder> ans) {
        if (s.length() <= numRows * 2 - 2) {
            for (int i = 0; i < numRows; i++) {
                if (i == s.length()) {
                    return;
                }
                ans.get(i).append(s.charAt(i));
            }
            for (int i = numRows - 2; i > 0; i--) {
                if (2 * numRows - i - 2 == s.length()) {
                    return;
                }
                ans.get(i).append(s.charAt(2 * numRows - i - 2));
            }
        } else {
            for (int i = 0; i < numRows; i++) {
                ans.get(i).append(s.charAt(i));
            }
            for (int i = numRows - 2; i > 0; i--) {
                ans.get(i).append(s.charAt( 2 * numRows - i - 2));
            }
            convert(s.substring(2 * numRows - 2), numRows, ans);
        }
    }
}
