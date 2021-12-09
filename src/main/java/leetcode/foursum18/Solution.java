package leetcode.foursum18;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    class Quadr {
        int a;
        int b;
        int c;
        int d;

        public Quadr(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quadr quadr = (Quadr) o;
            return a == quadr.a &&
                    b == quadr.b &&
                    c == quadr.c &&
                    d == quadr.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Quadr> ans = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> ansNotSorted = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            ansNotSorted.sort(Comparator.comparing(Function.identity()));
                            ans.add(new Quadr(ansNotSorted.get(0), ansNotSorted.get(1), ansNotSorted.get(2), ansNotSorted.get(3)));
                        }
                    }
                }
            }
        }
        return ans.stream().map(q -> Arrays.asList(q.a, q.b, q.c, q.d)).collect(Collectors.toList());
    }
}
