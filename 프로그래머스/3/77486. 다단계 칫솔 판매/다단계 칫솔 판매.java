import java.util.*;

class Solution {
    // enroll: 판매원 이름 배열 
    // referral: 부모 이름 배열
    // seller: 판매자 이름 배열
    // amount: 판매자별 판매량 배열
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 판매자 이름 별 인덱스 접근용  Map 선언
        Map<String, Integer> names = new HashMap<>();
        for (int i=0; i<enroll.length; i++) {
            names.put(enroll[i], i);
        }
        // 수익 누적 시작
        for (int i=0; i<seller.length; i++) {
            String name = seller[i]; // 판매자명
            int income = amount[i]*100; // 판매액
            
            // 부모가 더 없을때까지 타고 올라가며 판매액 분배
            while(!name.equals("-")) {
                int remain = income/10;
                // 10%가 1원을 넘지 않으면 본인이 모두 갖고 종료
                if (remain<=0) {
                    answer[names.get(name)]+=income;
                    break;
                }
                answer[names.get(name)]+=income-remain; // 수익 누적
                // 부모 이동
                income = remain; 
                name = referral[names.get(name)];
            }
        }
        
        return answer;
    }
}