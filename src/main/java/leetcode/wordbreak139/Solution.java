package leetcode.wordbreak139;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean ans = s.wordBreak("applepie",
                Arrays.asList("pie","pear","apple","peach"));
        System.out.println(ans);
    }
    private static final Set<String> impossible = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        if (impossible.contains(s)) {
            return false;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word)) {
                String cur = s.substring(word.length());
                if (wordBreak(cur, wordDict)) {
                    return true;
                } else {
                    impossible.add(cur);
                }
            }
        }
        return false;
    }
}
