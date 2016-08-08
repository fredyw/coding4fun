package coding4fun;

/**
 * List all permutations of a given string.
 * <p>
 * <pre>
 * Input : ABC
 * Output:
 * ABC
 * ACB
 * BAC
 * BCA
 * CBA
 * CAB
 * </pre>
 */
public class Problem32 {
    private static void permutation(String str) {
        char[] chars = str.toCharArray();
        permutation(chars, 0, chars.length);
    }

    private static void permutation(char[] chars, int left, int right) {
        if (left == right) {
            System.out.println(new String(chars));
            return;
        }
        for (int i = left; i < right; i++) {
            char tmp = chars[left];
            ;
            chars[left] = chars[i];
            chars[i] = tmp;
            permutation(chars, left + 1, right);
            // backtrack to revert the original list
            tmp = chars[left];
            ;
            chars[left] = chars[i];
            chars[i] = tmp;
        }
    }

    public static void main(String[] args) {
        permutation("ABC");
    }
}
