package level1.test21;

import java.util.*;

/*
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 */
class Solution {
    public String solution(String s) {
        int leng = s.length();
        return leng%2==0? s.substring(leng/2-1,leng/2+1):s.substring(leng/2,leng/2+1); //단어가 짝수일경우 두개출력
    }
}