package coding4fun;

import java.util.Arrays;

/**
 * Write an algorithm to perform a Tetris rotation.
 */
public class Problem24 {
    public static char[][] rotate(char[][] block) {
        int rowSize = block.length;
        int colSize = block[0].length;

        // tranpose the matrix
        char[][] result = new char[colSize][rowSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                result[j][i] = block[i][j];
            }
        }
        // reverse the rows
        for (int i = 0; i < result.length; i++) {
            for (int j = 0, k = result[i].length - 1; j < result[i].length / 2; j++, k--) {
                char tmp = result[i][k];
                result[i][k] = result[i][j];
                result[i][j] = tmp;
            }
        }

        return result;
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
            {' ', ' ', '*'},
        };
        print(block);

        block = rotate(block);
        print(block);

        block = rotate(block);
        print(block);

        block = rotate(block);
        print(block);
    }
}
