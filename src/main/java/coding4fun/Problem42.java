package coding4fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the next permutation in lexicographical order.
 *
 * <pre>
 * Input : 362541
 * Output: 364125
 * </pre>
 */
public class Problem42 {
    private static String nextPermutation(String str) {
        char[] chars = str.toCharArray();
        List<Character> reversed = new ArrayList<>();
        for (int i = chars.length - 1; i >= 1; i--) {
            // in increasing order
            if (chars[i + 1] < chars[i]) {
                for (int j = 0; j < reversed.size(); j++) {
                    // TODO:
                }
            } else {
                reversed.add(chars[i]);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation("362541"));
    }
}
