package coding4fun;

/**
 * Implement a function to determine if a given string is a palindrome.
 * <p>
 * <pre>
 * Input: AABBCCBBAA
 * Output: true
 *
 * Input: AABCBAA
 * Output: true
 *
 * Input: AABBCDBBAA
 * Output: false
 * </pre>
 */
public class Problem3 {
    private static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("AABBCCBBAA"));
        System.out.println(isPalindrome("AABCBAA"));
        System.out.println(isPalindrome("AABBCDBBAA"));
    }
}
