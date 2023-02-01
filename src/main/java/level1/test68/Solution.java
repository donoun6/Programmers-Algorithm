package level1.test68;

import java.util.*;

/*신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

유저 ID	유저가 신고한 ID	설명
"muzi"	"frodo"	"muzi"가 "frodo"를 신고했습니다.
"apeach"	"frodo"	"apeach"가 "frodo"를 신고했습니다.
"frodo"	"neo"	"frodo"가 "neo"를 신고했습니다.
"muzi"	"neo"	"muzi"가 "neo"를 신고했습니다.
"apeach"	"muzi"	"apeach"가 "muzi"를 신고했습니다.
각 유저별로 신고당한 횟수는 다음과 같습니다.

유저 ID	신고당한 횟수
"muzi"	1
"frodo"	2
"apeach"	0
"neo"	2
위 예시에서는 2번 이상 신고당한 "frodo"와 "neo"의 게시판 이용이 정지됩니다. 이때, 각 유저별로 신고한 아이디와 정지된 아이디를 정리하면 다음과 같습니다.

유저 ID	유저가 신고한 ID	정지된 ID
"muzi"	["frodo", "neo"]	["frodo", "neo"]
"frodo"	["neo"]	["neo"]
"apeach"	["muzi", "frodo"]	["frodo"]
"neo"	없음	없음
따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.

이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때, 
각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>(); //key = 신고자  value = 신고한 유저ID ex) {C=[B,A]} 의형태로 입력된다 B와 A는 C를 신고하였다
        Map<String, Integer> check = new HashMap<>(); //메일을 받을 Map이다
        
        for(String id : id_list){ //유저 목록 넣기
            map.put(id,new HashSet<>());
            check.put(id,0);
        }
        
        for(String reportUser : report){
            String id = reportUser.split(" ")[0]; //신고한놈
            String reportId = reportUser.split(" ")[1]; //신고당한놈
            map.get(reportId).add(id); //key에 신고당한놈 value에 한놈 value는 HashSet으로 인해 중복값이 안들어간다 결국 한놈이 같은놈을 여러번 신고해도 값은 하나만 들어간다.
        }
        
        
        for(String id : id_list){
            if(map.get(id).size() >= k ){ //유저목록을 key값으로 get하면 신고를 한사람 즉 신고 횟수를 알수있다 신고수가 k를 넘으면 그계정은 정지
                for(String mail : map.get(id)){ //정지 당한 계정을 신고한 고자질하는 놈들은 메일을 받아야하기 때문에 forEach를 사용
                    check.put(mail,check.get(mail)+1); //고자질한놈이 정지를 먹였을때 value값 증가
                }
            }
        }
        
        for(int i = 0; i < id_list.length; i++){
            answer[i] = check.get(id_list[i]);
        }
        
        return answer;
    }
}