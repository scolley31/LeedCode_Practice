package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    /**
     *
     * Use HashSet to solve
     * Time complexity O(n^2)
     * Space complexity O(n^2)
     *
     *
    * */

    public boolean isValidSudoku(char[][] board) {

        // row
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) return false;
                }
            }
        }

        // column
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> columnSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (!columnSet.add(board[j][i])) return false;
                }
            }
        }

        // box
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String index = "i = "+i/3+"j = "+j/3+"char = "+board[i][j];
                    if (!hashSet.add(index)) return false;
                }
            }
        }

        return true;

    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!hashSet.add("column in " + i + " character "+ board[i][j]) ||
                            !hashSet.add("row in " + j + " character "+ board[i][j]) ||
                            !hashSet.add("box in " + i / 3 + "_" + j / 3 + "character "+ board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
