package coding4fun;

/**
 * Given an array, find an algorithm to find the sum of a given range. The sum of different
 * ranges will be called multiple times over the same array.
 *
 * <pre>
 * Input  : [1, 3, 5, 7, 9, 11]
 * Outputs: sumRange(1, 4) --> 24
 *         sumRange(1, 1) --> 3
 *         sumRange(0, 5) --> 36
 *         sumRange(0, 0) --> 1
 * </pre>
 */
public class Problem28 {
    public static class SegmentTree {
        private final int[] tree;
        private final int arrayLength;

        public SegmentTree(int[] array) {
            arrayLength = array.length;
            int x = (int) (Math.ceil(Math.log(array.length) / Math.log(2)));
            int maxSize = 2 * (int) Math.pow(2, x) - 1;
            tree = new int[maxSize];
            build(array, tree, 0, array.length - 1, 0);
        }

        private static int build(int[] array, int[] tree, int start, int end, int current) {
            if (start == end) {
                tree[current] = array[start];
                return tree[current];
            }
            int mid = (start + end) / 2;
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;
            int sumLeft = build(array, tree, start, mid, left);
            int sumRight = build(array, tree, mid + 1, end, right);
            tree[current] = sumLeft + sumRight;
            return tree[current];
        }

        public int sumRange(int start, int end) {
            return sumRange(start, end, tree, 0, arrayLength - 1, 0);
        }

        private static int sumRange(int queryStart, int queryEnd, int[] tree, int start,
                                    int end, int current) {
            if (queryStart <= start && queryEnd >= end) {
                return tree[current];
            }
            if (queryEnd < start ||  end < queryStart) {
                return 0;
            }
            int mid = (start + end) / 2;
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;
            int sumLeft = sumRange(queryStart, queryEnd, tree, start, mid, left);
            int sumRight = sumRange(queryStart, queryEnd, tree, mid + 1, end, right);
            return sumLeft + sumRight;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 11};
        SegmentTree tree = new SegmentTree(array);
        System.out.println(tree.sumRange(1, 4)); // 24
        System.out.println(tree.sumRange(1, 1)); // 3
        System.out.println(tree.sumRange(0, 5)); // 36
        System.out.println(tree.sumRange(0, 0)); // 0
    }
}
