package one.test9;
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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    	String[] text = s.toLowerCase().replace(" ","").split("");
    	boolean[] test = new boolean[26];
    	for(int i = 0; i < text.length; i++) {
    		test[(int)text[i].charAt(0) - 97] = true;
    	}
    	for(int i = 0; i < test.length; i++) {
    		if(test[i] == false) {
    			s = "not pangram";
    			break;
    		}else {
    			s = "pangram";
    		}
    	}
		return s;

    }

}

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
