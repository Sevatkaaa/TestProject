package codejam2021.round1a.primetime;

import java.util.*;
import java.io.*;

public class Solution {

    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 2; i < 500; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long solve(Scanner in) {
        int m = in.nextInt();
        Map<Integer, Integer> vals = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int cur = in.nextInt();
            int count = in.nextInt();
            sum += cur * count;
            vals.put(cur, count);
        }
        for (int i = sum - 2; i > 1; i--) {
            if (isAns(i, vals, sum)) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isAns(int n, Map<Integer, Integer> vals, int sum) {
        Map<Integer, Integer> f = factorize(n);
        if (f == null) {
            return false;
        }
        int newSum = sum;
        Set<Integer> keys = f.keySet();
        for (Integer key : keys) {
            if (vals.get(key) == null || vals.get(key) < f.get(key)) {
                return false;
            }
            newSum -= f.get(key) * key;
        }
        return newSum == n;
    }

    private static Map<Integer, Integer> factorize(int n) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < primes.size(); i++) {
            int p = primes.get(i);
            if (n % p == 0) {
                int count = 0;
                while (n % p == 0) {
                    count++;
                    n = n / p;
                }
                ans.put(p, count);
            }
        }
        if (n != 1) {
            return null;
        }
        return ans;
    }
}
