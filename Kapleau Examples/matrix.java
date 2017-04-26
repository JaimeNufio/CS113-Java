public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[10][10];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = i * j;
            }
        }

        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print((col < 10 ? " " : "") + col + " ");
            }
            System.out.println();
        }
    }
}
