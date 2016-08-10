package coding4fun;

/**
 * Find the maximum product of elements in the array.
 *
 * <pre>
 * Input: [-1, -2, -3]
 * Output: 6
 *
 * Input: [-1, -2, -3, -4]
 * Output: 24
 *
 * Input: [-1, -2, 0, -4]
 * Output: 8
 *
 * Input: [-1]
 * Output: -1
 *
 * Input: [1, 2, -4, 6, 7, -3, 2, -5]
 * Output: 3360
 * </pre>
 */
public class Problem44 {
    private static int maxProduct(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int negativeCount = 0;
        int largestNegative = 0;
        int max = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            if (array[i] < 0) {
                negativeCount++;
                if (largestNegative == 0) {
                    largestNegative = array[i];
                } else {
                    largestNegative = Math.max(array[i], largestNegative);
                }
            }
            max *= array[i];
        }
        if (negativeCount % 2 != 0) {
            max /= largestNegative;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-1, -2, -3})); // 6
        System.out.println(maxProduct(new int[]{-1, -2, -3, -4})); // 24
        System.out.println(maxProduct(new int[]{-1, -2, 0, -4})); // 8
        System.out.println(maxProduct(new int[]{-1})); // -1
        System.out.println(maxProduct(new int[]{1, 2, -4, 6, 7, -3, 2, -5})); // 3360
    }
}
