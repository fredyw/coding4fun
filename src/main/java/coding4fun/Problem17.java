package coding4fun;

import java.util.HashMap;
import java.util.Map;

/**
 * http://programmingpraxis.com/2012/01/20/knights-on-a-keypad/
 */
public class Problem17 {
    private static final int[][] KEYPAD = new int[4][3];
    private static final Map<String, Long> KEYPAD_MAP = new HashMap<>();

    static {
        KEYPAD[0] = new int[]{1, 2, 3};
        KEYPAD[1] = new int[]{4, 5, 6};
        KEYPAD[2] = new int[]{7, 8, 9};
        KEYPAD[3] = new int[]{-1, 0, -1};

        for (int i = 0; i < KEYPAD.length; i++) {
            for (int j = 0; j < KEYPAD[i].length; j++) {
                long value = KEYPAD[i][j];
                if (value != -1) {
                    KEYPAD_MAP.put(buildKeyPadKey(i, j), value);
                }
            }
        }
    }

    private static String buildKeyPadKey(int row, int col) {
        return row + "|" + col;
    }

    private static String buildMemoKey(int number, long value) {
        return number + "|" + value;
    }

    public static long getNumPaths(int max, int row, int col) {
        Map<String, Long> memo = new HashMap<>();
        return getNumPaths(max, row, col, 1, memo);
    }

    private static long getNumPaths(int max, int row, int col, int num, Map<String, Long> memo) {
        String key = buildKeyPadKey(row, col);
        if (!KEYPAD_MAP.containsKey(key)) {
            return 0;
        }
        if (max == num) {
            return +1;
        }
        long result = 0;
        result += getResult(max, row - 1, col - 2, num + 1, memo);
        result += getResult(max, row - 1, col + 2, num + 1, memo);
        result += getResult(max, row + 1, col - 2, num + 1, memo);
        result += getResult(max, row + 1, col + 2, num + 1, memo);
        result += getResult(max, row - 2, col - 1, num + 1, memo);
        result += getResult(max, row - 2, col + 1, num + 1, memo);
        result += getResult(max, row + 2, col - 1, num + 1, memo);
        result += getResult(max, row + 2, col + 1, num + 1, memo);
        String keyPadKey = buildKeyPadKey(row, col);
        String memoKey = buildMemoKey(num, KEYPAD_MAP.get(keyPadKey));
        result += 1;
        memo.put(memoKey, result);
        return result;
    }

    private static long getResult(int max, int row, int col, int num, Map<String, Long> memo) {
        String keyPadKey = buildKeyPadKey(row, col);
        if (!KEYPAD_MAP.containsKey(keyPadKey)) {
            return 0;
        }
        String memoKey = buildMemoKey(num, KEYPAD_MAP.get(keyPadKey));
        if (!memo.containsKey(memoKey)) {
            return getNumPaths(max, row, col, num, memo);
        } else {
            return memo.get(memoKey);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 32; i++) {
            System.out.println(getNumPaths(i, 0, 0));
        }
    }
}
