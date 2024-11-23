package solutions;

import java.util.Arrays;

public class L1861 {

    public static void main(String[] args) {
        char[][] a = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };

        char[][] b = {
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        };


        System.out.println(Arrays.deepToString(rotateTheBox(a)));

        System.out.println(Arrays.deepToString(b));
        System.out.println(Arrays.deepEquals(rotateTheBox(a), b));
    }

    public static char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        for (int i = 0; i < rows; i++) {
            int emptyIndex = cols - 1;
            for (int j = cols - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyIndex = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }

        return tMatrix(box);
    }


    public static char[][] tMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] tMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tMatrix[j][rows - i -1] = matrix[i][j];
            }
        }
        return tMatrix;
    }
}
