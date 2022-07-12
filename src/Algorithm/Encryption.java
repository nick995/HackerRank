import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING. The function accepts STRING s as
     * parameter.
     */

    public static String encryption(String s) {
        // Write your code here

            int row = (int) Math.sqrt(s.length());
        
        int col =  (int) Math.ceil(Math.sqrt(s.length()));
        
        HashMap<Integer, List<Character>> temp = new HashMap<Integer, List<Character>>();
        // initializing
        for (int i = 0; i < col; i++) {
            temp.put(i, new ArrayList<Character>());
        }

        for (int i = 0; i < s.length(); i++) {

            temp.get(i % col).add(s.charAt(i));
        }
        StringBuilder tempanswer = new StringBuilder();

        for (Entry<Integer, List<Character>> l : temp.entrySet()) {

            for (char c : l.getValue()) {
                tempanswer.append(c);
            }
            tempanswer.append(" ");

        }

        return tempanswer.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 