package hackerrank.castleongrid;

import java.io.*;
import java.util.*;

public class Solution {

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        boolean[][] graph = convertGridToGraph(grid);
        int start = startX * grid.length + startY;
        int end = goalX * grid.length + goalY;
        int nSq = graph.length;
        boolean[] visited = new boolean[nSq];
        int[] moves = new int[nSq];
        for (int i = 0; i < nSq; i++) {
            moves[i] = nSq;
        }
        moves[start] = 0;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start);
        while (!nodes.isEmpty()) {
            Integer node = nodes.poll();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (int i = 0; i < nSq; i++) {
                if (graph[node][i]) {
                    nodes.add(i);
                    int newMoves = moves[node] + 1;
                    if (moves[i] > newMoves) {
                        moves[i] = newMoves;
                    }
                    if (i == end) {
                        return moves[i];
                    }
                }
            }
        }
        return -1;
    }

    private static boolean[][] convertGridToGraph(String[] grid) {
        int n = grid.length;
        boolean[][] graph = new boolean[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            int aX = i / n;
            int aY = i % n;
            if (grid[aX].charAt(aY) == 'X') {
                continue;
            }
            for (int j = i + 1; j < n * n; j++) {
                int bX = j / n;
                int bY = j % n;
                if (grid[bX].charAt(bY) == 'X') {
                    continue;
                }
                if (aX != bX && aY != bY) {
                    continue;
                }
                if (aX == bX) {
                    boolean isWall = false;
                    for (int k = aY; k < bY; k++) {
                        if (grid[aX].charAt(k) == 'X') {
                            isWall = true;
                            break;
                        }
                    }
                    if (!isWall) {
                        graph[i][j] = true;
                        graph[j][i] = true;
                    }
                }
                if (aY == bY) {
                    boolean isWall = false;
                    for (int k = aX; k < bX; k++) {
                        if (grid[k].charAt(aY) == 'X') {
                            isWall = true;
                            break;
                        }
                    }
                    if (!isWall) {
                        graph[i][j] = true;
                        graph[j][i] = true;
                    }
                }
            }
        }
        return graph;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println((result));

        scanner.close();
    }
}

