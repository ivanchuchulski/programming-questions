import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows >= 1) {
            List<Integer> firstRow = List.of(1);  
            result.add(firstRow);
        }

        if (numRows >= 2) {
            List<Integer> secondRow = List.of(1, 1);
            result.add(secondRow);
        }

        for (int i = 2; i < numRows; i++) {
            int rowElements = i + 1;
            var arr = new Integer[rowElements];
    
            arr[0] = arr[rowElements - 1] = 1; 

            for (int j = 1; j < rowElements - 1; j++) {
                List<Integer> prevRow = result.get(i - 1);

                int elem = prevRow.get(j - 1) + prevRow.get(j);
                arr[j] =elem;
            }

            List<Integer> row = Arrays.asList(arr);
            result.add(row);
        }

        return result;
    }
}