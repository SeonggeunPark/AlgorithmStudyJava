import java.util.*;
/*
흠... 어케풀지
끝점기준 오름차순, 앞에서부터 하나씩 끝점 찍고 아직 벗어나는 차들 차례로 찍기
*/

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        int answer = 1;
        int point = routes[0][1];
        for (int i=0; i<routes.length; i++) {
            // 설치지점이 범위에 걸리면 CCTV 설치 없이 패스
            if (routes[i][1]>=point && routes[i][0]<=point) 
                continue;
            
            point = routes[i][1];
            answer += 1;
        }
            
        return answer;
    }
}