package hash.test3;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, String> map = new HashMap<>();
		
		for(int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], ""); //containsKey 클래스를 이용해야하기 때문에 value값은 필요없다.
		}
		
		for(String s : phone_book) {
			for(int i = 1; i < s.length(); i++) {
				if(map.containsKey(s.substring(0, i))) { //한글자씩 잘라서 같은 글자가 나올때까지 반복 자기자신이 되면 안되기때문에 length-1을 하지않는다.                    
					return false;
				}
			}
		}
        
        return answer;
    }
}