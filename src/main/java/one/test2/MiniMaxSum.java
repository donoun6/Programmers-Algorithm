package one.test2;

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
    static long min = 0;
    static long max = 0;
    static long add = 0;
    public static void miniMaxSum(List<Integer> arr) {
        for(int i = 0; i < arr.size(); i++) {
            if(max < arr.get(i)) {
                max = arr.get(i);
            }
            if(min > arr.get(i) || min == 0) {
                min = arr.get(i);
            }
            add += arr.get(i);
        }
        System.out.println((add - max) +" "+ (add - min));
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
