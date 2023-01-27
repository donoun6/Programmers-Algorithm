package level1.test56;

import java.util.*;

/*점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n];
        for(int i = 0; i < clothes.length; i++){
            clothes[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++){
            clothes[lost[i]-1] = 0;
        }
        
        for(int i = 0; i < reserve.length; i++){
            if(clothes[reserve[i]-1] == 0){
                clothes[reserve[i]-1] = 1;
            }else if(reserve[i] == 1) {
                if(clothes[reserve[i]] == 0){
                    clothes[reserve[i]] = 1;    
                }                
            }else if(reserve[i] == n) {
                if(clothes[reserve[i]-2] == 0){
                    clothes[reserve[i]-2] = 1;
                }             
            }else if(clothes[reserve[i]-2] == 0) {
                clothes[reserve[i]-2] = 1;
            }else if(clothes[reserve[i]] == 0) {
                clothes[reserve[i]] = 1;
            }
        }
        
        
        
        for(int num : clothes){
            if(num == 1){
                answer++;
            }
        }
        
        return answer;
    }
}

class Solution2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n]; //-1은 체육복이 없는 사람 0은 체육복이 있는사람 1은 여분이 있는 사람으로 나눈다
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) { //체육복이 없는사람일때
                if(i-1>=0 && people[i-1] == 1) { //index 오류가 나지않게 설정후 and조건을 활용하여 이전사람이 여분이있을때 조건을 단다
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {//이전사람이 여분이 없을때 뒷사람 여분을 확인 마찬가지로 index가 초과 되면 안되기때문에 조건을 더건다
                    people[i]++;
                    people[i+1]--;
                }else //아무것도 해당하지않고 체육복이 없으면 최대인원에서 빼준다
                    answer--;
            }
        }
        return answer;
    }
}