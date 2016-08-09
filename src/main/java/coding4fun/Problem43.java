package coding4fun;

/**
 * Find the maximum product subarray.
 *
 * <pre>
 * Input: [-1, 2, -4, 3, -5]
 * Output: 120
 *
 * Input: [-1, 2, 3, -4]
 * Output: 24
 *
 * Input: [-3, -3]
 * Output: 9
 *
 * Input: [5, -4, 2, 3]
 * Output: 6
 *
 * Input: [1, -2, 3, -4, 5, -6]
 * Output: 360
 *
 * Input: [1, -2, -3, 0, 7, -8, -2]
 * Output: 112
 *
 * Input: []
 * Output: 0
 *
 * Input: [-1]
 * Output: -1
 *
 * Input: [0, 1, 2, -3, -4, 0]
 * Output: 24
 * </pre>
 */
public class Problem43 {
    private static int maxProductSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        int maxSoFar = array[0];
        // forward
        for (int i = 1; i < array.length; i++) {
            if (maxSoFar * array[i] == 0) {
                maxSoFar = array[i];
            } else {
                maxSoFar *= array[i];
            }
            max = Math.max(Math.max(maxSoFar, array[i]), max);
        }
        // backward
        maxSoFar = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (maxSoFar * array[i] == 0) {
                maxSoFar = array[i];
            } else {
                maxSoFar *= array[i];
            }
            max = Math.max(Math.max(maxSoFar, array[i]), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProductSubArray(new int[]{-1, 2, -4, 3, -5})); // 120
        System.out.println(maxProductSubArray(new int[]{-1, 2, 3, -4})); // 24
        System.out.println(maxProductSubArray(new int[]{-3, -3})); // 9
        System.out.println(maxProductSubArray(new int[]{5, -4, 2, 3})); // 6
        System.out.println(maxProductSubArray(new int[]{1, -2, 3, -4, 5, -6})); // 360
        System.out.println(maxProductSubArray(new int[]{1, -2, -3, 0, 7, -8, -2})); // 112
        System.out.println(maxProductSubArray(new int[]{})); // 0
        System.out.println(maxProductSubArray(new int[]{-1})); // -1
        System.out.println(maxProductSubArray(new int[]{0, 1, 2, -3, -4, 0})); // 24
    }
}
