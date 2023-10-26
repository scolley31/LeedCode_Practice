package org.example;

public class SearchA2DMatrix {


    /**
     * Time complexity O(log(n * m))
     * Space complexity O(1)
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;

        while (rowL <= rowR) {
            int rowMid = rowL + (rowR - rowL) / 2;
            if (matrix[rowMid][0] < target && matrix[rowMid][matrix[rowMid].length - 1] > target) {
                break;
            } else if (matrix[rowMid][0] > target) {
                rowR = rowMid - 1;
            } else {
                rowL = rowMid + 1;
            }
        }

        int row = (rowL + rowR) / 2 ;
        int colL = 0;
        int colR = matrix[0].length - 1;
        while (colL <= colR) {
            int colMid = colL + (colR - colL) / 2;
            if (matrix[row][colMid] == target) {
                return true;
            } else if (matrix[row][colMid] > target) {
                colL = colMid + 1;
            } else {
                colR = colMid - 1;
            }
        }

        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }


}
