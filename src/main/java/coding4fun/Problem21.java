package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of characters, generate a possible ways to parenthesize the characters.
 *
 * <pre>
 * Input : [a, b]
 * Output: [(a, b)]
 *
 * Input : [a, b, c]
 * Output: [(a(bc)), ((ab)c)]
 *
 * Input : [a, b, c]
 * Output: [(a(b(cd))), (a((bc)d)), ((ab)(cd)),
 *          ((a(bc))d), (((ab)c)d)]
 * </pre>
 */
public class Problem21 {
    public static List<String> generate(List<String> list) {
        if (list.size() == 1) {
            return list;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            List<String> left = generate(list.subList(0, i+1));
            List<String> right = generate(list.subList(i+1, list.size()));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + r + ")");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(Arrays.asList("a", "b")));
        System.out.println(generate(Arrays.asList("a", "b", "c")));
        System.out.println(generate(Arrays.asList("a", "b", "c", "d")));
    }
}
