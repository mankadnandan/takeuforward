/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-2/pascals-triangle-iii
 * 
 * Using nCr formula.
 */
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIII_2 {
    public static void main(String[] args) {
        List<List<Integer>> resultList = pascalTriangleIII(5);
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> resultRow = resultList.get(i);
            for (int j = 0; j < resultRow.size(); j++) {
                System.out.print(resultRow.get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> row = getPascalTriangleRow(i);
            result.add(row);
        }
        return result;
    }

    private static List<Integer> getPascalTriangleRow(int r) {
        long ans = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        // The below loop is calculating nCr, where n = row and r = col for a particular row.
        for (int i = 1; i < r; i++) {
            ans = ans * (r - i);
            ans = ans / i;        
            row.add((int) ans);
        }
        return row;
    }
}