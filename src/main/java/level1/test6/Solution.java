package level1.test6;

class Solution {
	/*
	 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 
	 * 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
	 * 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
	 */
	boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase(); //문자를 대문자로 만든다.
        String[] arr = s.split("");//한문자씩 잘라서 배열에 저장
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("P")){ //해당문자가 P와 같다면 count는 ++ 아니면 --;
                count++;
            }else if(arr[i].contains("Y")){
                count--;
            }
        }
        if(count==0){ //count가 0이면 P == Y 개수가 같다는말
            answer = true;
        }else {
            answer = false;
        }
        
        return answer;
    }
}
