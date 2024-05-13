import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = { { 1, 2 } };
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int min = 0;
        int m = grid.length;
        int n = grid[0].length;
        while (true) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                temp[i] = grid[i].clone();
            }

            boolean flag = true;
            outerLoop:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        flag = false;
                        break outerLoop;
                    }
                }
            }
            if (flag) {
                return min;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 2) {
                        if (i + 1 < m && temp[i + 1][j] == 1) {
                            grid[i + 1][j] = 2;
                        }
                        if (i - 1 >= 0 && temp[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                        }
                        if (j - 1 >= 0 && temp[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                        }
                        if (j + 1 < n && temp[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                        }
                    }
                }
            }
            min++;
            if (Arrays.deepEquals(grid, temp)) {
                return -1;
            }
        } 
    }

    private Map<Integer, Integer> memo = new HashMap<>();
    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int days = minDays(n) + 1;

        if (n % 2 == 0) {
            days = Math.min(days, minDays(n / 2) + 1);
        }

        if (n % 3 == 0) {
            days = Math.min(days, minDays(n / 3) + 1);
        }

        memo.put(n, days);
        return days;
    }
}
