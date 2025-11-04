import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remains = new int[progresses.length];
        for (int i=0; i<progresses.length; i++ ){
            int remain = 0;
            if ((100-progresses[i])%speeds[i] == 0) {
                remain = (100-progresses[i])/speeds[i];
            } else {
                remain = (100-progresses[i])/speeds[i] + 1;
            }
            remains[i]=remain;
        }
        List<Integer> tmpList = new ArrayList<Integer>();
        
        int time = 0;
        int cnt = 1;
        for (int i=0; i<remains.length; i++) {
            if (time < remains[i]) {
                if (i!=0) {
                    tmpList.add(cnt);
                }
                time = remains[i];
                cnt = 1;
            } else {
                cnt += 1;
            }
        }
        tmpList.add(cnt);
        
        int[] answer = new int[tmpList.size()];
        for (int i=0; i<tmpList.size(); i++) {
            answer[i] = tmpList.get(i);
        }
        return answer;
    }
}