package kickstart2021.rabbithouse;

import java.util.*;
import java.io.*;

public class Solution {

//    static class Element {
//        int value;
//        int index;
//
//        public Element(int value, int index) {
//            this.value = value;
//            this.index = index;
//        }
//    }

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
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        Map<Integer, Set<Integer>> values = new HashMap<>();
        int max = findMax(grid, r, c, values);
        long[] count = new long[]{0};
        for (int i = max; i >= max - r - c; i--) {
            Set<Integer> integers = values.get(i);
            if (integers == null) {
                continue;
            }
            integers.stream().forEach(val -> {
                int iCord = val / c;
                int jCord = val % c;
                int curVal = grid[iCord][jCord];
                values.computeIfAbsent(curVal - 1, k -> new HashSet<>());
                Set<Integer> newValues = values.get(curVal - 1);
                // left
                if (jCord != 0) {
                    if (grid[iCord][jCord - 1] < curVal - 1) {
                        count[0] += curVal - grid[iCord][jCord - 1] - 1;
                        Set<Integer> vals = values.get(grid[iCord][jCord - 1]);
                        vals.remove(iCord * c + jCord - 1);
                        grid[iCord][jCord - 1] = curVal - 1;
                        newValues.add(iCord * c + jCord - 1);
                    }
                }
                // right
                if (jCord != c - 1) {
                    if (grid[iCord][jCord + 1] < curVal - 1) {
                        count[0] += curVal - grid[iCord][jCord + 1] - 1;
                        Set<Integer> vals = values.get(grid[iCord][jCord + 1]);
                        vals.remove(iCord * c + jCord + 1);
                        grid[iCord][jCord + 1] = curVal - 1;
                        newValues.add(iCord * c + jCord + 1);
                    }
                }
                // top
                if (iCord != 0) {
                    if (grid[iCord - 1][jCord] < curVal - 1) {
                        count[0] += curVal - grid[iCord - 1][jCord] - 1;
                        Set<Integer> vals = values.get(grid[iCord - 1][jCord]);
                        vals.remove((iCord - 1) * c + jCord);
                        grid[iCord - 1][jCord] = curVal - 1;
                        newValues.add((iCord - 1) * c + jCord);
                    }
                }
                // bottom
                if (iCord != r - 1) {
                    if (grid[iCord + 1][jCord] < curVal - 1) {
                        count[0] += curVal - grid[iCord + 1][jCord] - 1;
                        Set<Integer> vals = values.get(grid[iCord + 1][jCord]);
                        vals.remove((iCord + 1) * c + jCord);
                        grid[iCord + 1][jCord] = curVal - 1;
                        newValues.add((iCord + 1) * c + jCord);
                    }
                }
            });
        }
        return count[0];
    }

    private static int findMax(int[][] grid, int r, int c, Map<Integer, Set<Integer>> values) {
        int max = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = grid[i][j];
                if (val > max) {
                    max = val;
                }
                Set<Integer> integers = values.get(val);
                if (integers == null) {
                    integers = new HashSet<>();
                    integers.add(i * c + j);
                    values.put(val, integers);
                } else {
                    integers.add(i * c + j);
                }
            }
        }
        return max;
    }

//    private static long solve(int r, int c, Scanner in) {
//        int[][] grid = new int[r][c];
//        Queue<Element> q = new PriorityQueue<>(r * c, Comparator.comparing(e -> e.value));
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                int val = in.nextInt();
//                grid[i][j] = val;
//                q.add(new Element(val, i * c + j));
//            }
//        }
//        int count = 0;
//        while (!q.isEmpty()) {
//            Element el = q.poll();
//            int iCord = el.index / c;
//            int jCord = el.index % c;
//            int curVal = el.value;
//            if (grid[iCord][jCord] != curVal) {
//                continue;
//            }
//            if (jCord != 0) {
//                if (grid[iCord][jCord - 1] < curVal) {
//                    count += curVal - grid[iCord][jCord - 1] - 1;
//                    grid[iCord][jCord - 1] = curVal - 1;
//                    q.add(new Element(curVal - 1, iCord * c + jCord - 1));
//                }
//            }
//            // right
//            if (jCord != c - 1) {
//                if (grid[iCord][jCord + 1] < curVal) {
//                    count += curVal - grid[iCord][jCord + 1] - 1;
//                    grid[iCord][jCord + 1] = curVal - 1;
//                    q.add(new Element(curVal - 1, iCord * c + jCord + 1));
//                }
//            }
//            // top
//            if (iCord != 0) {
//                if (grid[iCord - 1][jCord] < curVal) {
//                    count += curVal - grid[iCord - 1][jCord] - 1;
//                    grid[iCord - 1][jCord] = curVal - 1;
//                    q.add(new Element(curVal - 1, (iCord - 1) * c + jCord));
//                }
//            }
//            // bottom
//            if (iCord != r - 1) {
//                if (grid[iCord + 1][jCord] < curVal) {
//                    count += curVal - grid[iCord + 1][jCord] - 1;
//                    grid[iCord + 1][jCord] = curVal - 1;
//                    q.add(new Element(curVal - 1, (iCord + 1) * c + jCord));
//                }
//            }
//        }
//        return count;
//    }
}
