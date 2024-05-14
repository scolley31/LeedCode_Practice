public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || grid.length - 1 < x || y < 0 || grid[0].length - 1 < y || grid[x][y] == 0) {
            return 0;
        }
        int temp = grid[x][y];

        grid[x][y] = 0;

        int up = dfs(grid, x - 1, y);
        int down = dfs(grid, x + 1, y);
        int left = dfs(grid, x, y - 1);
        int right = dfs(grid, x, y + 1);

        grid[x][y] = temp;

        return Math.max(Math.max(Math.max(left, right), up), down) + temp;
    }
}