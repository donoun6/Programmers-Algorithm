package level2.test32;
import java.util.*;

/* 
XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다. 
할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.

예를 들어, 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며, 
XYZ 마트에서 15일간 회원을 대상으로 할인하는 제품이 날짜 순서대로 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우에 대해 알아봅시다. 첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다. 둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다. 셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입을 하려 합니다.

정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오. 가능한 날이 없으면 0을 return 합니다.
 */
class Solution { 
    private static int answer = 0;
    public int solution(String[] want, int[] number, String[] discount) {       
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){ //원하는 장바구니 Map
            map.put(want[i],number[i]);
        }
                
        for(int i = 0; i <= discount.length-10; i++){ //마트에서의 10일
            check(map , cart(i,discount)); //함수호출
        }
        
        return answer;
    }
    
    // 10일간 담을수 있는 장바구니 Map
    private static Map<String,Integer> cart(int index,String[] discount){
        Map<String,Integer> map = new HashMap<>();
        for(int i = index; i < index+10; i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
        return map;
    }
    
    // 원하는 장바구니와 10일간 담을수 있는 장바구니를 비교하는 메서드
    private static void check(Map<String,Integer> want, Map<String,Integer> cart){
        for(String key : cart.keySet()){ //이것만 사용해도 된다.
            if(cart.get(key) != want.get(key)) {
                return;
            }
        }
        answer++;
    }
}
