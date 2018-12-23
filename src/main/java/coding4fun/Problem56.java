package coding4fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem56 {
    private static List<String> allStrings(String s) {
        List<String> strings = new ArrayList<>();
        Stack<List<String>> stack = new Stack<>();
        String tmp = "";
        List<String> tmpList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                List<String> list = new ArrayList<>();
                list.add(tmp);
                stack.add(list);
                System.out.println("storing: " + list);
                tmp = "";
            } else if (s.charAt(i) == '|') {
//                System.out.println(tmp);
//                tmp = stack.peek() + tmp;
                for (String p : stack.peek()) {
                    tmpList.add(p + tmp);
                }
                System.out.println("getting: " + tmpList);
                tmp = "";
            } else if (s.charAt(i) == ')') {
                for (String p : stack.pop()) {

                }
//                System.out.println(tmp);
                tmp = stack.pop() + tmp;
                System.out.println("removing: " + tmp);
//                tmp = "";
            } else {
                tmp += s.charAt(i);
            }
        }
        return strings;
    }

    private static List<String> allStrings(String s, IntRef ref) {
        List<String> strings = new ArrayList<>();
        String tmp = "";
        while (ref.val < s.length()) {
            int i = ref.val;
            if (s.charAt(i) == '(') {
                ref.val++;
                allStrings(s, ref);
            } else if (s.charAt(i) == '|') {

            } else if (s.charAt(i) == ')') {

                return strings;
            } else {
                tmp += s.charAt(i);
                ref.val++;
            }
        }
        return strings;
    }

    private static class IntRef {
        private int val;
    }

    public static void main(String[] args) {
        System.out.println(allStrings("abc(de|fh|g(h|i))j(k|l)"));
    }
}
