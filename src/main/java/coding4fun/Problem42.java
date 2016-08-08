package coding4fun;

/**
 * Find the next permutation in lexicographical order.
 * <p>
 * <pre>
 * Input : 362541
 * Output: 364125
 *
 * Input : 123456
 * Output: 123465
 *
 * Input : 654321
 * Output: 123456
 * </pre>
 */
public class Problem42 {
    private static String nextPermutation(String str) {
        char[] chars = str.toCharArray();
        int i = chars.length - 1;
        outer:
        for (; i >= 1; i--) {
            // in increasing order
            if (chars[i - 1] < chars[i]) {
                for (int j = chars.length - 1; j != i - 1; j--) {
                    if (chars[j] > chars[i - 1]) {
                        swap(chars, j, i - 1);
                        break outer;
                    }
                }
            }
        }
        for (int j = i, k = chars.length - 1; j < k; j++, k--) {
            swap(chars, j, k);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation("362541")); // 364125
        System.out.println(nextPermutation("123456")); // 123465
        System.out.println(nextPermutation("654321")); // 123456
    }
}
