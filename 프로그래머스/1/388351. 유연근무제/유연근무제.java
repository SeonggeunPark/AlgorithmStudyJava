class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            // 희망 출근 시간 + 10분 처리
            int baseHour = schedules[i] / 100;
            int baseMin = schedules[i] % 100;
            baseMin += 10;
            if (baseMin >= 60) {
                baseHour += 1;
                baseMin -= 60;
            }
            int limit = baseHour * 100 + baseMin; // 예: 710, 1008 등

            boolean ok = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7; // 0 ~ 6
                // 0:월 ... 4:금, 5:토, 6:일
                if (day >= 5) continue; // 토(5), 일(6)은 검사 안함

                // 실제 출근한 시각
                int actual = timelogs[i][j];
                if (actual > limit) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }

        return answer;
    }
}
