import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int range = 1+2*w;
        int answer = 0;
        int prev = 0;
        for (int station : stations) {
            int distance = station-w-1-prev;
            int needs = 0;
            prev = station+w;
            if (distance <= 0) continue;
            if (distance % range == 0) {
                needs = distance/range;
            } else {
                needs = distance/range+1;
            }
            answer += needs;
        }
        if (prev < n) {
            int distance = n-prev;
            int needs = 0;
            if (distance % range == 0) {
                needs = distance/range;
            } else {
                needs = distance/range+1;
            }
            answer += needs;
        }

        return answer;
    }
}