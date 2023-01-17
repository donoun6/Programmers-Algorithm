package level1.test10;

import java.util.*;

/*
 * 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 */
class Solution {
    public long solution(long n) {
        String a = "";
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr,Collections.reverseOrder()); //내림차순   
        for(String num : arr){
            a += num;
        }
        return Long.parseLong(a);
    }
}
