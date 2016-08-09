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
 * </pre>
 */
public class Problem43 {
    private static int maxProductSubArray(int[] array) {
        int max = 1;
        int minProduct = 1;
        int maxProduct = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                minProduct = Math.min(minProduct * array[i], 1);
                maxProduct *= array[i];
            } else if (array[i] == 0) {
                minProduct = 1;
                maxProduct = 1;
            } else { // array[i] < 0
                int tmp = maxProduct;
                maxProduct = Math.max(minProduct * array[i], 1);
                minProduct = tmp * array[i];
            }
            max = Math.max(max, maxProduct);
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
    }
}
