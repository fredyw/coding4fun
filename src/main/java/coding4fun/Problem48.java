package coding4fun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Build a mathematical expression engine. The expression engine only needs to support
 * +, -, *, and /. It needs to also support sub-expression. For simplicity, the expression
 * is delimited with space.
 *
 * <pre>
 * Input:
 * ["a = b + c - e",
 *  "c = d + 1",
 *  "b = 5 * ( e + 5 )",
 *  "e = 100",
 *  "d = e / ( 2 + 3 )"]
 * Variable: a
 *
 * Output: 446
 * </pre>
 *
 * <pre>
 * Input:
 * ["a = b + c - e",
 *  "c = d + 1",
 *  "b = 5 * ( e + 5 )",
 *  "e = 100",
 *  "d = e / ( 2 + 3 )"]
 * Variable: b
 *
 * Output: 525
 * </pre>
 *
 * <pre>
 * Input:
 * ["a = b + c - e",
 *  "c = d + 1",
 *  "b = 5 * ( e + 5 )",
 *  "e = 100",
 *  "d = e / ( 2 + 3 )"]
 * Variable: c
 *
 * Output: 21
 * </pre>
 *
 * <pre>
 * Input:
 * ["a = b + c - e",
 *  "c = d + 1",
 *  "b = 5 * ( e + 5 )",
 *  "e = 100"
 *  "d = e / ( 2 + 3 )"]
 * Variable: d
 *
 * Output: 20
 * </pre>
 *
 * <pre>
 * Input:
 * ["a = b + c - e",
 *  "c = d + 1",
 *  "b = 5 * ( e + 5 )",
 *  "e = 100",
 *  "d = e / ( 2 + 3 )"]
 * Variable: e
 *
 * Output: 100
 * </pre>
 */
public class Problem48 {
    private static double evaluate(String variable, List<String> expressions) {
        Map<String, String> expressionMap = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        for (String expression : expressions) {
            String[] expr = expression.split("=");
            String lhs = expr[0].trim();
            String rhs = expr[1].trim();
            expressionMap.put(lhs, rhs);
        }
        return evaluate(variable, expressionMap, valueMap);
    }

    private static double evaluate(String variable, Map<String, String> expressionMap,
                                   Map<String, Double> valueMap) {
        String expr = expressionMap.get(variable);
        if (isNumber(expr)) {
            return Double.parseDouble(expr);
        }
        String[] split = expr.split("\\s+");
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();
        for (String s : split) {
            if (isNumber(s)) {
                operands.add(Double.valueOf(s));
            } else if (isOperator(s)) {
                operators.add(s);
            } else if (s.equals(")")) {
                String operator = operators.pop();
                Double b = operands.pop();
                Double a = operands.pop();
                operands.add(evaluate(a, b, operator));
            } else if (s.equals("(")) {
                // do nothing
            } else {
                double val;
                if (!valueMap.containsKey(s)) {
                    val = evaluate(s, expressionMap, valueMap);
                    valueMap.put(s, val);
                } else {
                    val = valueMap.get(s);
                }
                operands.add(val);
            }
        }
        while (!operators.isEmpty()) {
            String operator = operators.pop();
            Double b = operands.pop();
            Double a = operands.pop();
            operands.add(evaluate(a, b, operator));
        }
        return operands.pop();
    }

    private static double evaluate(double a, double b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("/")) {
            return a / b;
        } else {
            return a * b;
        }
    }
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("a", Arrays.asList(
            "a = b + c - e",
            "c = d + 1",
            "b = 5 * ( e + 5 )",
            "e = 100",
            "d = e / ( 2 + 3 )"
        ))); // 446
        System.out.println(evaluate("b", Arrays.asList(
            "a = b + c - e",
            "c = d + 1",
            "b = 5 * ( e + 5 )",
            "e = 100",
            "d = e / ( 2 + 3 )"
        ))); // 525
        System.out.println(evaluate("c", Arrays.asList(
            "a = b + c - e",
            "c = d + 1",
            "b = 5 * ( e + 5 )",
            "e = 100",
            "d = e / ( 2 + 3 )"
        ))); // 21
        System.out.println(evaluate("d", Arrays.asList(
            "a = b + c - e",
            "c = d + 1",
            "b = 5 * ( e + 5 )",
            "e = 100",
            "d = e / ( 2 + 3 )"
        ))); // 20
        System.out.println(evaluate("e", Arrays.asList(
            "a = b + c - e",
            "c = d + 1",
            "b = 5 * ( e + 5 )",
            "e = 100",
            "d = e / ( 2 + 3 )"
        ))); // 100
    }
}
