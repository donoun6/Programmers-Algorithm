package level2.test02;

/*
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 */

class Solution {
    public String solution(String s) {       
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        boolean flag = false;

        for(String spl : s.split("")){ //문자 하나하나를 비교
            if(flag) answer.append(spl);
            else answer.append(spl.toUpperCase());
            flag = spl.equals(" ") ? false : true; //해당문자가 공백이면 false를 준다 그럼 다음문자는 대문자로 바꿔야한다
        }

        return answer.toString();
    }
}