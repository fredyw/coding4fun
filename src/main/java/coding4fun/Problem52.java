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
 * </pre>
 */
public class Problem52 {
    public static String reverse(String str) {
        // TODO
        return str;
    }

    public static void main(String[] args) {
        System.out.println(reverse("/olleh123?dlrow!"));
        System.out.println(reverse("1234567890"));
        System.out.println(reverse("123/[]\\abc()-="));
    }
}
