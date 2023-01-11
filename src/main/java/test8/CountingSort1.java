package test8;
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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
//    	int max = Collections.max(arr)+1; //리스트중 최대값을 찾는것이지만 해당 문제에선는 쓰이지 않았다 나는 뻘짓을 했다.
    	List<Integer> arr2 = new ArrayList<Integer>();
    	for(int i = 0; i < 100; i++) {
    		arr2.add(0); //해당 리스트는 size가 없으므로 임의값을 넣어 size를 지정 list는 배열길이를 지정할순있지만 값이없으면 []으로 나온다.
    	}
    	for(int i = 0; i < arr.size(); i++) {
    		arr2.set(arr.get(i), arr2.get(arr.get(i))+1); //해당인덱스에 세팅을 한다
    	}
		return arr2;
    }
}

public class CountingSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
