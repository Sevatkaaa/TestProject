package kickstart2021.rabbithouse;

import java.util.*;
import java.io.*;

public class Sol {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(r, c, in));
        }
    }

    private static long solve(int r, int c, Scanner in) {
        long count = 0;
        int[][] grid = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        Map<Integer, Set<Integer>> values = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = grid[i][j];
                Set<Integer> integers = values.computeIfAbsent(val, k -> new HashSet<>());
                integers.add(i * c + j);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int max = findMax(grid, r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == max) {
                    q.add(i * c + j);
                }
            }
        }
        while (!q.isEmpty()) {
            Integer current = q.poll();
            int i = current / c;
            int j = current % c;
            int curVal = grid[i][j];
            // left
            if (j != 0) {
                if (!visited[i][j - 1] && grid[i][j - 1] < curVal) {
                    count += curVal - grid[i][j - 1] - 1;
                    grid[i][j - 1] = curVal - 1;
                    q.add(i * c + j - 1);
                    visited[i][j - 1] = true;
                }
            }
            // right
            if (j != c - 1) {
                if (!visited[i][j + 1] && grid[i][j + 1] < curVal) {
                    count += curVal - grid[i][j + 1] - 1;
                    grid[i][j + 1] = curVal - 1;
                    q.add(i * c + j + 1);
                    visited[i][j + 1] = true;
                }
            }
            // top
            if (i != 0) {
                if (!visited[i - 1][j] && grid[i - 1][j] < curVal) {
                    count += curVal - grid[i - 1][j] - 1;
                    grid[i - 1][j] = curVal - 1;
                    q.add((i - 1) * c + j);
                    visited[i - 1][j] = true;
                }
            }
            // bottom
            if (i != r - 1) {
                if (!visited[i + 1][j] && grid[i + 1][j] < curVal) {
                    count += curVal - grid[i + 1][j] - 1;
                    grid[i + 1][j] = curVal - 1;
                    q.add((i + 1) * c + j);
                    visited[i + 1][j] = true;
                }
            }
            Set<Integer> integers = values.get(curVal - 1);
            if (integers != null) {
                integers.forEach(integer -> {
                    int k = integer / c;
                    int l = integer % c;
                    if (!visited[k][l]) {
                        q.add(k * c + l);
                    }
                });
            }
        }
        return count;
    }


    private static int findMax(int[][] grid, int r, int c) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

}
