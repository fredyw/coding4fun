package coding4fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all combinations of well-formed parentheses.
 * 
 * <pre>
 * Input: 1
 * Output: ()
 * 
 * Input: 2
 * Output: (()), ()()
 * 
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 * Input: 4
 * Output: (((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(),
 *         (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()
 * </pre>
 */
public class Problem19 {
    public static List<String> generateParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        generate(n, 0, 0, "", parentheses);
        return parentheses;
    }
    
    private static void generate(int n, int nOpen, int nClose, String accu, List<String> result) {
        if (nClose == n) {
            result.add(accu);
            return;
        }
        if (nOpen < n) {
            generate(n, nOpen+1, nClose, accu + "(", result);
        }
        if (nOpen > nClose) {
            generate(n, nOpen, nClose+1, accu + ")", result);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(generateParentheses(1));
        System.out.println(generateParentheses(2));
        System.out.println(generateParentheses(3));
        System.out.println(generateParentheses(4));
    }
}
