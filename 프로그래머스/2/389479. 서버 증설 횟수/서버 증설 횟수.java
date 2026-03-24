import java.util.*;
/*
증설 횟수 변수, 현재 증설 서버 수 변수 관리
*/

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int curServer = 0;
        int curCnt = 0;
        int[] ds = new int[24]; // 시간대별 서버 증감 여부 체크
        for (int i=0; i<24; i++) {
            int player = players[i];
            curServer += ds[i];
            // 증설 필요한지 여부 체크
            if (player/m <= curServer) continue;
            
            int need = player/m-curServer; // 증설 필요 서버 수
            curServer += need;  // 증설
            if (i+k < 24) {
                ds[i+k] = -need;  // 서버 회수 시점 기록
            }
            answer += need;
        }
        return answer;
    }
}