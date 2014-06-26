package coding4fun;

/**
 * Given a 2D array, such as:
 * <pre>
 * Input:
 * {{"a1", "b1", "c1"},
 *  {"a2", "b2", "c2", "d2"},
 *  {"a3", "b3"},
 *  {"a4"}}
 * </pre>
 *  
 * Print the 2D array in the following order:
 * <pre>
 * Output:
 * a1, a2, a3, a4, b1, b2, b4, c1, c2, d2
 * </pre>
 */
public class Problem9 {
    private static void print(String[][] array) {
        int col = 0;
        while (true) {
            boolean found = false;
            for (int row = 0; row < array.length; row++) {
                if (array[row].length > col) {
                    System.out.print(array[row][col] + " ");
                    found = true;
                }
            }
            if (!found) {
                break;
            }
            col++;
        }
    }
    
    public static void main(String[] args) {
        String[][] array = new String[][] {
            new String[] {"a1", "b1", "c1"},
            new String[] {"a2", "b2", "c2", "d2"},
            new String[] {"a3", "b3"},
            new String[] {"a4"}
        };
        print(array);
    }
}
