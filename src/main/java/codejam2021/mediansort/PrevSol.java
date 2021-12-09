package codejam2021.mediansort;

import java.util.*;
import java.io.*;

public class PrevSol {

    static File file = new File("/Users/sov/Desktop/Sov/projects/src/main/java/codejam2021/mediansort/ans.txt");
    static BufferedWriter w;

    static {
        try {
            w = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int questions = 0;
    private static int max_q = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        max_q = q;
        for (int ipo = 0; ipo < t; ipo++) {
            boolean ttt = solve(n, in);
            try {
                w.write("\n\n");
                w.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!ttt) {
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        try {
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean solve(int n, Scanner in) {
        Map<Integer, Set<Integer>> lowerThan = new HashMap<>();
        Map<Integer, Set<Integer>> higherThan = new HashMap<>();
        Set<Integer> otherNumbers = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            otherNumbers.add(i + 1);
            lowerThan.put(i + 1, new HashSet<>());
            higherThan.put(i + 1, new HashSet<>());
        }
        ask(1, 2, 3);
        int median123 = in.nextInt();
        int minVal;
        int maxVal;
        if (median123 == 2) {
            minVal = 1;
            maxVal = 3;
            Set<Integer> lower1 = lowerThan.get(1);
            lower1.add(2);
            lower1.add(3);
            Set<Integer> lower2 = lowerThan.get(2);
            lower2.add(3);
            Set<Integer> higher2 = higherThan.get(2);
            higher2.add(1);
            Set<Integer> higher3 = higherThan.get(3);
            higher3.add(1);
            higher3.add(2);
        } else if (median123 == 1) {
            minVal = 2;
            maxVal = 3;
            Set<Integer> lower2 = lowerThan.get(2);
            lower2.add(1);
            lower2.add(3);
            Set<Integer> lower1 = lowerThan.get(1);
            lower1.add(3);
            Set<Integer> higher1 = higherThan.get(1);
            higher1.add(2);
            Set<Integer> higher3 = higherThan.get(3);
            higher3.add(1);
            higher3.add(2);
        } else {
            minVal = 1;
            maxVal = 2;
            Set<Integer> lower2 = lowerThan.get(1);
            lower2.add(2);
            lower2.add(3);
            Set<Integer> lower3 = lowerThan.get(3);
            lower3.add(2);
            Set<Integer> higher3 = higherThan.get(3);
            higher3.add(1);
            Set<Integer> higher1 = higherThan.get(2);
            higher1.add(1);
            higher1.add(3);
        }
        for (int i = 4; i <= n; i++) {
            ask(minVal, maxVal, i);
            if (questions == max_q) {
                return false;
            }
            int[] lambdaI = new int[]{i};
            int medianWithI = in.nextInt();
            if (medianWithI == minVal) {
                higherThan.get(minVal).add(i);
                higherThan.get(maxVal).add(i);
                Set<Integer> iLower = lowerThan.get(i);
                iLower.add(minVal);
                iLower.add(maxVal);
                Set<Integer> minValLowerThan = lowerThan.get(minVal);
                iLower.addAll(minValLowerThan);
                minValLowerThan.forEach(t -> higherThan.get(t).add(lambdaI[0]));
                Set<Integer> maxValLowerThan = lowerThan.get(maxVal);
                iLower.addAll(maxValLowerThan);
                maxValLowerThan.forEach(t -> higherThan.get(t).add(lambdaI[0]));
                minVal = i;
            } else if (medianWithI == maxVal) {
                lowerThan.get(minVal).add(i);
                lowerThan.get(maxVal).add(i);
                Set<Integer> iHigher = higherThan.get(i);
                iHigher.add(minVal);
                iHigher.add(maxVal);
                Set<Integer> maxValHigherThan = higherThan.get(maxVal);
                Set<Integer> minValHigherThan = higherThan.get(minVal);
                iHigher.addAll(maxValHigherThan);
                iHigher.addAll(minValHigherThan);
                maxValHigherThan.forEach(val -> lowerThan.get(val).add(lambdaI[0]));
                minValHigherThan.forEach(val -> lowerThan.get(val).add(lambdaI[0]));
                maxVal = i;
            } else {
                lowerThan.get(minVal).add(i);
                lowerThan.get(i).add(maxVal);
                higherThan.get(i).add(minVal);
                higherThan.get(maxVal).add(i);
            }
        }
        otherNumbers.remove(minVal);
        otherNumbers.remove(maxVal);
        List<Integer> minValues = new ArrayList<>();
        List<Integer> maxValues = new ArrayList<>();
        minValues.add(minVal);
        maxValues.add(maxVal);
        int newN = n - 2;
//        boolean doThis = true;
//        if (doThis) {
//            List<Integer> kekOther = new ArrayList<>(otherNumbers);
//            for (int i = 0; 1 < kekOther.size();) {
//                Integer v1 = kekOther.get(i);
//                Integer v2 = kekOther.get(i + 1);
//                if (higherThan.get(v1).contains(v2) || lowerThan.get(v1).contains(v2)) {
//                    if (i + 2 < kekOther.size()) {
//                        v2 = kekOther.get(i + 2);
//                    }
//                }
//                ask(minValues.get(0), v1, v2);
//                if (questions == max_q) {
//                    return false;
//                }
//                int checkMedian = in.nextInt();
//                if (checkMedian == v1) {
//                    Set<Integer> v2HigherThan = higherThan.get(v2);
//                    v2HigherThan.add(v1);
//                    v2HigherThan.addAll(higherThan.get(v1));
//                    Set<Integer> v1LowerThan = lowerThan.get(v1);
//                    v1LowerThan.add(v2);
//                    v1LowerThan.addAll(lowerThan.get(v2));
//                } else {
//                    Set<Integer> v1HigherThan = higherThan.get(v1);
//                    v1HigherThan.add(v2);
//                    v1HigherThan.addAll(higherThan.get(v2));
//                    Set<Integer> v2LowerThan = lowerThan.get(v2);
//                    v2LowerThan.add(v1);
//                    v2LowerThan.addAll(lowerThan.get(v1));
//                }
//                kekOther.remove(v1);
//                kekOther.remove(v2);
//            }
//            doThis = false;
//        }
        while (newN > 1) {
            if (otherNumbers.size() == 1) {
                break;
            }
            maxVal = otherNumbers.stream().filter(k -> higherThan.get(k).size() < n - maxValues.size()).sorted((o1, o2) -> higherThan.get(o2).size() - higherThan.get(o1).size()).findFirst().orElseThrow(IllegalArgumentException::new);
            Set<Integer> maxValHigherThan = higherThan.get(maxVal);
            if (maxValHigherThan.size() == n - maxValues.size() - 1) {
                maxValues.add(0, maxVal);
                newN--;
                otherNumbers.remove(maxVal);
                continue;
            }
            List<Integer> newON = new ArrayList<>(otherNumbers);
            newON.remove(new Integer(maxVal));
            newON.removeAll(higherThan.get(maxVal));
            newON.removeAll(lowerThan.get(maxVal));
            while (!newON.isEmpty()) {
                Integer askNewOn = newON.get(0);
                ask(minValues.get(0), askNewOn, maxVal);
                if (questions == max_q) {
                    return false;
                }
                int medianAskNewOn = in.nextInt();
                if (medianAskNewOn != askNewOn) {
                    int temp = askNewOn;
                    maxVal = askNewOn;
                    askNewOn = temp;
                }
                newON.remove(new Integer(askNewOn));
                Set<Integer> lowerThanAsk = lowerThan.get(askNewOn);
                Queue<Integer> q = new LinkedList<>();
                q.add(maxVal);
                while (!q.isEmpty()) {
                    Integer now = q.poll();
                    Set<Integer> lowerC = lowerThan.get(now);
                    q.addAll(lowerC);
                    lowerThanAsk.addAll(lowerC);
                    int[] lowerThanAskL = new int[]{askNewOn};
                    lowerC.forEach(lc -> higherThan.get(lc).add(lowerThanAskL[0]));
                }
            }
        }
        minValues.addAll(otherNumbers);
        minValues.addAll(maxValues);
        printAnswer(minValues);
        int result = in.nextInt();
        return result == 1;
    }

    private static void printAnswer(List<Integer> ans) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
        System.out.flush();
    }

    private static void ask(int a, int b, int c) {
        try {
            w.write(a + " " + b + " " + c + "\n");
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        questions++;
        System.out.println(a + " " + b + " " + c);
        System.out.flush();
    }
}
