package fb.test.test4;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static float BILLION = 1_000_000_000f;

    int getBillionUsersDay(float[] growthRates) {
        int days = 0;
        int n = growthRates.length;
        List<List<Float>> pows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Float> nums = new ArrayList<>();
            nums.add(1f);
            pows.add(nums);
        }
        float sum = n;
        while (sum < BILLION) {
            for (int i = 0; i < n; i++) {
                List<Float> nums = pows.get(i);
                for (int j = 0; j < 10; j++) {
                    nums.add(nums.get(nums.size() - 1) * growthRates[i]);
                }
            }
            days += 10;
            sum = pows.stream().map(p -> p.get(p.size() - 1)).reduce(Float::sum).get();
        }
        return findDays(pows, days);
    }

    private int findDays(List<List<Float>> pows, int days) {
        for (int i = 0; i < 9; i++) {
            int curDays = days - 9 + i;
            float sum = pows.stream().map(p -> p.get(curDays)).reduce(Float::sum).get();
            if (sum > BILLION) {
                return curDays;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.getBillionUsersDay(new float[]{1.1f, 1.2f, 1.3f});
        System.out.println(ans);
    }
}
