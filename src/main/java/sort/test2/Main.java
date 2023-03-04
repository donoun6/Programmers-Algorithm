package sort.test2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
 
public class Main {
    static int count = 0;
	public static void main(String[] args) throws IOException {
		re(3,"start");

	}
	public static void re(int n, String s) throws IOException {
		
		if(n < 0) {
			System.out.println(n +" "+ s +" return!");
			return;
		}
		System.out.println(n +" "+ s);
		re(n-1,"one");
		re(n-2,"two");
	}
}