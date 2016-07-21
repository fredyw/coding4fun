package coding4fun;

/**
 * Implement least common denominator.
 *
 * <pre>
 * Input : 32 24
 * Output: 96
 *
 * Input : 3 5
 * Output: 15
 *
 * Input : 4 16
 * Output: 16
 * </pre>
 */
public class Problem31 {
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int c = a % b;
        return gcd(b, c);
    }

    private static int lcd(int a, int b) {
        // from old-school math
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcd(32, 24));
        System.out.println(lcd(3, 5));
        System.out.println(lcd(4, 16));
    }
}
