package coding4fun;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to flatten arbitrarily nested arrays/lists.
 * 
 * <pre>
 * Input: [6, [2, 3, [4, 10], [9, [11, 4, [1]]]]]
 * Output: [6, 2, 3, 4, 10, 9, 11, 4, 1]
 * </pre>
 */
public class Problem5 {
    private static List<Object> flatten(Object[] array) {
        List<Object> l = new ArrayList<>();
        recurseFlatten(array, l);
        return l;
    }
    private static void recurseFlatten(Object[] array, List<Object> result) {
        for (Object o : array) {
            if (o.getClass().isArray()) {
                recurseFlatten((Object[]) o, result);
            } else {
                result.add(o);
            }
        }
    }
    
    public static void main(String[] args) {
        Object[] array = new Object[] {
            6, new Object[] {
                2, 3, new Object[]{4, 10}, new Object[]{9, new Object[]{11, 4, new Object[]{1}}}
            }
        };
        System.out.println(flatten(array));
    }
}
