package level2.test32;
import java.util.*;

/* 
신입사원 어피치는 카카오톡으로 전송되는 메시지를 압축하여 전송 효율을 높이는 업무를 맡게 되었다. 메시지를 압축하더라도 전달되는 정보가 바뀌어서는 안 되므로, 압축 전의 정보를 완벽하게 복원 가능한 무손실 압축 알고리즘을 구현하기로 했다.

어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 LZW(Lempel–Ziv–Welch) 압축을 구현하기로 했다. LZW 압축은 1983년 발표된 알고리즘으로, 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.

LZW 압축은 다음 과정을 거친다.

길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
단계 2로 돌아간다.
압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다. 사전의 색인 번호는 정수값으로 주어지며, 1부터 시작한다고 하자.
 */
class Solution {
     static Map<String,Integer> map;
     static List<Integer> list;
    public int[] solution(String msg) {       
        map = init();
        list = LZW(msg);

        int[] answer = new int[list.size()];     
        int index = 0;
        for(int ans : list){
            answer[index] = ans;
            index++;
        }
        return answer;
    }

    private static Map<String,Integer> init(){ //A-Z까지 색인번호 초기화
        map = new HashMap<>();
        char c = 'A';
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf(c),i+1);
            c++;
        }
        return map;
    }

    private static List<Integer> LZW(String msg){ //LZW알고리즘
        list = new ArrayList<>();
        //마지막 문자일 경우
        for(int i = 0; i < msg.length(); i++){     
            if(i+1 == msg.length()){
                list.add(map.get(String.valueOf(msg.charAt(i))));//색인번호를 list에추가
                break;
            }
            
            String w = String.valueOf(msg.charAt(i));
            String c = String.valueOf(msg.charAt(i+1));
			
            /*
            *map에 w+c가 있다면
            *w는 w+c의 형태로 갱신
            *c는 c의 다음 알파뱃으로 갱신
            */
            while(map.containsKey(w+c)){
            	w = w+c;
                i++;
                if (i == msg.length() - 1) {//마지막 글씨일 경우
                    c = ""; //c는 빈값으로
                    list.add(map.get(w)); //map에 등록된 색인번호를 list에 추가
                    break;
                }
                c = String.valueOf(msg.charAt(i+1));
            }
			
            //map에 w+c가 없다면
            if(!map.containsKey(w+c)){ 
                list.add(map.get(w)); //map에 등록된 색인번호를 list에 추가
                map.put(w+c,map.size()+1); //key에 w+c 추가 value에 색인번호 추가
            }
        }
        return list;
    }

}
