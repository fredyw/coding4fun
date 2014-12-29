package coding4fun;

/**
 * Determine if the binary representation of a positive integer is a palindrome.
 * 
 * <pre>
 * Input: 1 --> 1 in binary
 * Output: true
 * 
 * Input: 3 --> 11 in binary
 * Output: true
 * 
 * Input: 5 --> 101 in binary
 * Output: true
 * 
 * Input: 6 --> 110 in binary
 * Output: false
 * 
 * Input: 7 --> 111 in binary
 * Output: true
 * 
 * Input: 9 --> 1001 in binary
 * Output: true
 * 
 * Input: 13 --> 1101 in binary
 * Output: false
 * </pre>
 */
public class Problem12 {
    private static boolean isBinaryPalindrome(int x) {
        int x1 = x;
        int n = 0;
        while (x1 > 0) {
            n++;
            x1 = x1 >> 1;
        }
        for (int i = 0; i < n/2; i++) {
            if ((x >> (n-1-i) & 1) != (x >> i & 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int x = 1;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 3;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 5;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 6;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 7;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 9;
        System.out.println(x + ": " + isBinaryPalindrome(x));
        
        x = 13;
        System.out.println(x + ": " + isBinaryPalindrome(x));
    }
}
