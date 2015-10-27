package coding4fun;

import java.util.Arrays;

/**
 * Find the number of unique elements. Let's call this number k.
 * Now, rearrange the elements so that the first k elements are the unique ones.
 * The remaining elements after those k don't matter (the number of each element can change).
 * Then return k.
 *
 * The algorithm must be done in-place.
 *
 * <pre>
 * Input : [1, 1, 2, 3, 3, 4, 4]
 * Output: [2, 1, 1, 3, 3, 4], k = 1
 *
 * Input : [3, 2, 1, 5, 4]
 * Output: [1, 2, 3, 4, 5], k = 5
 *
 * Input : [3, 3, 1, 1, 2, 2]
 * Output: [3, 3, 1, 1, 2, 2], k = 0
 *
 * Input : [5, 3, 1, 1, 4, 5, 2]
 * Output: [2, 3, 4, 1, 1, 5, 5], k = 3
 * </pre>
 */
public class Problem23 {
    public static int findNumOfUniqueElements(int[] elements) {
        Arrays.sort(elements);
        int left = 0;
        int k = 0;
        int right = 0;
        for (; right < elements.length; right++) {
            if (elements[left] == elements[right]) {
                continue;
            }
            // a unique number
            if (right-left == 1) {
                swap(elements, left, k++);
            }
            left = right;
        }
        if (right-left == 1) {
            k++;
        }
        return k;
    }

    private static void swap(int[] elements, int i, int j) {
        int tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 3, 4, 4};
        System.out.println(findNumOfUniqueElements(array));
        System.out.println(Arrays.toString(array));

        array = new int[]{3, 2, 1, 5, 4};
        System.out.println(findNumOfUniqueElements(array));
        System.out.println(Arrays.toString(array));

        array = new int[]{3, 3, 1, 1, 2, 2};
        System.out.println(findNumOfUniqueElements(array));
        System.out.println(Arrays.toString(array));

        array = new int[]{5, 3, 1, 1, 4, 5, 2};
        System.out.println(findNumOfUniqueElements(array));
        System.out.println(Arrays.toString(array));
    }
}
