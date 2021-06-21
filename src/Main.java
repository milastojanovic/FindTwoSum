import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Integer[] array = {3, 1, 5, 7, 5, 9}; // result: 0 and 3 (or 3 and 0); 1 and 5 (or 5 and 1); 2 and 4 (or 4 and 2)
//        Integer[] array = null; // result: e
//        Integer[] array = {}; // result: e
        int targetSum = 10;
//        int targetSum = 0;

        try {
            Integer[] result = findTwoSum(array, targetSum);
            System.out.println(result[0] + " and " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Integer[] findTwoSum(Integer[] array, int targetSum) throws IllegalArgumentException {
        if ((array == null) || (array.length == 0) || (targetSum == 0)) {
            throw new IllegalArgumentException("Illegal argument.");
        }

        List<Integer[]> indices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            Integer[] pairOfIndices = new Integer[2];
            int j = i + 1;
            boolean search = true;
            while (search) {
                if (j < array.length) {
                    if (array[i ] + array[j] == targetSum) {
                        if (array[i] + array[j] == targetSum) {
                            pairOfIndices[0] = i;
                            pairOfIndices[1] = j;
                            indices.add(pairOfIndices);
                            search = false;
                        } else {
                            j++;
                        }
                    } else {
                        j++;
                    }
                } else {
                    search = false;
                }
            }
        }

        if (indices.size() > 0) {
            Random random = new Random();
            int index = random.nextInt(indices.size());
            Integer[] result = indices.get(index);

            // if i == 1, switch elements in the array
            int i = random.nextInt(2);
            if (i == 1) {
                int x = 0;
                x = result[0];
                result[0] = result[1];
                result[1] = x;
            }

            return result;
        } else {
            return null;
        }
    }
}
