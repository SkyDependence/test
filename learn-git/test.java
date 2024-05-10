import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] grid = {{1},{22},{333}};
        System.out.println(Arrays.toString(findColumnWidth(grid)));
    }
    
    // 2639. 查询网格图中每一列的宽度
    public static int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = 0; j < m; j++) {
                Integer temp = grid[j][i];
                String temp1 = temp.toString();
                if (temp1.length() > g) {
                    g = temp1.length();
                }
            }
            ans[i] = g;
        }
        return ans;

    }
}
