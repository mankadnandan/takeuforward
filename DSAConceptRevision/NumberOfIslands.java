/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-25/number-of-islands
 */
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '0', '1' },
                { '1', '0', '0', '0', '0' },
                { '1', '1', '1', '0', '1' },
                { '0', '0', '0', '1', '1' } };
        System.out.println(numIslands(grid));

        grid = new char[][] { { '1', '0', '0', '0', '1' },
                { '0', '1', '0', '1', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '1', '0', '1', '0' } };
        System.out.println(numIslands(grid));

        grid = new char[][] { { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(numIslands(grid));

        grid = new char[][] {
                { '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '0', '0' },
                { '1', '1', '0', '1', '1', '1', '0', '1', '0', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '0' },
                { '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '1', '1', '0', '1', '1' },
                { '1', '0', '1', '1', '1', '0', '1', '1', '0', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1' },
                { '1', '0', '1', '1', '0', '0', '1', '0', '1', '0', '1', '1', '0', '0', '0', '1', '1', '0', '0', '0' },
                { '1', '1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '0', '1', '0', '0', '0' },
                { '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0', '0', '0', '0', '1', '1', '0' },
                { '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '0', '0', '0', '1', '1', '0', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '1', '0', '1', '0', '1', '1', '1', '0', '0', '1', '0', '0', '0', '1', '1', '1' },
                { '1', '1', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '0' },
                { '1', '0', '1', '1', '1', '1', '0', '0', '1', '1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0' },
                { '1', '1', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '0', '1', '1', '0', '0', '1', '0', '1' },
                { '1', '1', '0', '1', '0', '1', '0', '1', '1', '0', '0', '1', '1', '1', '1', '0', '0', '1', '0', '1' },
                { '0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '1', '0', '0', '0', '0', '1', '1', '1', '0', '1' },
                { '0', '1', '0', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '1', '1', '0', '0', '0', '0', '1' },
                { '1', '0', '1', '1', '0', '1', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '1', '0' },
                { '0', '0', '0', '1', '0', '1', '1', '0', '1', '1', '0', '1', '0', '1', '0', '0', '1', '0', '0', '1' },
                { '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '0', '0', '1', '0', '0', '0', '1', '0' },
                { '1', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '0', '0',
                        '1' } };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numOfIslands++;
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });
                    bfs(grid, queue, visited);
                }
            }
        }
        return numOfIslands;
    }

    private static void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int[] dirRow = new int[] { -1, 0, 1, -1, 0, 1, 1, -1 };
        int[] dirCol = new int[] { -1, -1, -1, 1, 1, 1, 0, 0 };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int i = 0; i < dirRow.length; i++) {
                int newRow = cell[0] + dirRow[i];
                int newCol = cell[1] + dirCol[i];
                if (!outOfBounds(grid, newRow, newCol) && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static boolean outOfBounds(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return true;
        } else {
            return false;
        }
    }
}
