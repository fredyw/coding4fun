package coding4fun;

/**
 * Checks if string c is a combination of strings a and b.
 *
 * <pre>
 * Input:
 * a: abxm
 * b: hckd
 * c: ahcbxkmd
 * Output: true
 *
 * Input:
 * a: abc
 * b: aef
 * c: aeabcf
 * Output: true
 *
 * Input:
 * a: abc
 * b: aef
 * c: abacef
 * Output: true
 *
 * Input:
 * a: abc
 * b: aef
 * c: aeacbf
 * Output: false
 *
 * Input:
 * a: abc
 * b: aef
 * c: axeabcf
 * Output: false
 *
 * Input:
 * a: abc
 * b: aef
 * c: abc
 * Output: false
 *
 * Input:
 * a: aaabc
 * b: aaeaf
 * c: aaaaeaafbc
 * Output: true
 * </pre>
 */
public class Problem53 {
    private static boolean isCombination(String a, String b, String c) {
        return isCombination(a, b, c, "", 0, 0);
    }

    private static boolean isCombination(String a, String b, String c, String accu, int ai, int ci) {
        if (ai == a.length() || ci == c.length()) {
            return accu.equals(b);
        }
        boolean found = false;
        if (a.charAt(ai) == c.charAt(ci)) {
            found |= isCombination(a, b, c, accu + "", ai + 1, ci + 1);
            found |= isCombination(a, b, c, accu + "", ai, ci + 1);
        }
        found |= isCombination(a, b, c, accu + c.charAt(ci), ai, ci + 1);
        return found;
    }

    public static void main(String[] args) {
        System.out.println(isCombination("abxm", "hckd", "ahcbxkmd")); // true
        System.out.println(isCombination("abc", "aef", "aeabcf")); // true
        System.out.println(isCombination("abc", "aef", "abacef")); // true
        System.out.println(isCombination("abc", "aef", "aeacbf")); // false
        System.out.println(isCombination("abc", "aef", "axeabcf")); // false
        System.out.println(isCombination("abc", "aef", "abc")); // false
        System.out.println(isCombination("aaabc", "aaeaf", "aaaaeaafbc")); // true
    }
}
