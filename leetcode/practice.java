import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class practice {
    public static void main(String[] args) {
        int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        System.out.println(diagonalSort(mat));
    }
    
    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            ArrayList<Integer> sort = new ArrayList<Integer>();
            int temp = i;
            for (int j = 0; j < n; j++) {
                if (i >= m) 
                    break;
                sort.add(mat[i][j]);
                i++;
            }
            i = temp;
            Collections.sort(sort);
            for (int j = 0; j < n; j++) {
                if (i >= m)
                    break;
                result[i][j] = sort.get(j);
                i++;
            }
            i = temp;
        }
        for (int j = 1; j < n; j++) {
            ArrayList<Integer> sort = new ArrayList<Integer>();
            int temp = j;
            for (int i = 0; i < m; i++) {
                if (j >= n) 
                    break;
                sort.add(mat[i][j]);
                j++;
            }
            j = temp;
            Collections.sort(sort);
            for (int i = 0; i < m; i++) {
                if (j >= n)
                    break;
                result[i][j] = sort.get(i);
                j++;
            }
            j = temp;
        }
        System.out.println(Arrays.deepToString(result));

        return result;
    }
}
