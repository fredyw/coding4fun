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
 *
 * Input : abcdef
 * Output: [abcdef]
 *
 * Input : abc(de|fh|g(h|i))j
 * Output: [abcdej, abcfhj, abcghj, abcgij]
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
                strings.add(tmp);
                List<String> allStrings = allStrings(s, ref);
                for (String a : allStrings) {
                    strings.add(tmp + a);
                }
                tmp = "";
            } else if (s.charAt(i) == '|') {
                ref.val++;
                strings.add(tmp);
                tmp = "";
            } else if (s.charAt(i) == ')') {
                ref.val++;
                if (!tmp.isEmpty()) {
                    strings.add(tmp);
                }
                return strings;
            } else {
                ref.val++;
                tmp += s.charAt(i);
            }
        }
        if (strings.isEmpty()) {
            strings.add(tmp);
        } else {
            for (int i = 0; i < strings.size(); i++) {
                strings.set(i, strings.get(i) + tmp);
            }
        }
        return strings;
    }

    private static class IntRef {
        private int val;
    }

    public static void main(String[] args) {
//        System.out.println(allStrings("abc(de|fh|g(h|i(jk|lm|mn))"));
//        System.out.println(allStrings("abc(de|fh|g(h|i))"));
//        System.out.println(allStrings("abc(de|fh|g(h|i))j"));
//        System.out.println(allStrings("abcdef"));
        System.out.println(allStrings("abc(de|fh|g(h|i))j(k|l)"));
    }
}
