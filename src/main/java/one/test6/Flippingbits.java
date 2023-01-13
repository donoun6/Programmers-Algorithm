package one.test6;

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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
    	String bit = "";
    	if( Long.toBinaryString(n).length() != 32) { //Long.toBinaryString(n) 는 long타입의 수를 2진수로 변환 Sring형태로
    		for(int i = 0; i < 32-Long.toBinaryString(n).length(); i++) { // 32비트이므로 앞에 없는 이진수 채우기
    			bit += "1";
    		}
    	}
    	String change = Long.toBinaryString(n).replace("0","change"); // 숫자 뒤집기 과정
		change = change.replace("1","0");
		change = change.replace("change","1");
		bit += change;
    	 n = Long.valueOf(bit, 2); // String타입 2진수를 long타입 10진수로 변환
		return n;
    }

}

public class Flippingbits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}