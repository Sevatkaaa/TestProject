package labs.sort;

import java.util.Comparator;
import java.util.List;

public class LibrarySort<T> {

    private int gap;
    private Comparator<T> comparator;

    public LibrarySort(int gap, Comparator<T> comparator) throws IllegalArgumentException {
        this.comparator = comparator;

        if (gap <= 0)
            throw new IllegalArgumentException("The gap should be at least 1");
        else
            this.gap = gap + 1;
    }

    public void sort(List<T> sequence) {
        if (sequence.size() <= 1) return;
        T[] gapped = (T[]) new Object[gap];
        gapped[0] = sequence.get(0);
        for (int i = 1; i < gapped.length; i++)
            gapped[i] = null;

        gapped = startSorting(sequence, gapped);

        for (int i = 0, j = 0; i < sequence.size(); j++)
            if (gapped[j] != null) {
                sequence.remove(i);
                sequence.add(i++, gapped[j]);
            }
    }

    private T[] startSorting(List<T> sequence, T[] gapped) {
        for (int pos = 1, goal = 1; pos < sequence.size(); goal *= 2) {
            for (int i = 0; i < goal; i++) {
                int insPos = binarySearch(gapped, sequence.get(pos));
                insPos++;
                if (insPos == gapped.length) {
                    insPos--;
                    int free = insPos - 1;
                    while (gapped[free] != null)
                        free--;
                    for (; free < insPos; free++)
                        gapped[free] = gapped[free + 1];
                } else if (gapped[insPos] != null) {
                    int free = insPos + 1;
                    while (free < gapped.length && gapped[free] != null)
                        free++;
                    if (free == gapped.length) {
                        insPos--;
                        free = insPos - 1;
                        while (gapped[free] != null)
                            free--;
                        for (; free < insPos; free++)
                            gapped[free] = gapped[free + 1];
                    } else
                        for (; free > insPos; free--)
                            gapped[free] = gapped[free - 1];
                }
                gapped[insPos] = sequence.get(pos++);
                if (pos >= sequence.size()) return gapped;
            }
            gapped = rebalance(gapped, sequence);
        }
        return gapped;
    }

    private int binarySearch(T[] gapped, T elem) {

        int left = 0;
        int mid;
        int right = gapped.length - 1;

        while (gapped[right] == null)
            right--;
        while (gapped[left] == null)
            left++;

        while (left <= right) {

            mid = (left + right) / 2;

            if (gapped[mid] == null) {

                int tmp = mid + 1;

                while (tmp < right && gapped[tmp] == null)
                    tmp++;

                if (gapped[tmp] == null || comparator.compare(gapped[tmp], elem) > 0) {

                    while (mid >= left && gapped[mid] == null)
                        mid--;

                    if (comparator.compare(gapped[mid], elem) < 0)
                        return mid;

                    right = mid - 1;
                } else
                    left = tmp + 1;
            } else if (comparator.compare(gapped[mid], elem) < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        while (right >= 0 && gapped[right] == null)
            right--;

        return right;
    }

    private T[] rebalance(T[] gapped, List<T> sequence) {
        T[] rebalanced = (T[]) new Object[Math.min(2 * gapped.length, gap * sequence.size())];
        int eps = gap - 1;
        for (int i = gapped.length - 1, j = rebalanced.length - 1; i >= 0; i--)
            if (gapped[i] != null) {
                rebalanced[j--] = gapped[i];
                for (int k = 0; k < eps; k++)
                    rebalanced[j--] = null;
            }
        return rebalanced;
    }

}
