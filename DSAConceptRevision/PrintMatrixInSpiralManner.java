/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-1/print-the-matrix-in-spiral-manner
 * 
 * i/p:
 * 14
 * 6 4 2 7 8 1 3 6 9 7 4 1 2 5
 * 
 * o/p:
 * 1 1 2 2 3 4 4 5 6 6 7 7 8 9 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMatrixInSpiralManner {

    public static void main(String[] args) {

        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result.toString());

        matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        result = spiralOrder(matrix);
        System.out.println(result.toString());

        matrix = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        result = spiralOrder(matrix);
        System.out.println(result.toString());

        matrix = new int[][] {
                { -17, -22, -42, -43, 13, 10, -38, 42, 36, -41 },
                { 28, 21, -5, 20, -34, 48, 38, 8, 30, 7 },
                { -40, -12, -18, 26, 24, 1, -12, 28, 35, -9 },
                { 16, -5, 21, 13, -49, -3, 30, 35, 25, 22 },
                { -4, 42, -19, -37, 14, 40, 43, 3, 18, 4 },
                { -10, 4, -39, -6, 40, -24, -14, 17, -6, 16 },
                { -30, -8, 12, -27, -12, 36, 29, -11, 30, -16 } };
        result = spiralOrder(matrix);
        System.out.println(result.toString());

        matrix = new int[][] { { 43 }, { -41 }, { -40 }, { 33 }, { -1 }, { 42 }, { -25 } };
        result = spiralOrder(matrix);
        System.out.println(result.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return Collections.emptyList();
        }
        if (matrix.length == 0) {
            return Collections.emptyList();
        }

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (top < bottom && left < right) {

            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                result.add(matrix[i][left]);
            }

            top++;
            left++;
            bottom--;
            right--;
        }

        if (top == bottom && left == right && top == left) {
            result.add(matrix[top][left]);
        } else if (top == bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
        }
        return result;
    }
}