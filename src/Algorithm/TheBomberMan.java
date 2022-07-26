import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
    
        ArrayList<String> answer = new ArrayList<String>();

        List<StringBuilder> temp = new ArrayList<StringBuilder>();

        StringBuilder tempSb = new StringBuilder();

        String tempS = "";

        int cycle = 0;
        // nothing happen
        if (n == 1) {
            return grid;
        }

        // for 2,3,4 needed.
        for (int i = 0; i < grid.get(0).length(); i++) {
            tempS += "O";
        }

        // for 2,3,4 needed.
        for (int i = 0; i < grid.size(); i++) {
            tempSb = new StringBuilder(tempS);
            temp.add(tempSb);
        }

        // first case all bomb.
        if (n % 2 == 0) {
            for (StringBuilder sb : temp) {
                answer.add(sb.toString());
            }
            return answer;
        }

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).length(); j++) {
                if (grid.get(i).charAt(j) == 'O') {

                    // middle
                    temp.get(i).setCharAt(j, '.');

                    // up side
                    if (i - 1 >= 0) {
                        temp.get(i - 1).setCharAt(j, '.');
                    } // left side
                    if (j - 1 >= 0) {
                        temp.get(i).setCharAt(j - 1, '.');
                    } // right side
                    if (j + 1 < grid.get(0).length()) {
                        temp.get(i).setCharAt(j + 1, '.');
                    } // down side.
                    if (i + 1 < grid.size()) {
                        temp.get(i + 1).setCharAt(j, '.');
                    }
                }
            }
        }

        for (StringBuilder sb : temp) {
            answer.add(sb.toString());
        }

        if (n % 4 == 3) {
            return answer;
        } else if (n % 4 == 1) {
            temp = explosionCalculate(answer, 1);
            answer.clear();
            for (StringBuilder sb : temp) {
                answer.add(sb.toString());
            }
        }
        return answer;

    }
        public static List<StringBuilder> explosionCalculate(List<String> grid, int n) {

        ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();

        StringBuilder tempSb = new StringBuilder();

        String tempS = "";

        for (int i = 0; i < grid.get(0).length(); i++) {
            tempS += "O";
        }

        for (int i = 0; i < grid.size(); i++) {
            tempSb = new StringBuilder(tempS);
            temp.add(tempSb);
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).length(); j++) {

                if (grid.get(i).charAt(j) == 'O') {

                    // middle
                    temp.get(i).setCharAt(j, '.');

                    // up side
                    if (i - 1 >= 0) {
                        temp.get(i - 1).setCharAt(j, '.');
                    } // left side
                    if (j - 1 >= 0) {
                        temp.get(i).setCharAt(j - 1, '.');
                    } // right side
                    if (j + 1 < grid.get(0).length()) {
                        temp.get(i).setCharAt(j + 1, '.');
                    } // down side.
                    if (i + 1 < grid.size()) {
                        temp.get(i + 1).setCharAt(j, '.');
                    }
                }
            }
        }

        return temp;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
