package coding4fun;

import java.util.TreeSet;

/**
 * Find the maximum difference of two elements in an array, such that
 * array[i] - array[j] is maximum where i < j.
 *
 * <pre>
 * Input : [4, 1, 2, 3]
 * Output: 2
 *
 * Input:  [2, 3, 10, 2, 4, 8, 1]
 * Output: 8
 *
 * Input:  [1, 3, 10, 2, 4, 8, 100]
 * Output: 99
 *
 * Input:  [7, 9, 5, 6, 3, 2]
 * Output: 2
 *
 * Input:  [1, 2, 3, 4, 5]
 * Output: 4
 *
 * Input:  [5, 4, 3, 2, 1]
 * Output: -1
 * </pre>
 */
public class Problem45 {
    private static int maxDiff(int[] array) {
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (set.size() > 0) {
                int smallest = set.first();
                min = Math.max(min, array[i] - smallest);
            }
            set.add(array[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{4, 1, 2, 3})); // 2
        System.out.println(maxDiff(new int[]{2, 3, 10, 2, 4, 8, 1})); // 8
        System.out.println(maxDiff(new int[]{1, 3, 10, 2, 4, 8, 100})); // 99
        System.out.println(maxDiff(new int[]{7, 9, 5, 6, 3, 2})); // 2
        System.out.println(maxDiff(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(maxDiff(new int[]{5, 4, 3, 2, 1})); // -1
    }
}
