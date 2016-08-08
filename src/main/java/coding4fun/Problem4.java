package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays A and B, find which elements that are not present in the A.
 * <p>
 * <pre>
 * Input: [1, 2, 5, 10], [4, 2, 5, 9, 10, 3]
 * Output: [4, 9, 3]
 * </pre>
 */
public class Problem4 {
    private static List<Integer> notIn(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < b.length; i++) {
            int idx = Arrays.binarySearch(a, b[i]);
            if (idx < 0) {
                result.add(b[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(notIn(new int[]{1, 2, 5, 10}, new int[]{4, 2, 5, 9, 10, 3}));
    }
}
