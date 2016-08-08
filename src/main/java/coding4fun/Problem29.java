package coding4fun;

/**
 * Given an array, find an algorithm to find the minimum element of a given range.
 * The minimum element of different ranges will be called multiple times over the same array.
 * <p>
 * <pre>
 * Input  : [3, 1, 4, 6, 2, 7]
 * Outputs: minRange(1, 4) --> 1
 *          minRange(1, 1) --> 1
 *          minRange(0, 5) --> 1
 *          minRange(0, 0) --> 3
 *          minRange(3, 5) --> 2
 * </pre>
 */
public class Problem29 {
    public static class SegmentTree {
        private final int[] tree;
        private final int arrayLength;

        public SegmentTree(int[] array) {
            arrayLength = array.length;
            int x = (int) (Math.ceil(Math.log(array.length) / Math.log(2)));
            int maxSize = 2 * (int) (Math.pow(2, x)) - 1;
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
            int minLeft = build(array, tree, start, mid, left);
            int minRight = build(array, tree, mid + 1, end, right);
            tree[current] = Math.min(minLeft, minRight);
            return tree[current];
        }

        public int minRange(int start, int end) {
            return minRange(start, end, tree, 0, arrayLength - 1, 0);
        }

        private int minRange(int queryStart, int queryEnd, int[] tree, int start,
                             int end, int current) {
            if (queryStart <= start && queryEnd >= end) {
                return tree[current];
            }
            if (queryEnd < start || end < queryStart) {
                return Integer.MAX_VALUE;
            }
            int mid = (start + end) / 2;
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;
            int minLeft = minRange(queryStart, queryEnd, tree, start, mid, left);
            int minRight = minRange(queryStart, queryEnd, tree, mid + 1, end, right);
            return Math.min(minLeft, minRight);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 4, 6, 2, 7};
        SegmentTree tree = new SegmentTree(array);
        System.out.println(tree.minRange(1, 4)); // 1
        System.out.println(tree.minRange(1, 1)); // 1
        System.out.println(tree.minRange(0, 5)); // 1
        System.out.println(tree.minRange(0, 0)); // 3
        System.out.println(tree.minRange(3, 5)); // 2
    }
}
