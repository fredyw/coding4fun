package coding4fun;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem is a modified of longest common prefix problem, i.e.
 * find the longest common prefix in __any__ available strings.
 * <br/>
 * If there are multiple longest common prefix strings, you can return any
 * longest common prefix string.
 * 
 * <pre>
 * Input:  bbbc 
 *         bbdda
 *         aaaabbb
 *         aaaabb
 *         aabbcc
 *         bbbbbcccde
 *         bbbbbcccdf
 * Output: bbbbbcccd
 * 
 * Input : c
 * Output: c
 * 
 * Input : a
 *         a
 *         c
 * Output: a
 * 
 * Input:  aca
 *         cba
 * Output: <empty string>
 * 
 * Input : a
 * Output: a
 * </pre>
 */
public class Problem13 {
    private static String modifiedLongestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        class Node {
            Map<Character, Node> children = new HashMap<>();
        }

        Node root = new Node();
        int max = 0;
        String lcp = "";
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Node node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.children.containsKey(chars[i])) {
                    node = node.children.get(chars[i]);
                    if (max <= i) {
                        max = i;
                        lcp = s.substring(0, i+1);
                    }
                } else {
                    Node newNode = new Node();
                    node.children.put(chars[i], newNode);
                    node = newNode;
                }
            }
        }
        return lcp;
    }
    
    public static void main(String[] args) {
        System.out.println(modifiedLongestCommonPrefix(new String[]{
            "bbbc",
            "bbdda",
            "aaaabbb",
            "aaaabb",
            "aabbcc",
            "bbbbbcccde",
            "bbbbbcccdf"
        }));
        
        System.out.println(modifiedLongestCommonPrefix(new String[]{
            "c",
            "c"
        }));
        
        System.out.println(modifiedLongestCommonPrefix(new String[]{
            "a",
            "a",
            "c"
        }));
        
        System.out.println(modifiedLongestCommonPrefix(new String[]{
            "aca",
            "cba",
        }));
        
        System.out.println(modifiedLongestCommonPrefix(new String[]{
            "a",
        }));
    }
}
