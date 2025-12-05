import java.util.*;
/*
시작, 끝 인덱스 선택.
1. 시작 고정. 끝 인덱스 한칸씩 이동
    - 모든 종류가 걸릴 때까지
2. 끝 인덱스 고정. 시작 인덱스 한칸씩 이동
    - 모든 종류가 안걸릴 때까지
    - 종료 시 다시 시작 인덱스를 끝 인덱스 + 1로 초기화 후 다시 1번 작업
*/

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // 보석 종류별 존재 여부 체크용 
        Map<String, Integer> gemCheck = new HashMap<>();        
        for (String gem : gems) {
            gemCheck.put(gem, 0);
        }
        int maxHold = gemCheck.keySet().size();
        int curSize = gems.length;
        int s = gems.length-1;
        int e = gems.length-1;
        int holdCnt = 0;
        
        while (e>=0 && s>=0) {
            while (e>=0 && holdCnt<maxHold) {
                String gem = gems[e];
                // 갖고 있지 않은 보석일 경우
                if (gemCheck.get(gem)<=0) {
                    holdCnt+=1;
                }
                gemCheck.put(gem, gemCheck.get(gem)+1);
                e-=1;
            }
            
            // 2
            while (s>=gemCheck.keySet().size()-1 && holdCnt >= maxHold) {
                // 최소값 체크
                if (s-e <= curSize) {
                    curSize = s-e;
                    answer[0]=e+2;
                    answer[1]=s+1;
                }
                
                String gem = gems[s];
                gemCheck.put(gem, gemCheck.get(gem)-1);
                s-=1;
                
                // 모든 보석을 소유하지 않게 될 경우
                if (gemCheck.get(gem)<=0) {
                    holdCnt-=1;
                    break;
                }
            }
        }
        return answer;
    }
}