package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implement Pascal's triangle for a given number.
 * <p>
 * <pre>
 * Input: 6
 * Output:
 *             1
 *          1     1
 *        1    2    1
 *     1    3     3    1
 *   1   4     6     4   1
 * 1   5   10     10   5   1
 * </pre>
 */
public class Problem41 {
    private static void pascalTriangle(int n) {
        pascalTriangle(n, Arrays.asList(1));
    }

    private static void pascalTriangle(int n, List<Integer> list) {
        if (n == 0) {
            return;
        }
        System.out.println(list);
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            newList.add(list.get(i) + list.get(i + 1));
        }
        newList.add(1);
        pascalTriangle(n - 1, newList);
    }

    public static void main(String[] args) {
        pascalTriangle(6);
    }
}
