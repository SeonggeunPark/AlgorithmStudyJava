class Solution {
    public int solution(int[] sticker) {
        int len = sticker.length;
        if (len == 1) return sticker[0]; // 길이 1 예외 처리

        int[] dp1 = new int[len]; // 첫 번째 스티커를 반드시 떼는 경우
        int[] dp2 = new int[len]; // 첫 번째 스티커를 안 떼는 경우

        dp1[0] = sticker[0]; // 첫 번째는 무조건 사용
        dp2[0] = 0;          // 첫 번째는 사용하지 않음

        for (int i = 1; i <= len - 1; i++) {
            if (i == 1) {
                // dp1: 0번을 이미 떼었으니 1번은 못 뗌 → 그대로 유지
                dp1[i] = dp1[i-1];

                // dp2: 0번은 안 썼으니 1번을 쓸 수도 있음
                dp2[i] = Math.max(dp2[i-1], sticker[i]);
            }
            else if (i == len - 1) {
                // 마지막 스티커 처리
                // dp1: 첫 번째를 썼으니 마지막은 절대 못 씀
                dp1[i] = dp1[i-1];

                // dp2: 일반 직선 DP
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }
            else {
                // 중간 구간들은 일반 직선 DP
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }
        }

        // dp1은 len-2까지가 의미 있고, dp2는 len-1까지 의미 있음
        return Math.max(dp1[len-2], dp2[len-1]);
    }
}
