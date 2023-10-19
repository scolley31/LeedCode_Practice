package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Time complexity O(n^2)
     * Space complexity S(n^2) in memory
     * */
    public List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>();
        backtracking(lists, "", 0, 0, n);
        return lists;
    }

    private void backtracking(List<String> lists,String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            lists.add(str);
            return;
        }
        if (open <  n) {
            backtracking(lists, str+"(", open+1, close, n);
        }
        if (close < open) {
            backtracking(lists, str+")", open, close+1, n);
        }
    }
}
