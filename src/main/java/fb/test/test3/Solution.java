package fb.test.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    int numberOfWays(int[] arr, int k) {
        Map<Integer, List<Integer>> numbers = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numbers.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = k - x;
            List<Integer> indices = numbers.get(y);
            if (indices != null && !indices.isEmpty()) {
                ans += indices.size();
                if (x == y) {
                    ans--;
                }
            }
        }
        return ans / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.numberOfWays(new int[]{1, 1, 3}, 2);
        System.out.println(ans);
    }
}
