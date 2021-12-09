package leetcode.surregions130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || visited[i][j]) {
                    continue;
                }
                List<Integer> curValues = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i * n + j);
                curValues.add(i * n + j);
                boolean found = false;
                while (!q.isEmpty()) {
                    Integer cur = q.poll();
                    int curM = cur / n;
                    int curN = cur % n;
                    visited[curM][curN] = true;
                    if (curM == 0 || curM == m - 1 || curN == 0 || curN == n - 1) {
                        found = true;
                    }
                    if (curM != 0 && board[curM - 1][curN] == 'O' && !visited[curM - 1][curN]) {
                        q.add((curM - 1) * n + curN);
                        curValues.add((curM - 1) * n + curN);
                    }
                    if (curM != m - 1 && board[curM + 1][curN] == 'O' && !visited[curM + 1][curN]) {
                        q.add((curM + 1) * n + curN);
                        curValues.add((curM + 1) * n + curN);
                    }
                    if (curN != 0 && board[curM][curN - 1] == 'O' && !visited[curM][curN - 1]) {
                        q.add(curM * n + curN - 1);
                        curValues.add(curM * n + curN - 1);
                    }
                    if (curN != n - 1 && board[curM][curN + 1] == 'O' && !visited[curM][curN + 1]) {
                        q.add(curM * n + curN + 1);
                        curValues.add(curM * n + curN + 1);
                    }
                }
                if (found) {
                    curValues.forEach(v -> board[v / n][v % n] = 'S');
                } else {
                    curValues.forEach(v -> board[v / n][v % n] = 'X');
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void main(String[] args) {
//        char[][] q = new char[20][20];
//        q[0] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[1] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[2] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[3] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[4] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[5] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[6] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[7] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[8] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[9] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[10] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[11] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[12] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[13] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[14] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[15] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[16] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[17] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
//        q[18] = "XOXOXXOXOXXOXOXXOXOX".toCharArray();
//        q[19] = "OXOXOOXOXOOXOXOOXOXO".toCharArray();
        char[][] q = new char[4][4];
        q[0] = "XXXX".toCharArray();
        q[1] = "XOOX".toCharArray();
        q[2] = "XXOX".toCharArray();
        q[3] = "XOXX".toCharArray();
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        s.solve(q);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
        for (int i = 0; i < q.length; i++) {
            System.out.println(String.valueOf(q[i]));
        }
    }

}
