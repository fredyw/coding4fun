package coding4fun;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given two 1d list, implement an iterator to return their elements alternately.
 * For example, given two 1d lists:
 * <p>
 * <pre>
 * list1 = [1, 2]
 * list2 = [3, 4, 5, 6]
 * </pre>
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned
 * by next should be: [1, 3, 2, 4, 5, 6].
 */
public class Problem26 {
    public static class ZigZagIterator implements Iterator<Integer> {
        private final Iterator<Integer> iter1;
        private final Iterator<Integer> iter2;
        private boolean first = true;

        public ZigZagIterator(List<Integer> list1, List<Integer> list2) {
            iter1 = list1.iterator();
            iter2 = list2.iterator();

            if (list1.isEmpty()) {
                first = false;
            }
        }

        @Override
        public boolean hasNext() {
            if (first) {
                return iter1.hasNext();
            }
            return iter2.hasNext();
        }

        @Override
        public Integer next() {
            if (first) {
                if (iter1.hasNext()) {
                    Integer elem = iter1.next();
                    if (iter2.hasNext()) {
                        first = !first;
                    }
                    return elem;
                }
            } else {
                if (iter2.hasNext()) {
                    Integer elem = iter2.next();
                    if (iter1.hasNext()) {
                        first = !first;
                    }
                    return elem;
                }
            }
            return null;
        }
    }

    private static void print(ZigZagIterator iter) {
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        ZigZagIterator iter = new ZigZagIterator(list1, list2);
        print(iter);

        iter = new ZigZagIterator(list2, list1);
        print(iter);

        list1 = Arrays.asList(1, 2, 3);
        list2 = Arrays.asList(4, 5, 6);

        iter = new ZigZagIterator(list1, list2);
        print(iter);

        iter = new ZigZagIterator(list2, list1);
        print(iter);

        list1 = Arrays.asList();
        list2 = Arrays.asList(4, 5, 6);

        iter = new ZigZagIterator(list1, list2);
        print(iter);

        iter = new ZigZagIterator(list2, list1);
        print(iter);
    }
}
