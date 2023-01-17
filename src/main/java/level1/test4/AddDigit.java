package level1.test4;

import java.util.*;

public class AddDigit {
	/*
	 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
		예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
	 */
    public int solution(int n) {
        int answer = 0;
        String[] arr = String.valueOf(n).split(""); //숫자 n을 하나씩 자른후 String형태의 배열로 저장
        for(int i = 0; i < arr.length; i++){
            answer += Integer.parseInt(arr[i]); //하나씩 자른값을 계속 더한다.
        }
        return answer;
    }
}
