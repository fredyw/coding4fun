package coding4fun;

/**
 * Count the number of cells in the matrix, such that binary ones that are adjacent
 * or diagonal to each other are considered as one count. There is no wrap-around.
 * Cells on the bottom are not adjacent to the top and the left is not adjacent to
 * the right.
 * <p>
 * <pre>
 * Input:
 * [[1, 0, 0, 1, 0, 0],
 *  [0, 0, 1, 0, 1, 0],
 *  [0, 0, 0, 0, 0, 0],
 *  [1, 1, 0, 0, 0, 0],
 *  [1, 1, 1, 0, 0, 0],
 *  [0, 1, 0, 1, 0, 0]]
 *
 * Output: 3
 *
 * Input:
 * [[1, 0, 0],
 *  [0, 0, 1],
 *  [0, 0, 0]]
 *
 * Output: 2
 *
 * Input:
 * [[1, 1, 1],
 *  [1, 0, 1],
 *  [1, 1, 1]]
 *
 * Output: 1
 *
 * Input:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 *
 * Output: 0
 * </pre>
 */
public class Problem25 {
    public static int count(int[][] matrix) {
        int size = matrix.length;
        int[][] visited = new int[matrix.length][matrix.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[i][j] = -1;
            }
        }
        int counter = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (visited[row][col] >= 0) {
                    continue;
                }
                if (matrix[row][col] == 1) {
                    counter++;
                    update(matrix, visited, size, row, col, counter);
                }
            }
        }
        return counter;
    }

    private static void update(int[][] matrix, int[][] visited, int size, int row, int col, int counter) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            return;
        }
        if (visited[row][col] >= 0) {
            return;
        }
        if (matrix[row][col] == 1) {
            visited[row][col] = 0;
            update(matrix, visited, size, row - 1, col, counter); // top
            update(matrix, visited, size, row, col - 1, counter); //  left
            update(matrix, visited, size, row, col + 1, counter); // right
            update(matrix, visited, size, row + 1, col, counter); // bottom
            update(matrix, visited, size, row - 1, col - 1, counter); // top left
            update(matrix, visited, size, row - 1, col + 1, counter); // top right
            update(matrix, visited, size, row + 1, col - 1, counter); // bottom left
            update(matrix, visited, size, row + 1, col + 1, counter); // bottom right
        } else {
            visited[row][col] = counter;
        }
    }

    public static void main(String[] args) {
        System.out.println(count(new int[][]{
            {1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0}
        })); // 3
        System.out.println(count(new int[][]{
            {1, 0, 0},
            {0, 0, 1},
            {0, 0, 0},
        })); // 2
        System.out.println(count(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        })); // 1
        System.out.println(count(new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        })); // 0
    }
}
