import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // A, B 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        
        // A의 원소보다 큰 수 중 가장 작은 수를 뽑기
        int bIdx = 0;
        for (int a : A) {
            while (bIdx<B.length && a >= B[bIdx]) {
                bIdx+=1;
            }
            if (bIdx >= B.length) break;
            else {
                answer += 1;
                bIdx+=1;
            }
        }
        return answer;
    }
}