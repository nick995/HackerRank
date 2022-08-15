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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here 
        int countingUp = 0;

        boolean chao = false;

        int ideal = 0;

        int idealIdx = 0;

        int current = 0;

        for (int i = 0; i < q.size(); i++) {

            ideal = i + 1;

            if (q.get(i) != ideal) {
                current = q.get(i);

                idealIdx = q.get(i) - 1;
                //since 'if anyone cannot bride more than two people'
                //if idealIdx (original index) -i  is bigger than 2,
                // it means someone bride two more people.
                if (idealIdx - i > 2) {
                    System.out.println("Too chaotic");
                    chao = true;
                    break;

                }

            }
            //If i will go through 0 to i-1, it causes time out.
            //We do not need to look through all of index, since people cannot bride
            //more than two people.
            
            
            for (int j = i - 1; j >= Math.max(idealIdx-2, 0); j--) {
                if (q.get(i) < q.get(j)) {
                    countingUp++;
                }
            }
        }
        if(chao == false) {
            System.out.println(countingUp);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
