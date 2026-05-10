import java.util.*;

class Solution {
    int[] A = {1, 2, 3, 4, 5};
    int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int aLen, bLen, cLen, aCnt, bCnt, cCnt;
    public int[] solution(int[] answers) {
        aLen = A.length;
        bLen = B.length;
        cLen = C.length;
        aCnt = 0; bCnt = 0; cCnt = 0;
        
        for (int i=0; i<answers.length; i++) {
            int answer = answers[i];
            if (answer==A[i%aLen]) aCnt++;
            if (answer==B[i%bLen]) bCnt++;
            if (answer==C[i%cLen]) cCnt++;
        }
        
        int max = Math.max(aCnt, Math.max(bCnt, cCnt));
        List<Integer> res = new ArrayList<>();
        if (aCnt==max) res.add(1);
        if (bCnt==max) res.add(2);
        if (cCnt==max) res.add(3);
        
        int[] answer = new int[res.size()];
        for (int i=0; i<answer.length;i++) {
            answer[i] = res.get(i);
        } 
        return answer;
    }
}