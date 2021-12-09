package fb.test.test5;

import java.util.*;

public class Solution {

    int minOperations(int[] arr) {
        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> movesNum = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        movesNum.put(sb.toString(), 0);
        q.add(sb.toString());
        Arrays.sort(arr);
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String finish = sb.toString();
        while(!q.isEmpty()) {
            String cur = q.poll();
            if (!visited.add(cur)) {
                continue;
            }
            Integer curMoves = movesNum.get(cur);
            if (cur.equals(finish)) {
                return curMoves;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    String newCur = cur.substring(0, i) + new StringBuilder(cur.substring(i, j + 1)).reverse().toString() + cur.substring(j + 1);
                    q.add(newCur);
                    Integer newCurMoves = movesNum.get(newCur);
                    if (newCurMoves == null || newCurMoves > curMoves) {
                        movesNum.put(newCur, curMoves + 1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.minOperations(new int[]{3, 1, 2});
        System.out.println(ans);
    }
}
