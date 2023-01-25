package level1.test52;

import java.util.*;

/*
 * 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
 * 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
 * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다
 * a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
 * n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
 * a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
 * 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
 * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 */

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){ //해당글자가 이전에 없을떄
                answer[i] = -1; // -1값을 주고
                map.put(s.charAt(i),i); //해당값과 index값을 map에 넣는다.
            }else { //해당 글자가 앞쪽에 있을때
                int before = map.get(s.charAt(i)); //해당 글자가 있는 index를 가져온다
                answer[i] = i - before; // 현재 index값과 해당 글자가 있는 index를 빼주어 글자사이의 차를 구한다.
                map.put(s.charAt(i), i); //해당 값과 index를 map에 넣는다 *map은 중복값은 안들어간다 즉, index값만 현재값으로 변하는것이다
            }
        }
        return answer;
    }
}

class Solution2 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] spl = s.split("");
        List<String> list = new ArrayList<>();
        for(String c : spl){
            list.add(c);
        }
        for(int i = 0; i < list.size(); i++){
            if(list.indexOf(list.get(i)) != i){
                answer[i] = i-list.indexOf(list.get(i));
                list.set(list.indexOf(list.get(i)),"0");
            }else {
                answer[i] = -1;
            }            
        }
        return answer;
    }
}