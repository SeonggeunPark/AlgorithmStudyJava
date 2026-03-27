import java.util.*;

/*
롤케이크 자르기: O(N) 탐색
배열을 이용한 빈도수 관리로 시간 복잡도 최적화
*/
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        // 토핑의 종류는 최대 10,000까지 가능
        int[] leftCount = new int[10001];
        int[] rightCount = new int[10001];
        
        int leftType = 0;
        int rightType = 0;

        // 1. 초기화: 동생이 모든 토핑을 다 가진 상태
        for (int t : topping) {
            if (rightCount[t] == 0) rightType++;
            rightCount[t]++;
        }

        // 2. 형에게 하나씩 넘겨주며 비교
        for (int i = 0; i < n; i++) {
            int t = topping[i];

            // 형(left)에게 토핑 추가
            if (leftCount[t] == 0) leftType++;
            leftCount[t]++;

            // 동생(right)에게서 토핑 제거
            rightCount[t]--;
            if (rightCount[t] == 0) rightType--;

            // 3. 종류의 수가 같아지는 지점 체크
            if (leftType == rightType) {
                answer++;
            }
            
        }

        return answer;
    }
}