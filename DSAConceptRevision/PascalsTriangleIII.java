/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-2/pascals-triangle-iii
 */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIII {
    public static void main(String[] args) {
        List<List<Integer>> resultList = pascalTriangleIII(30);
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> resultRow = resultList.get(i);
            for (int j = 0; j < resultRow.size(); j++) {
                System.out.print(resultRow.get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> resultRow = new ArrayList<>();
            if (i == 0) {
                resultRow.add(1);
            } else if (i == 1) {
                resultRow.add(1);
                resultRow.add(1);
            } else {
                List<Integer> prevRow = resultList.get(i - 1);
                resultRow.add(1);
                for (int j = 1; j < prevRow.size(); j++) {
                    resultRow.add(prevRow.get(j) + prevRow.get(j - 1));
                }
                resultRow.add(1);
            }
            resultList.add(resultRow);
        }

        return resultList;
    }
}