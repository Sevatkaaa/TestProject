package leetcode.anagrams49;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ans = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ans);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<Map<Character, Integer>, List<String>> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> anagrams = getAnagrams(strs[i]);
            if (ans.get(anagrams) == null) {
                List<String> vals = new ArrayList<>();
                vals.add(strs[i]);
                ans.put(anagrams, vals);
            } else {
                ans.get(anagrams).add(strs[i]);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        ans.keySet().stream().forEach(k -> answer.add(ans.get(k)));
        return answer;
    }

    private Map<Character, Integer> getAnagrams(String str) {
        Map<Character, Integer> an = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            an.merge(str.charAt(i), 1, Integer::sum);
        }
        return an;
    }

}
