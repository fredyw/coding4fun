package coding4fun;

/**
 * Given an array, find an algorithm to find the minimum element of a given range.
 * The minimum element of different ranges will be called multiple times over the same array.
 *
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
        private final int arrayLength;

        public SegmentTree(int[] array) {
            arrayLength = array.length;
        }

        private static void build() {
            // TODO:
        }

        public int minRange(int start, int end) {
            // TODO:
            return 0;
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
