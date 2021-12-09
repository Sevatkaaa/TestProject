package codejam2021.round1a.primetime;

import java.util.*;
import java.io.*;
public class OldSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static long solve(Scanner in) {
        int m = in.nextInt();
        List<Integer> nums = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int cur = in.nextInt();
            int count = in.nextInt();
            sum += cur * count;
            for (int j = 0; j < count; j++) {
                nums.add(cur);
            }
        }
        long ans = 0;
        // 1
        int s = nums.size();
        for (int i = 0; i < s; i++) {
            int cur = nums.get(i);
            if (sum - cur == cur && ans < cur) {
                ans = cur;
            }
        }
        // 2
        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                int cur1 = nums.get(i);
                int cur2 = nums.get(j);
                if (sum - cur1 - cur2 == cur1 * cur2 && ans < cur1 * cur2) {
                    ans = cur1 * cur2;
                }
            }
        }
        // 3
        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    int cur1 = nums.get(i);
                    int cur2 = nums.get(j);
                    int cur3 = nums.get(k);
                    long val = (long)cur1 * cur2 * cur3;
                    if (sum - cur1 - cur2 - cur3 == val && ans < val) {
                        ans = val;
                    }
                }
            }
        }
        // 4
        l4: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        int cur1 = nums.get(i);
                        int cur2 = nums.get(j);
                        int cur3 = nums.get(k);
                        int cur4 = nums.get(l);
                        long val = (long)cur1 * cur2 * cur3 * cur4;
                        if (val > sum - cur1 - cur2 - cur3 - cur4) {
                            break l4;
                        }
                        if (sum - cur1 - cur2 - cur3 - cur4 == val && ans < val) {
                            ans = val;
                        }
                    }
                }
            }
        }
        // 5
        l5: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            int cur1 = nums.get(i);
                            int cur2 = nums.get(j);
                            int cur3 = nums.get(k);
                            int cur4 = nums.get(l);
                            int cur5 = nums.get(n);
                            long val = (long)cur1 * cur2 * cur3 * cur4 * cur5;
                            if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5) {
                                break l5;
                            }
                            if (sum - cur1 - cur2 - cur3 - cur4 - cur5 == val && ans < val) {
                                ans = val;
                            }
                        }
                    }
                }
            }
        }
        // 6
        l6: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                int cur1 = nums.get(i);
                                int cur2 = nums.get(j);
                                int cur3 = nums.get(k);
                                int cur4 = nums.get(l);
                                int cur5 = nums.get(n);
                                int cur6 = nums.get(o);
                                long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6;
                                if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6) {
                                    break l6;
                                }
                                if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 == val && ans < val) {
                                    ans = val;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 7
        l7: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    int cur1 = nums.get(i);
                                    int cur2 = nums.get(j);
                                    int cur3 = nums.get(k);
                                    int cur4 = nums.get(l);
                                    int cur5 = nums.get(n);
                                    int cur6 = nums.get(o);
                                    int cur7 = nums.get(p);
                                    long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7;
                                    if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7) {
                                        break l7;
                                    }
                                    if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 == val && ans < val) {
                                        ans = val;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 8
        l8: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        int cur1 = nums.get(i);
                                        int cur2 = nums.get(j);
                                        int cur3 = nums.get(k);
                                        int cur4 = nums.get(l);
                                        int cur5 = nums.get(n);
                                        int cur6 = nums.get(o);
                                        int cur7 = nums.get(p);
                                        int cur8 = nums.get(q);
                                        long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8;
                                        if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8) {
                                            break l8;
                                        }
                                        if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 == val && ans < val) {
                                            ans = val;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 9
        l9: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            int cur1 = nums.get(i);
                                            int cur2 = nums.get(j);
                                            int cur3 = nums.get(k);
                                            int cur4 = nums.get(l);
                                            int cur5 = nums.get(n);
                                            int cur6 = nums.get(o);
                                            int cur7 = nums.get(p);
                                            int cur8 = nums.get(q);
                                            int cur9 = nums.get(r);
                                            long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9;
                                            if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9) {
                                                break l9;
                                            }
                                            if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 == val && ans < val) {
                                                ans = val;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 10
        l10: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                int cur1 = nums.get(i);
                                                int cur2 = nums.get(j);
                                                int cur3 = nums.get(k);
                                                int cur4 = nums.get(l);
                                                int cur5 = nums.get(n);
                                                int cur6 = nums.get(o);
                                                int cur7 = nums.get(p);
                                                int cur8 = nums.get(q);
                                                int cur9 = nums.get(r);
                                                int cur10 = nums.get(t);
                                                long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10;
                                                if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10) {
                                                    break l10;
                                                }
                                                if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 == val && ans < val) {
                                                    ans = val;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 11
        l11: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                for (int u = t + 1; u < s; u++) {
                                                    int cur1 = nums.get(i);
                                                    int cur2 = nums.get(j);
                                                    int cur3 = nums.get(k);
                                                    int cur4 = nums.get(l);
                                                    int cur5 = nums.get(n);
                                                    int cur6 = nums.get(o);
                                                    int cur7 = nums.get(p);
                                                    int cur8 = nums.get(q);
                                                    int cur9 = nums.get(r);
                                                    int cur10 = nums.get(t);
                                                    int cur11 = nums.get(u);
                                                    long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10 * cur11;
                                                    if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11) {
                                                        break l11;
                                                    }
                                                    if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 == val && ans < val) {
                                                        ans = val;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 12
        l12: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                for (int u = t + 1; u < s; u++) {
                                                    for (int v = u + 1; v < s; v++) {
                                                        int cur1 = nums.get(i);
                                                        int cur2 = nums.get(j);
                                                        int cur3 = nums.get(k);
                                                        int cur4 = nums.get(l);
                                                        int cur5 = nums.get(n);
                                                        int cur6 = nums.get(o);
                                                        int cur7 = nums.get(p);
                                                        int cur8 = nums.get(q);
                                                        int cur9 = nums.get(r);
                                                        int cur10 = nums.get(t);
                                                        int cur11 = nums.get(u);
                                                        int cur12 = nums.get(v);
                                                        long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10 * cur11 * cur12;
                                                        if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12) {
                                                            break l12;
                                                        }
                                                        if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 == val && ans < val) {
                                                            ans = val;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 13
        l13: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                for (int u = t + 1; u < s; u++) {
                                                    for (int v = u + 1; v < s; v++) {
                                                        for (int w = v + 1; w < s; w++) {
                                                            int cur1 = nums.get(i);
                                                            int cur2 = nums.get(j);
                                                            int cur3 = nums.get(k);
                                                            int cur4 = nums.get(l);
                                                            int cur5 = nums.get(n);
                                                            int cur6 = nums.get(o);
                                                            int cur7 = nums.get(p);
                                                            int cur8 = nums.get(q);
                                                            int cur9 = nums.get(r);
                                                            int cur10 = nums.get(t);
                                                            int cur11 = nums.get(u);
                                                            int cur12 = nums.get(v);
                                                            int cur13 = nums.get(w);
                                                            long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10 * cur11 * cur12 * cur13;
                                                            if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13) {
                                                                break l13;
                                                            }
                                                            if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13 == val && ans < val) {
                                                                ans = val;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 14
        l14: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                for (int u = t + 1; u < s; u++) {
                                                    for (int v = u + 1; v < s; v++) {
                                                        for (int w = v + 1; w < s; w++) {
                                                            for (int x = w + 1; x < s; x++) {
                                                                int cur1 = nums.get(i);
                                                                int cur2 = nums.get(j);
                                                                int cur3 = nums.get(k);
                                                                int cur4 = nums.get(l);
                                                                int cur5 = nums.get(n);
                                                                int cur6 = nums.get(o);
                                                                int cur7 = nums.get(p);
                                                                int cur8 = nums.get(q);
                                                                int cur9 = nums.get(r);
                                                                int cur10 = nums.get(t);
                                                                int cur11 = nums.get(u);
                                                                int cur12 = nums.get(v);
                                                                int cur13 = nums.get(w);
                                                                int cur14 = nums.get(x);
                                                                long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10 * cur11 * cur12 * cur13 * cur14;
                                                                if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13 - cur14) {
                                                                    break l14;
                                                                }
                                                                if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13 - cur14 == val && ans < val) {
                                                                    ans = val;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 15
        l15: for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int k = j + 1; k < s; k++) {
                    for (int l = k + 1; l < s; l++) {
                        for (int n = l + 1; n < s; n++) {
                            for (int o = n + 1; o < s; o++) {
                                for (int p = o + 1; p < s; p++) {
                                    for (int q = p + 1; q < s; q++) {
                                        for (int r = q + 1; r < s; r++) {
                                            for (int t = r + 1; t < s; t++) {
                                                for (int u = t + 1; u < s; u++) {
                                                    for (int v = u + 1; v < s; v++) {
                                                        for (int w = v + 1; w < s; w++) {
                                                            for (int x = w + 1; x < s; x++) {
                                                                for (int y = x + 1; y < s; y++) {
                                                                    int cur1 = nums.get(i);
                                                                    int cur2 = nums.get(j);
                                                                    int cur3 = nums.get(k);
                                                                    int cur4 = nums.get(l);
                                                                    int cur5 = nums.get(n);
                                                                    int cur6 = nums.get(o);
                                                                    int cur7 = nums.get(p);
                                                                    int cur8 = nums.get(q);
                                                                    int cur9 = nums.get(r);
                                                                    int cur10 = nums.get(t);
                                                                    int cur11 = nums.get(u);
                                                                    int cur12 = nums.get(v);
                                                                    int cur13 = nums.get(w);
                                                                    int cur14 = nums.get(x);
                                                                    int cur15 = nums.get(y);
                                                                    long val = (long)cur1 * cur2 * cur3 * cur4 * cur5 * cur6 * cur7 * cur8 * cur9 * cur10 * cur11 * cur12 * cur13 * cur14 * cur15;
                                                                    if (val > sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13 - cur14 - cur15) {
                                                                        break l15;
                                                                    }
                                                                    if (sum - cur1 - cur2 - cur3 - cur4 - cur5 - cur6 - cur7 - cur8 - cur9 - cur10 - cur11 - cur12 - cur13 - cur14 - cur15 == val && ans < val) {
                                                                        ans = val;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
