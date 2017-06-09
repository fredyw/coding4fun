package coding4fun;

/**
 * Generate a unique ID with a length of 4 that consists of letters a, b, c, and d.
 *
 * For example:
 * <pre>
 * aaaa
 * aaab
 * aaac
 * aaad
 * aaba
 * </pre>
 */
public class Problem50 {
    private static class Id {
        private static char[] CHARS = new char[]{'a', 'b', 'c', 'd'};
        private static int MAX = 255; // (3 * 4**3) + (3 * 4**2) + (3 * 4**1) + (3 * 4**0)
        private int id;

        public String generate() {
            if (id == MAX) { // reset it
                id = 0;
            }
            int i = id;
            StringBuilder sb = new StringBuilder();
            while (i > 0) {
                int idx = i % CHARS.length;
                i = i / CHARS.length;
                sb.append(CHARS[idx]);
            }
            id++;
            return pad(sb).reverse().toString();
        }

        private static StringBuilder pad(StringBuilder sb) {
            int size = sb.length();
            for (int i = 0; i < CHARS.length - size; i++) {
                sb.append(CHARS[0]);
            }
            return sb;
        }
    }

    public static void main(String[] args) {
        Id id = new Id();
        for (int i = 0; i < 5; i++) {
            System.out.println(id.generate());
        }
    }
}
