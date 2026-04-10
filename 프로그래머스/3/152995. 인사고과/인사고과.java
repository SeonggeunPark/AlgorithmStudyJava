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
                    return o1[1]-o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        
        int max = 0;
        for (int[] score: scores) {
            if (a<score[0] && b<score[1]) return -1;
            if (score[1]<max) continue;
            if (score[0]+score[1] > a+b) answer+=1;
            max = Math.max(max,score[1]);
        }
        return answer;
    }
}