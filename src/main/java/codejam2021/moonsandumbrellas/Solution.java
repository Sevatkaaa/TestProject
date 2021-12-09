package codejam2021.moonsandumbrellas;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static int solve(Scanner in) {
        int x = in.nextInt();
        int y = in.nextInt();
        if (x > 0 && y > 0) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '?') {
                    sb.append(s.charAt(i));
                }
            }
            return countPay(sb.toString().trim(), x, y);
        }
        String s = in.nextLine().trim();
        int n = s.length();
        if (!s.contains("J") && !s.contains("C")) {
            if (n == 1) {
                return 0;
            }
            if (n % 2 == 0) {
                int xVal = (n / 2) * x + (n / 2 - 1) * y;
                int yVal = (n / 2 - 1) * x + (n / 2) * y;
                return Math.min(Math.min(x, y), Math.min(xVal, yVal));
            } else {
                int xVal = (n / 2) * x + (n / 2) * y;
                return Math.min(Math.min(x, y), xVal);
            }
        }
        int ans = 0;
        List<Integer> groups = new ArrayList<>();
        int lastGroup = -1;
        if (s.endsWith("?")) {
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) != '?') {
                    lastGroup = (i + 1) * n + n - 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) != '?') {
                        groups.add(i * n + j - 1);
                        i = j;
                        break;
                    }
                }
            }
        }
        if (lastGroup != -1) {
            groups.add(lastGroup);
        }
        if (groups.isEmpty()) {
            return countPay(s, x, y);
        }
        if (x < 0 && y < 0) {
            if (groups.get(0) < n) {
                int firstB = groups.get(0);
                if (s.charAt(firstB + 1) == 'J') {
                    if (firstB % 2 == 0) {
                        ans += x * (firstB / 2 + 1) + (firstB / 2) * y;
                    } else {
                        ans += x * (firstB / 2 + 1) + (firstB / 2 + 1) * y;
                    }
                } else {
                    if (firstB % 2 == 0) {
                        ans += x * (firstB / 2) + (firstB / 2 + 1) * y;
                    } else {
                        ans += x * (firstB / 2 + 1) + (firstB / 2 + 1) * y;
                    }
                }
                groups.remove(0);
                if (groups.isEmpty()) {
                    return ans + countPay(s.substring(firstB + 1), x, y);
                }
            }
            if (groups.get(groups.size() - 1) % n == n - 1) {
                int firstA = groups.get(groups.size() - 1) / n;
                int len = n - firstA;
                if (s.charAt(firstA - 1) == 'J') {
                    if (len % 2 == 0) {
                        ans += x * (len / 2) + (len / 2) * y;
                    } else {
                        ans += x * (len / 2) + (len / 2 + 1) * y;
                    }
                } else {
                    if (len % 2 == 0) {
                        ans += x * (len / 2 + 1) + (len / 2) * y;
                    } else {
                        ans += x * (len / 2 + 1) + (len / 2 + 1) * y;
                    }
                }
                groups.remove(groups.size() - 1);
                if (groups.isEmpty()) {
                    return ans + countPay(s.replaceAll("\\?", ""), x, y);
                }
            }
            for (int i = 0; i < groups.size(); i++) {
                ans += getGroupMinVal(groups.get(i), s, x, y);
            }
        } else if (x < 0 && y > 0) {
            if (groups.get(0) < n) {
                int firstB = groups.get(0);
                if (s.charAt(firstB + 1) == 'J') {
                    if (firstB % 2 == 0) {
                        ans += Math.min(x, x * (firstB / 2 + 1) + (firstB / 2) * y);
                    } else {
                        ans += Math.min(x, x * (firstB / 2 + 1) + (firstB / 2 + 1) * y);
                    }
                } else {
                    if (firstB % 2 == 0) {
                        ans += Math.min(0, x * (firstB / 2) + (firstB / 2 + 1) * y);
                    } else {
                        ans += Math.min(0, x * (firstB / 2 + 1) + (firstB / 2 + 1) * y);
                    }
                }
                groups.remove(0);
                if (groups.isEmpty()) {
                    return ans + countPay(s.substring(firstB + 1), x, y);
                }
            }
            if (groups.get(groups.size() - 1) % n == n - 1) {
                int firstA = groups.get(groups.size() - 1) / n;
                int len = n - firstA;
                if (s.charAt(firstA - 1) == 'J') {
                    if (len % 2 == 0) {
                        ans += Math.min(0, x * (len / 2) + (len / 2) * y);
                    } else {
                        ans += Math.min(0, x * (len / 2) + (len / 2 + 1) * y);
                    }
                } else {
                    if (len % 2 == 0) {
                        ans += Math.min(x, x * (len / 2 + 1) + (len / 2) * y);
                    } else {
                        ans += Math.min(x, x * (len / 2 + 1) + (len / 2 + 1) * y);
                    }
                }
                groups.remove(groups.size() - 1);
                if (groups.isEmpty()) {
                    return ans + countPay(s.replaceAll("\\?", ""), x, y);
                }
            }
            for (int i = 0; i < groups.size(); i++) {
                ans += countGroupMinusPay(s, groups.get(i), x, y);
            }
        } else {
            if (groups.get(0) < n) {
                int firstB = groups.get(0);
                if (s.charAt(firstB + 1) == 'J') {
                    if (firstB % 2 == 0) {
                        ans += Math.min(0, Math.min(x * (firstB / 2) + (firstB / 2) * y, x * (firstB / 2 + 1) + (firstB / 2) * y));
                    } else {
                        ans += Math.min(0, x * (firstB / 2 + 1) + (firstB / 2 + 1) * y);
                    }
                } else {
                    if (firstB % 2 == 0) {
                        ans += Math.min(y, x * (firstB / 2) + (firstB / 2 + 1) * y);
                    } else {
                        ans += Math.min(y, x * (firstB / 2 + 1) + (firstB / 2 + 1) * y);
                    }
                }
                groups.remove(0);
                if (groups.isEmpty()) {
                    return ans + countPay(s.substring(firstB + 1), x, y);
                }
            }
            if (groups.get(groups.size() - 1) % n == n - 1) {
                int firstA = groups.get(groups.size() - 1) / n;
                int len = n - firstA;
                if (s.charAt(firstA - 1) == 'J') {
                    if (len % 2 == 0) {
                        ans += Math.min(y, x * (len / 2) + (len / 2) * y);
                    } else {
                        ans += Math.min(y, x * (len / 2) + (len / 2 + 1) * y);
                    }
                } else {
                    if (len % 2 == 0) {
                        ans += Math.min(0, x * (len / 2) + (len / 2) * y);
                    } else {
                        ans += Math.min(0, x * (len / 2 + 1) + (len / 2) * y);
                    }
                }
                groups.remove(groups.size() - 1);
                if (groups.isEmpty()) {
                    return ans + countPay(s.replaceAll("\\?", ""), x, y);
                }
            }
            for (int i = 0; i < groups.size(); i++) {
                ans += countGroupMinusPay(s, groups.get(i), x, y);
            }
        }
        return ans;
    }

    private static int countGroupMinusPay(String s, Integer group, int x, int y) {
        int n = s.length();
        int firstA = group / n;
        int firstB = group % n;
        int len = firstB - firstA + 1;
        if (s.charAt(firstA - 1) == s.charAt(firstB + 1)) {
            return Math.min(Math.min(x, y), (len + 1) / 2 * (x + y));
        }
        if (s.charAt(firstA - 1) == 'C' && s.charAt(firstB + 1) == 'J') {
            return Math.min(Math.min(x, y), (len) / 2 * (x + y) + x);
        }
        return Math.min(Math.min(x, y), (len) / 2 * (x + y) + y);
    }

    private static int getGroupMinVal(Integer group, String s, int x, int y) {
        int n = s.length();
        int firstA = group / n;
        int firstB = group % n;
        int len = firstB - firstA + 1;
        if (s.charAt(firstA - 1) == s.charAt(firstB + 1)) {
            return (len + 1) / 2 * (x + y);
        }
        if (s.charAt(firstA - 1) == 'C' && s.charAt(firstB + 1) == 'J') {
            return (len) / 2 * (x + y) + x;
        }
        return (len) / 2 * (x + y) + y;
    }

    private static int countPay(String s, int x, int y) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (first == second) {
                continue;
            }
            if (first == 'C') {
                ans += x;
            } else {
                ans += y;
            }
        }
        return ans;
    }
}

