package level1.test43;

import java.util.*;

/*
 * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
 * 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
 * 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 * 2016 1/1 일은 금요일 부터 시작
 */

class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU","FRI", "SAT", "SUN", "MON", "TUE", "WED"}; //1일이 금요일이기 떄문에 1번 인덱스에 금요일을 넣고 차례대로 작성
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31}; //월 일수
        int add = 0;
        for(int i = 0; i < a-1; i++){ //a-1을 하는 이유는 5월 24일값을 구하기 위해서는 4월합계를 구해야하기때문 index는 0부터 시작하기 떄문에 a-1을 해준다 ex) 0 1 2 3  = 1 2 3 4월이다
            add += month[i]; //각 월별 일수를 더한다
        } 
        add += b; //이후 주어진 날짜 24일을 더해준다 그럼 1,2,3,4월 일수 + 주어진 일수 24가 더해진다.
        return day[add%7]; //더한 값을 7로 나눈 나머지 index를 이용하여 날짜를 출력
    }
}