package level2.test36;
import java.util.*;

/* 
주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
 */
class Solution {
    public int[] solution(int[] fees, String[] records) {                
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> timeMap = new TreeMap<>();
        StringTokenizer st;

        for(String num : records){
            st = new StringTokenizer(num);
            String time = st.nextToken();
            String carNumber = st.nextToken();
            String state = st.nextToken();

            if(state.equals("IN")){
                map.put(carNumber,time);
            }else {
                int stateTime = getStateTime(map.get(carNumber),time);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber,0) + stateTime);
                map.remove(carNumber);
            }            
        }    

        for(String carNumber : map.keySet()){
            int stateTime = getStateTime(map.get(carNumber),"23:59");
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber,0) + stateTime);
        }

        int[] answer = new int[timeMap.size()];
        int index = 0;
        for(String carNumber : timeMap.keySet()){ 
            answer[index] = getPrice(timeMap.get(carNumber),fees);  
            index++;
        }       

        return answer;
    }

    private static int getStateTime(String inTime , String outTime){
        StringTokenizer st = new StringTokenizer(inTime,":");
        int inNum = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(outTime,":");
        int outNum = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        return outNum - inNum;
    }

    private static int getPrice(int time, int[] fees){
        if(time <= fees[0]) {
            return fees[1];
        }
        int price = fees[1] + (int)Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
        
        return price;
    }
}
