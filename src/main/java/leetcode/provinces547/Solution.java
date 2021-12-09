package leetcode.provinces547;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    int[] nodes = isConnected[node];
                    for (int j = 0; j < n; j++) {
                        if (nodes[j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                    visited[node] = true;
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] data = new int[][]{{1, 0, 0}, {1, 0, 0}, {0, 0, 1}};
        int circleNum = s.findCircleNum(data);
        System.out.println(circleNum);
    }
}
