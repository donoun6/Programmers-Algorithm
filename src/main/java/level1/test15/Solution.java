package level1.test15;

import java.util.*;

/*
 * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
 * seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 */
class Solution {
    public String solution(String[] seoul) {
        return "김서방은 "+Arrays.asList(seoul).indexOf("Kim")+"에 있다"; //Arrays.asList(seoul)는 해당 배열원소를 for문을 사용하지않고 출력할수있다. indexOf는 포함된 값이 몇번째 index인지 출력
    }
}