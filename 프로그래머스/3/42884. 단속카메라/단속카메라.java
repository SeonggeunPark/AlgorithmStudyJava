import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        
        int answer = 1;
        int prev = routes[0][1];
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0]>prev) {
                prev=routes[i][1];
                answer+=1;
            }
        }
        
        return answer;
    }
}