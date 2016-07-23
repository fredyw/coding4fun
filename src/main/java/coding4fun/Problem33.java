package coding4fun;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Create an alternating iterator from a list of iterators.
 *
 * <pre>
 * Input:
 * - Iterator 1: 0
 * - Iterator 2: 1, 2, 3
 * - Iterator 3: 4, 5
 * - Iterator 4: 6, 7, 8, 9
 * - Iterator 5: 10
 *
 * Output: 0 1 4 6 10 2 5 7 3 8 9
 * </pre>
 */
public class Problem33 {
    private static class AlternatingIterator implements Iterator<Integer> {
        private final LinkedList<Iterator<Integer>> iterators;
        private Iterator<Iterator<Integer>> iter;

        public AlternatingIterator(LinkedList<Iterator<Integer>> iterators) {
            this.iterators = iterators;
            iter = iterators.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterators.size() > 0;
        }

        @Override
        public Integer next() {
            if (!iter.hasNext() && iterators.size() > 0) {
                iter = iterators.iterator();
            }
            Iterator<Integer> it = iter.next();
            Integer val = it.next();
            if (!it.hasNext()) {
                iter.remove();
            }
            return val;
        }
    }

    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(0);
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        List<Integer> list3 = Arrays.asList(6, 7, 8, 9);
        List<Integer> list4 = Arrays.asList(10);

        LinkedList<Iterator<Integer>> list = new LinkedList<>();
        list.add(list0.iterator());
        list.add(list1.iterator());
        list.add(list2.iterator());
        list.add(list3.iterator());
        list.add(list4.iterator());
        AlternatingIterator iter = new AlternatingIterator(list);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
