package coding4fun;

/**
 * There are a series of alphanumeric sequences delimited by a (or a sequence of) non-alphanumeric
 * sequence. Reverse each the alphanumeric sequences such as below.
 *
 * <pre>
 * Input : /olleh123?dlrow!
 * Output: /321hello?world!
 *
 * Input : 1234567890
 * Output: 0987654321
 *
 * Input : 123/[]\abc()-=
 * Output: 321/[]\cba()-=
 *
 * Input : /!@123/[]\abc()-=
 * Output: /!@321/[]\cba()-=
 *
 * Input : /!@&%^-=
 * Output: /!@&%^-=
 * </pre>
 */
public class Problem52 {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int prev = 0;
        int current = 0;
        boolean first = true;
        for (; current < chars.length; current++) {
            if (!isAlphanumeric(chars[current])) {
                reverse(chars, prev, current - 1);
                prev = current;
                first = true;
            } else {
                if (first) {
                    prev = current;
                    first = false;
                }
            }
        }
        reverse(chars, prev, current - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;
        }
    }

    private static boolean isAlphanumeric(char c) {
        return ((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9'));
    }

    public static void main(String[] args) {
        System.out.println(reverse("/olleh123?dlrow!")); // /321hello?world!
        System.out.println(reverse("1234567890")); // 0987654321
        System.out.println(reverse("123/[]\\abc()-=")); // 321/[]\cba()-=
        System.out.println(reverse("/!@123/[]\\abc()-=")); // /!@321/[]\cba()-=
        System.out.println(reverse("/!@&%^-=")); // /!@&%^-=
    }
}
