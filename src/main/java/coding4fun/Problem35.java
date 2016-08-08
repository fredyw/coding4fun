package coding4fun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S and an integer K, rearrange the string such that similar characters are at least K distance apart.
 * <p>
 * <pre>
 * Input: S: AAABBBCC, K: 3
 * Output: [A, B, C, A, B, C, A, B]
 *
 * Input: S: AAABBBCC, K: 2
 * Output: []
 *
 * Input: S: AAABC, K: 2
 * Output: [A, C, A, B, A]
 *
 * Input: S: AAABC, K: 3
 * Output: []
 *
 * Input: S: AAADBBCC, K: 3
 * Output: [A, B, C, A, B, C, A, D]
 *
 * Input: S: AAADBBCC, K: 2
 * Output: [A, B, A, B, A, C, D, C]
 *
 * Input: S: AABBBBC, 2
 * Output: [B, A, B, A, B, C, B]
 * </pre>
 */
public class Problem35 {
    private static class CharCount implements Comparable<CharCount> {
        private final char character;
        private final int count;

        private CharCount(char character, int count) {
            this.character = character;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount o) {
            return Integer.compare(o.count, count);
        }

        @Override
        public String toString() {
            return "CharCount{" +
                "character=" + character +
                ", count=" + count +
                '}';
        }
    }

    private static Character[] rearrange(String str, int k) {
        PriorityQueue<CharCount> queue = new PriorityQueue<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
            } else {
                counts.put(c, counts.get(c) + 1);
            }
        }
        counts.forEach((c, count) -> {
            queue.add(new CharCount(c, count));
        });
        Character[] chars = new Character[str.length()];
        while (!queue.isEmpty()) {
            CharCount cc = queue.remove();
            int idx = 0;
            while (chars[idx] != null) {
                idx++;
            }
            for (int i = idx, j = 0; i < chars.length && j < cc.count; i += k, j++) {
                if (chars[i] != null) {
                    return new Character[]{};
                }
                chars[i] = cc.character;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == null) {
                return new Character[]{};
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrange("AAABBBCC", 3))); // [A, B, C, A, B, C, A, B]
        System.out.println(Arrays.toString(rearrange("AAABBBCC", 2))); // []
        System.out.println(Arrays.toString(rearrange("AAABC", 2))); // [A, C, A, B, A]
        System.out.println(Arrays.toString(rearrange("AAABC", 3))); // []
        System.out.println(Arrays.toString(rearrange("AAADBBCC", 3))); // [A, B, C, A, B, C, A, D]
        System.out.println(Arrays.toString(rearrange("AAADBBCC", 2))); // [A, B, A, B, A, C, D, C]
        System.out.println(Arrays.toString(rearrange("AABBBBC", 2))); // [B, A, B, A, B, C, B]
    }
}
