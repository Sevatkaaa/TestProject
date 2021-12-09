package leetcode.beststocktime122;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lastBuyValue = prices[0];
        int value = 0;
        for (int i = 1; i < prices.length; i++) {
            int curBuyValue = prices[i];
            if (curBuyValue > lastBuyValue) {
                value += curBuyValue - lastBuyValue;
                lastBuyValue = curBuyValue;
            } else {
                lastBuyValue = curBuyValue;
            }
        }
        return value;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{7,6,4,3,1};
        int ans = s.maxProfit(a);
        System.out.println(ans);
    }
}
