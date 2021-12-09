package leetcode.trappingrainwater42;

import java.util.*;

class Solution {

//    class MaxInteger {
//        int value;
//        Set<Integer> indices;
//
//        public MaxInteger(int value, Set<Integer> indices) {
//            this.value = value;
//            this.indices = indices;
//        }
//    }
//
//    public int trap(int[] height) {
//        int n = height.length;
//
//        if(n == 0) {
//            return 0;
//        }
//
//        // LOG
//        List<Integer> log = new ArrayList<>();
//        log.add(0);
//        log.add(0);
//        for (int i = 2; i <= n; i++) {
//            log.add(1 + log.get(i / 2));
//        }
//
//        // SPARSE TABLE
//        List<List<MaxInteger>> sparseTable = new ArrayList<>();
//        Integer logN = log.get(n);
//        List<MaxInteger> zeroRow = new ArrayList<>();
//        for (int i = 0; i < height.length; i++) {
//            zeroRow.add(new MaxInteger(height[i], Collections.singleton(i)));
//        }
//        sparseTable.add(zeroRow);
//        for (int i = 1; i <= logN; i++) {
//            List<MaxInteger> row = new ArrayList<>();
//            int pow = (int)Math.pow(2, i - 1);
//            for (int j = 0; j < n - pow * 2 + 1; j++) {
//                List<MaxInteger> prevRow = sparseTable.get(i - 1);
//                MaxInteger m1 = prevRow.get(j);
//                MaxInteger m2 = prevRow.get(j + pow);
//                if (m1.value != m2.value) {
//                    if (m1.value > m2.value) {
//                        row.add(new MaxInteger(m1.value, m1.indices));
//                    } else {
//                        row.add(new MaxInteger(m2.value, m2.indices));
//                    }
//                } else {
//                    Set<Integer> indices = new HashSet<>(m1.indices);
//                    indices.addAll(m2.indices);
//                    row.add(new MaxInteger(m1.value, indices));
//                }
//            }
//            sparseTable.add(row);
//        }
//
//        // SUM
//        List<Integer> sums = new ArrayList<>();
//        sums.add(0);
//        for (int i = 0; i < n; i++) {
//            sums.add(height[i] + sums.get(i));
//        }
//
//        // SOLUTION
//        MaxInteger m1 = sparseTable.get(logN).get(0);
//        MaxInteger m2 = sparseTable.get(logN).get(n - (int)Math.pow(2, logN));
//        int maxValue;
//        Set<Integer> maxIndices;
//        if (m1.value == m2.value) {
//            maxValue = m1.value;
//            maxIndices = new HashSet<>(m1.indices);
//            maxIndices.addAll(m2.indices);
//        } else {
//            if (m1.value > m2.value) {
//                maxValue = m1.value;
//                maxIndices = m1.indices;
//            } else {
//                maxValue = m2.value;
//                maxIndices = m2.indices;
//            }
//        }
//        List<Integer> ind = new ArrayList<>(maxIndices);
//        Integer leftMax = ind.get(0);
//        Integer rightMax = ind.get(ind.size() - 1);
//        int sum = 0;
//        sum += (rightMax - leftMax) * maxValue - (sums.get(rightMax) - sums.get(leftMax));
//
//        int leftNextMaxIndex = leftMax;
//        int rightNextMaxIndex = rightMax;
//        while (leftMax != 0 || rightMax != n - 1) {
//            sum += (leftMax - leftNextMaxIndex) * height[leftNextMaxIndex] - (sums.get(leftMax) - sums.get(leftNextMaxIndex));
//            sum += (rightNextMaxIndex - rightMax) * height[rightNextMaxIndex] - (sums.get(rightNextMaxIndex + 1) - sums.get(rightMax + 1));
//
//            leftMax = leftNextMaxIndex;
//            rightMax = rightNextMaxIndex;
//            if (leftMax != 0) {
//                int nextLeftLog = log.get(leftMax);
//                int nextLeftPow = (int)Math.pow(2, nextLeftLog);
//                MaxInteger nextLeftM1 = sparseTable.get(nextLeftLog).get(0);
//                MaxInteger nextLeftM2 = sparseTable.get(nextLeftLog).get(leftMax - nextLeftPow);
//                if (nextLeftM1.value < nextLeftM2.value) {
//                    leftNextMaxIndex = new ArrayList<>(nextLeftM2.indices).get(0);
//                } else {
//                    leftNextMaxIndex = new ArrayList<>(nextLeftM1.indices).get(0);
//                }
//            }
//
//            if (rightMax != n - 1) {
//                int nextRightLog = log.get(n - rightMax - 1);
//                int nextRightPow = (int)Math.pow(2, nextRightLog);
//                MaxInteger nextRightM1 = sparseTable.get(nextRightLog).get(rightMax + 1);
//                MaxInteger nextRightM2 = sparseTable.get(nextRightLog).get(n - nextRightPow);
//                if (nextRightM1.value > nextRightM2.value) {
//                    rightNextMaxIndex = new ArrayList<>(nextRightM1.indices).get(nextRightM1.indices.size() - 1);
//                } else {
//                    rightNextMaxIndex = new ArrayList<>(nextRightM2.indices).get(nextRightM2.indices.size() - 1);
//                }
//            }
//        }
//        return sum;
//    }

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = height[0];
        for(int i = 0; i < n; i++) {
            if (max >= height[i]) {
                left[i] = max;
            } else {
                max = height[i];
                left[i] = max;
            }
        }
        max = height[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            if (max >= height[i]) {
                right[i] = max;
            } else {
                max = height[i];
                right[i] = max;
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.min(right[i], left[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] data = new int[]{9, 1, 1, 1, 10, 3, 4, 10, 8, 9};
        Solution s = new Solution();
        int trap = s.trap(data);
        System.out.println(trap);
    }
}
