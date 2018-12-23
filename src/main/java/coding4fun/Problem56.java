package coding4fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a simple regular like-expression. Print all possible strings that match
 * the expression.
 *
 * <pre>
 * Input : abc(de|fh|g(h|i))
 * Output: [abcde, abcfh, abcgh, abcgi]
 *
 * Input : abc(de|fh|g(h|i(jk|lm|mn))
 * Output: [abcde, abcfh, abcgh, abcgijk, abcgilm, abcgimn]
 * </pre>
 */
public class Problem56 {
    private static List<String> allStrings(String s) {
        return allStrings(s, new IntRef());
    }

    private static List<String> allStrings(String s, IntRef ref) {
        List<String> strings = new ArrayList<>();
        String tmp = "";
        while (ref.val < s.length()) {
            int i = ref.val;
            if (s.charAt(i) == '(') {
                ref.val++;
                for (String a : allStrings(s, ref)) {
                    strings.add(tmp + a);
                }
                ref.val++;
                tmp = "";
            } else if (s.charAt(i) == '|') {
                ref.val++;
                strings.add(tmp);
                tmp = "";
            } else if (s.charAt(i) == ')') {
                ref.val++;
                strings.add(tmp);
                return strings;
            } else {
                ref.val++;
                tmp += s.charAt(i);
            }
        }
        return strings;
    }

    private static class IntRef {
        private int val;
    }

    public static void main(String[] args) {
        System.out.println(allStrings("abc(de|fh|g(h|i(jk|lm|mn))"));
        System.out.println(allStrings("abc(de|fh|g(h|i))"));
//        System.out.println(allStrings("abc(de|fh|g(h|i))j(k|l)"));
    }
}
