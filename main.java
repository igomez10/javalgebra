///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String... args) {
        out.println("Hello World\n");
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(4, 5, 6));
        ArrayList<Integer> list3 = new ArrayList<>(List.of(7, 8, 9));
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(list1);
        matrix.add(list2);
        matrix.add(list3);

        out.println(matrixToString(matrix));

        out.println("rotate clockwise:");
        out.println(matrixToString(rotateMatrixClock(matrix)));

        out.println("rotate counter:");
        out.println(matrixToString(rotateMatrixCounter(matrix)));
    }

    public static String matrixToString(List<ArrayList<Integer>> matrix) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> row : matrix) {
            for (Integer value : row) {
                result.append(value).append("  ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static List<ArrayList<Integer>> rotateMatrixClock(List<ArrayList<Integer>> matrix) {
        /*
         * 1 2 3 | 7 4 1 | (2,0) (1,0) (0,0)
         * 4 5 6 | 8 5 2 | (2,1) (1,1) (0,1)
         * 7 8 9 | 9 6 3 | (2,2) (1,2) (0,2)
         */

        List<ArrayList<Integer>> newmatrix = new ArrayList<ArrayList<Integer>>();
        // initialize newmatrix with rows in input matrix
        for (int i = 0; i < matrix.get(0).size(); i++) {
            newmatrix.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < matrix.get(0).size(); i++) {
            for (int j = matrix.size() - 1; j >= 0; j--) {
                newmatrix.get(i).add(matrix.get(j).get(i));
            }
        }
        return newmatrix;
    }

    public static List<ArrayList<Integer>> rotateMatrixCounter(List<ArrayList<Integer>> matrix) {
        /*
         * 1 2 3 | 3 6 9 | (0,2) (1,2) (2,2)
         * 4 5 6 | 2 5 8 | (0,1) (1,1) (2,1)
         * 7 8 9 | 1 4 7 | (0,0) (1,0) (2,0)
         */

        List<ArrayList<Integer>> newmatrix = new ArrayList<ArrayList<Integer>>();
        // initialize newmatrix with rows in input matrix
        for (int i = 0; i < matrix.get(0).size(); i++) {
            newmatrix.add(new ArrayList<Integer>());
        }

        for (int i = matrix.get(0).size() - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.size(); j++) {
                newmatrix.get(matrix.get(0).size() - 1 - i).add(matrix.get(j).get(i));
            }
        }
        return newmatrix;
    }
}
