package one.test1;
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
    static double positive = 0;
    static double negative  = 0;
    static double zero = 0;
    public static void plusMinus(List<Integer> arr) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == 0 ) {
                zero++;
            }
            if(arr.get(i) > 0 ) {
                positive++;
            }
            if(arr.get(i) < 0 ) {
                negative++;
            }
        }
        System.out.println(String.format("%.6f",positive/arr.size()));
        System.out.println(String.format("%.6f",negative/arr.size()));
        System.out.println(String.format("%.6f",zero/arr.size()));
    }
}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        
        Result.plusMinus(arr);

        bufferedReader.close();
    }
}