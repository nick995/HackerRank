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
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
            // x
        int row = P.get(0).length();
        // y
        int col = P.size();

        int temp = 0;

        int startIndex = 0;
        int endIndex = 0;
        int j = 0;

        int continious = 0;
        int count = 0;
        String tempString = "";
        String answer = "NO";

        for (String s : G) {

            //
            if (s.contains(P.get(0))) {

                startIndex = s.indexOf(P.get(0));
                endIndex = startIndex + row;
                continious = s.lastIndexOf(P.get(0));


                // List
                for (int i = temp; i < temp + col; i++, j++) {

                    if (startIndex != continious) {

                        int tempI = i;

                        for (int z = startIndex; z <= continious; z++) {

                            while (count != col) {

                                tempString = G.get(tempI).substring(z, z + row);

                                if (tempString.equals(P.get(count))) {
                                    answer = "YES";
                                    tempI++;
                                    count++;

                                } else {
                                    answer = "NO";
                                    tempI = i;
                                    count = 0;
                                    break; 
                                }
                            }
                            
                            if(count == col) {
                                return answer;
                            }

                        }

                    } else {

                        tempString = G.get(i).substring(startIndex, endIndex);

                        if (tempString.equals(P.get(j))) {
                            answer = "YES";
                        } else {
                            answer = "NO";
                            break;
                        }
                    }
                }
                j = 0;

            }
            if (answer.equals("YES")) {
                break;
            }
            temp++;
        }

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridSearch(G, P);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
