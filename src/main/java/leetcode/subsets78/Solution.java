package leetcode.subsets78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(nums[i]);
        }
        add0(answers);
        if (n == 0) {
            return answers;
        }
        add1(nums, n, answers);
        if (n == 1) {
            return answers;
        }
        add2(nums, n, answers);
        if (n == 2) {
            return answers;
        }
        add3(nums, n, answers);
        if (n == 3) {
            return answers;
        }
        add4(nums, n, answers);
        if (n == 4) {
            return answers;
        }
        add5(nums, n, answers);
        if (n == 5) {
            return answers;
        }
        int len = answers.size();
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>(numbers);
            temp.removeAll(answers.get(i));
            if (temp.size() <= n && temp.size() > 5) {
                answers.add(temp);
            }
        }
        return answers;
    }

    private void add5(int[] nums, int n, List<List<Integer>> answers) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        for (int m = l + 1; m < n; m++) {
                            answers.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l], nums[m]));
                        }
                    }
                }
            }
        }
    }

    private void add4(int[] nums, int n, List<List<Integer>> answers) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        answers.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
    }

    private void add3(int[] nums, int n, List<List<Integer>> answers) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
    }

    private void add2(int[] nums, int n, List<List<Integer>> answers) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answers.add(Arrays.asList(nums[i], nums[j]));
            }
        }
    }

    private void add1(int[] nums, int n, List<List<Integer>> answers) {
        for (int i = 0; i < n; i++) {
            answers.add(Collections.singletonList(nums[i]));
        }
    }

    private void add0(List<List<Integer>> answers) {
        answers.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3, 4, 5, 6, 7});
        subsets.stream().forEach(System.out::println);
    }
}
