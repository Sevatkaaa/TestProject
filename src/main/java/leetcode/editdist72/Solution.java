package leetcode.editdist72;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n2 == 0) {
            return n1;
        }
        if (n1 == 0) {
            return n2;
        }
        int n = Math.max(n1, n2) + 1;
        int maxKey = -1;
        int maxValue = -1;
        Map<Integer, List<Integer>> lcs = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            lcs.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n1; i++) {
            lcs.put(i * n, new ArrayList<>());
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int key = (i + 1) * n + j + 1;
                if (word1.charAt(i) == word2.charAt(j)) {
                    List<Integer> prevAns = new ArrayList<>(lcs.get(i * n + j));
                    prevAns.add(i * n + j);
                    lcs.put(key, prevAns);
                    if (prevAns.size() > maxValue) {
                        maxKey = key;
                        maxValue = prevAns.size();
                    }
                } else {
                    List<Integer> prevAns1 = lcs.get(i * n + j + 1);
                    if (prevAns1 == null) {
                        prevAns1 = new ArrayList<>();
                    }
                    List<Integer> prevAns2 = lcs.get((i + 1) * n + j);
                    if (prevAns2 == null) {
                        prevAns2 = new ArrayList<>();
                    }
                    List<Integer> prevAns = prevAns1.size() < prevAns2.size() ? prevAns2 : prevAns1;
                    if (prevAns.size() > maxValue) {
                        maxKey = key;
                        maxValue = prevAns.size();
                    }
                    lcs.put(key, prevAns);
                }
            }
        }
        List<Integer> maxLcs = lcs.get(maxKey);
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        if (maxLcs.isEmpty()) {
            return n - 1;
        }
        first.add(maxLcs.get(0) / n);
        second.add(maxLcs.get(0) % n);
        for (int i = 0; i < maxLcs.size() - 1; i++) {
            int cur = maxLcs.get(i);
            int next = maxLcs.get(i + 1);
            int curF = cur / n;
            int curS = cur % n;
            int nextF = next / n;
            int nextS = next % n;
            first.add(nextF - curF - 1);
            second.add(nextS - curS - 1);
        }
        first.add(word1.length() - maxLcs.get(maxLcs.size() - 1) / n - 1);
        second.add(word2.length() - maxLcs.get(maxLcs.size() - 1) % n - 1);
        int ans = 0;
        for (int i = 0; i < first.size(); i++) {
            ans += Math.max(first.get(i), second.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.minDistance("mart", "karma");
        System.out.println(ans);
    }

}
