package level1.test50;

import java.util.*;

/*
 * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
 * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
 * 실패율은 다음과 같이 정의한다.
 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 */
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];       
        int[] stageCount = new int[N+2];
        int[] failRate = new int[N+1];
        HashMap<Integer,Double> map = new HashMap<>();
        
        for(int stage : stages){ //분자
            stageCount[stage]++;
        }
        
        int count = stages.length; //최대인원
        for(int i = 1; i < failRate.length; i++){ //분모    
            failRate[i] = count;
            count -= stageCount[i];
        }

        for(int i = 1; i < failRate.length; i++){
            if(failRate[i]==0 || stageCount[i]==0){
                map.put(i,0.0);
            }else {
                map.put(i,(double)stageCount[i]/failRate[i]);
            }            
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2)->Double.compare(map.get(o2),map.get(o1)));
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}


class Solution2 { //직접짠 코드
    public int[] solution(int N, int[] stages) {        
        int[] answer = new int[N];
        double people = stages.length;
        
        Arrays.sort(stages);
        
        HashMap<Integer,Double> hm = new HashMap<>();
        for(int i = 0; i < stages.length; i++){            
            if(hm.containsKey(stages[i]))hm.put(stages[i],hm.get(stages[i])+1);
            else hm.put(stages[i],(double)1);     
        }     
        
        double[][] rate = new double[N][2];
        for(int i = 0; i < N; i++){           
            if(hm.get(i+1) == null){
                rate[i][0] = 0;
                rate[i][1] = i+1;
            }
            else {
                rate[i][0] = hm.get(i+1)/people;
                rate[i][1] = i+1;
                people -= hm.get(i+1);
            }
        }

        Arrays.sort(rate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] == o2[0]){
                    return Double.compare(o1[1],o2[1]);
                }else {
                    return Double.compare(o2[0],o1[0]);
                }
            }
        });
        
        for(int i = 0; i < rate.length; i++){
            System.out.println(rate[i][0]+" "+rate[i][1]);
            answer[i] = (int) rate[i][1];
        }
        return answer;
    }
}