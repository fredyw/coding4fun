package coding4fun;

import java.util.Arrays;

/**
 * Write a function that takes inputs n and x and outputs the number of times
 * we need to shuffle a deck of n cards, so that the deck goes back to its
 * original state.
 * <p>
 * We divide the deck into deck A: n-x cards and deck B: x cards. We shuffle the
 * cards by always taking a card from the bottom of the deck and place it to
 * the top of the deck.
 * <p>
 * <pre>
 * Original state:
 * Deck A  Deck B
 * [0, 1]  [0, 1, 2]
 *
 * After shuffling:
 * Deck A  Deck B
 * [1, 0]  [1, 2, 0]
 * [0, 1]  [2, 0, 1]
 * [1, 0]  [0, 1, 2]
 * [0, 1]  [1, 2, 0]
 * [1, 0]  [2, 0, 1]
 * [0, 1]  [0, 1, 2] (original state)
 *
 * Input: n = 5, x = 3
 * Output: 6
 * </pre>
 */
public class Problem6 {
    private static int shuffle(int n, int x) {
        int[] a = new int[n - x];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int[] aOriginal = Arrays.copyOf(a, a.length);
        int[] b = new int[x];
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        int[] bOriginal = Arrays.copyOf(b, b.length);

        int count = 0;
        while (true) {
            shuffle(a);
            shuffle(b);
            System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
            count++;
            if (Arrays.equals(a, aOriginal) && Arrays.equals(b, bOriginal)) {
                break;
            }
        }
        return count;
    }

    private static void shuffle(int[] a) {
        int tmp = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(shuffle(5, 3));
    }
}
