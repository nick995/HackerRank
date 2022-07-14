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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
        char tempChar = ' ';        
        StringBuilder tempAnswer = new StringBuilder(w);
        String sortString = " ";
        
        int temp = 0;

        int temp2 = 0;
        
        boolean find = false;
        for (int i = 0; i < w.length() - 1; i++) {
            if (Character.compare(w.charAt(i), w.charAt(i + 1)) < 0) {
                temp = i;
                find = true;
            }
        }
        
        if(find == false) {
            return "no answer";
        }
        
        for(int j = w.length()-1; j>=temp; j--) {
            if(Character.compare(w.charAt(j), w.charAt(temp))>0 ) {
                temp2 = j;
                tempChar = w.charAt(j);
                break;
                
            }
        }
        System.out.println(tempAnswer);
        //swap
        tempAnswer.setCharAt(temp2, tempAnswer.charAt(temp));
        tempAnswer.setCharAt(temp, tempChar);
        
        sortString = tempAnswer.substring(temp+1, w.length());
        
        char[] arr = sortString.toCharArray();
        
        Arrays.sort(arr);
        
        
        tempAnswer.replace(temp+1, tempAnswer.length(), String.valueOf(arr) );
                
            return tempAnswer.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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
