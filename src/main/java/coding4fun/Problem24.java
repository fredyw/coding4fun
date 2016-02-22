package coding4fun;

import java.util.Arrays;

/**
 * Write an algorithm to perform a Tetris rotation.
 */
public class Problem24 {
    public static void rotate(char[][] block) {
        char[][] aux = new char[block.length][];
        for (int row = 0; row < block.length; row++) {
            aux[row] = new char[block[row].length];
            for (int col = 0; col < block[row].length; col++) {
                aux[row][col] = block[row][col];
            }
        }

        for (int row = 0; row < block.length; row++) {
            for (int col = 0; col < block[row].length; col++) {
                // TODO
            }
        }
    }

    private static void print(char[][] block) {
        for (char[] chars : block) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("-----------------------------------------------------------");
    }

    public static void main(String[] args) {
        char[][] block = new char[][]{
            {' ', ' ', ' '},
            {'*', '*', '*'},
            {' ', '*', ' '},
        };
        print(block);

        rotate(block);
        print(block);

        rotate(block);
        print(block);

        rotate(block);
        print(block);
    }
}
