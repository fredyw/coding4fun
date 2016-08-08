package coding4fun;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implement an iterator where all elements are greater than k.
 * <p>
 * <pre>
 * Input: array = [1, 2, 5, 6, 7, 3, 4]
 *        k = 3
 * Output: 6 7
 *
 * Input: array = [1, 2, 3, 4, 5]
 *        k = 1
 * Output: 2 3 4 5
 *
 * Input: array = [1, 2, 3, 4, 5]
 *        k = 10
 * Output:
 *
 * Input: array = [5, 4, 3, 2, 1]
 *        k = 4
 * Output: 5
 *
 * Input: array: [1, 2, 3, 4, 5]
 *        k = 4
 * Output: 1 2 3 4 5
 * </pre>
 */
public class Problem34 {
    private static class GreaterThanIterator implements Iterator<Integer> {
        private final Iterator<Integer> iter;
        private final int k;
        private Integer next;

        private GreaterThanIterator(List<Integer> list, int k) {
            iter = list.iterator();
            this.k = k;
            next = iter.next();
            while (next <= k && iter.hasNext()) {
                next = iter.next();
            }
            if (!iter.hasNext()) {
                next = null;
            }
        }

        @Override
        public boolean hasNext() {
            return (next == null || next <= k) ? false : true;
        }

        @Override
        public Integer next() {
            if (next == null || next <= k) {
                throw new NoSuchElementException();
            }
            Integer current = next;
            if (iter.hasNext()) {
                next = iter.next();
                while (next <= k && iter.hasNext()) {
                    next = iter.next();
                }
            } else {
                next = null;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        GreaterThanIterator iter = new GreaterThanIterator(Arrays.asList(1, 2, 5, 6, 7, 3, 4), 5);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        iter = new GreaterThanIterator(Arrays.asList(1, 2, 3, 4, 5), 1);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        iter = new GreaterThanIterator(Arrays.asList(1, 2, 3, 4, 5), 10);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        iter = new GreaterThanIterator(Arrays.asList(5, 4, 3, 2, 1), 4);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        iter = new GreaterThanIterator(Arrays.asList(1, 2, 3, 4, 5), 0);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
