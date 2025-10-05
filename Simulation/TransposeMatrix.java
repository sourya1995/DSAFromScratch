package Simulation;

/* 867. Transpose Matrix */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] result = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
