package level1.test61;

import java.util.*;

/*전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        int left = 10;
        int right = 12;
        for(int n : numbers){
            if(n%3 == 1) {
               answer.append("L");
               left = n; 
            }else if(n%3 == 0 && n != 0){
                answer.append("R");
                right = n;
            }else {
                if (n == 0) n = 11;
                int leftPosition = ((left - n)/3) + ((left - n)%3);
                int rightPosition = ((right - n)/3) + ((right - n)%3);
                leftPosition *= leftPosition < 0 ? -1 : 1;
                rightPosition *= rightPosition < 0 ? -1 : 1;
            if(leftPosition > rightPosition){
                answer.append("R");
                right = n;
            }else if(leftPosition < rightPosition){
                answer.append("L");
                left = n;
            }else if (leftPosition == rightPosition){
                if(hand.contains("right")){
                    answer.append("R");
                    right = n;
                }else if (hand.contains("left")){
                    answer.append("L");
                    left = n;
                }
            }
            }           
        }
        return answer.toString();
    }
}

class Solution2 { // 리팩토링 코드
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10; //*의 자리는 10으로
        int right = 12; // #의 자리는 12로
        
        for(int n : numbers){//해당 문제는 index가 따로 필요없으므로 forEach를 사용한다
            if(n == 0) n = 11; // 0의 자리는 11로
            
            /*
             * 조건이 많은 경우에는 switch문을 사용하는 것이 if문을 사용하는 것보다 더 좋다고 할 수 있다.
             * if문은 if를 만날때마다 조건문을 만족하는지 인트럭션이 필요하지만 switch문은 처음 입력값을 확인하는 인터럭션만 필요하고 조건을 확인할 때는 인터럭션이 필요하지 않다.
             */
            
            switch (n%3){// 나머지가 0인경우는 RightNum / 나머지가 1인경우 LeftNum / 나머지가 2인경우는 MiddleNum를 말한다                    
                case 0 : {
                    answer.append("R");
                    right = n;
                    break;
                }
                    
                case 1 : {
                    answer.append("L");
                    left = n;
                    break;
                }    
                    
                case 2 : {
                    int leftPosition = Math.abs(((left - n) / 3)+((left - n) % 3)); //현재 자리에서 이동할 자리까지 거리를 나타낸다 
                    int rightPosition = Math.abs(((right - n) / 3) + ((right - n) % 3)); // Math.abs()메서드를 활용하여 무조건 양수로 표현한다.
                    if(leftPosition > rightPosition){ // left가 right보다 이동거리가 멀때
                        answer.append("R");
                        right = n;
                    }else if(leftPosition < rightPosition){// right가 left보다 이동거리가 멀때
                        answer.append("L");
                        left = n;
                    }else if(hand.contains("right")){ //이외의 두수가 같을때는 hans를 이용하여 왼,오른 손잡이를 구별하여 추가
                        answer.append("R");
                        right = n;
                    }else {
                        answer.append("L");
                        left = n;
                    }
                    break;
                }    
            }
        }
        return answer.toString();
    }
}
