import java.util.*;

class Solution {
    int max = 0;
    int[] lion = new int[11];
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        int appeach = 0;
        for (int i = 0; i < 11; i++) { 
            if (info[i] > 0) appeach += 10 - i;
        }

        dfs(0, n, 0, appeach, info);
        return answer;
    }

    public void dfs(int idx, int remain, int lScore, int aScore, int[] info) {
        if (idx == 11) {
            int diff = lScore - aScore;
            if (diff > 0 && diff >= max) {
                lion[10] += remain; // 남은 화살은 가장 낮은 점수인 0점에 몰아줌

                if (diff > max) {
                    max = diff;
                    answer = lion.clone();
                } else {
                    if (isBetter(lion)) answer = lion.clone();
                }
                lion[10] -= remain; 
            }
            return;
        }

        // 1. 해당 점수를 따는 경우
        int arrowsNeeded = info[idx] + 1;
        if (remain >= arrowsNeeded) {
            lion[idx] = arrowsNeeded;
            int nextAScore = (info[idx] > 0) ? aScore - (10 - idx) : aScore;
            dfs(idx + 1, remain - arrowsNeeded, lScore + (10 - idx), nextAScore, info);
            lion[idx] = 0; // 백트래킹
        }

        // 2. 해당 점수를 포기하는 경우
        dfs(idx + 1, remain, lScore, aScore, info);
    }

    private boolean isBetter(int[] current) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] > answer[i]) return true;
            if (current[i] < answer[i]) return false;
        }
        return false;
    }
}