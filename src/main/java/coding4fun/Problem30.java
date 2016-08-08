package coding4fun;

/**
 * Implement a greatest common divisor.
 * <p>
 * <pre>
 * Input : 32 24
 * Output: 8
 *
 * Input : 3 5
 * Output: 1
 *
 * Input : 4 16
 * Output: 4
 * </pre>
 */
public class Problem30 {
    private static int gcd(int a, int b) {
        // Euclid's algorithm
        if (b == 0) {
            return a;
        }
        int c = a % b;
        return gcd(b, c);
    }

    public static void main(String[] args) {
        System.out.println(gcd(32, 24));
        System.out.println(gcd(3, 5));
        System.out.println(gcd(4, 16));
    }
}
