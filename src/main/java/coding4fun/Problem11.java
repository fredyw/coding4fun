package coding4fun;

import java.util.Arrays;

/**
 * Count the number of triples that sum to 0.
 * 
 * Input: [2, 8, -25, -3, 10, 4, -7, -10]
 * Output: [-10, 2, 8]
 */
public class Problem11 {
    private static int[] threeSum(int[] array) {
        int[] result = new int[3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int idx = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (idx >= 0) {
                    result[0] = array[i];
                    result[1] = array[j];
                    result[2] = array[idx];
                    return result;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{2, 8, -25, -3, 10, 4, -7, -10};
        Arrays.sort(array);
        int[] result = threeSum(array);
        System.out.println(Arrays.toString(result));
    }
}
