import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 버스 탑승시간 배열 (09:00 = 540)
        int[] bTime = new int[n];
        int[] cnts = new int[n];
        int min = 540;
        for (int i = 0; i < n; i++) {
            bTime[i] = min;
            min += t;
        }

        // timetable 오름차순 정렬
        Arrays.sort(timetable);

        int tIdx = 0;                
        int lastBoarded = -1;        

        for (int i = 0; i < n; i++) {
            while (tIdx < timetable.length && cnts[i] < m) { 
                int aTime = Integer.parseInt(timetable[tIdx].substring(0, 2)) * 60
                          + Integer.parseInt(timetable[tIdx].substring(3, 5)); 

                if (aTime > bTime[i]) break;

                cnts[i] += 1;       
                lastBoarded = aTime; 
                tIdx += 1;           
            }

            if (i == n - 1) {
                int res = (cnts[i] < m) ? bTime[i] : (lastBoarded - 1); 
                return toString(res / 60) + ":" + toString(res % 60); 
            }
        }

        return toString(bTime[n - 1] / 60) + ":" + toString(bTime[n - 1] % 60);
    }

    public String toString(int num) {
        String s = String.valueOf(num);
        if (s.length() >= 2) return s;
        return "0" + s;
    }
}
