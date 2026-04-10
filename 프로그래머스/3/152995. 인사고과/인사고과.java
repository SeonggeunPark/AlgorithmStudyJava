import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];
        int answer = 1;
        Arrays.sort(scores, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]) {
                    return o2[1]-o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        
        int max = 0;
        int prev = -1;
        int tmpMax = 0;
        out:
        for(int i=0; i<scores.length; i++) {
            
            if (scores[i][0]>a && scores[i][1] > b) return -1;
            // 유효 체크
            if (prev != scores[i][0]) {
                max = Math.max(max, tmpMax);
                tmpMax = 0;
            }
            prev = scores[i][0];   
            
            if (scores[i][1] < max) continue;
            tmpMax = Math.max(tmpMax, scores[i][1]);
            if (scores[i][0]+scores[i][1] > a+b) answer+=1;
        }
        return answer;
    }
}