package level1.test39;

import java.util.*;

/*
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
 * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 */

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings, new Comparator<String>() {

//        	앞에 값(o1)과 뒤의 값(o2)을 비교해서 리턴값을 양수로 주면 값을 바꿈 -> 오름차순
//        	앞에 값(o1)과 뒤의 값(o2)을 비교해서 리턴값을 음수로 주면 값을 바꾸지 않음 -> 내림차순
//        	o1.charAt(n) == o2.charAt(n)
//        	라는 조건일 때에는 o1.compareTo(o2)를 해주면 된다.(String의 compareTo() 함수의 매개변수의 값과 비교해서 o1의 값이 더 크면 양수를 리턴해주니까 뒤로 가게 되므로)
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                } else if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });
        
        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i];
        }
        
        return answer;
    }
}