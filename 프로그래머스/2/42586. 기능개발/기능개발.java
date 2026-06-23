import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        int maxNeeds = 0;
        for (int i=0; i<progresses.length; i++) {
            int remain = 100-progresses[i];
            int needs = remain%speeds[i]==0 ? remain/speeds[i] :remain/speeds[i]+1;
            if (maxNeeds==0) {
                sum=1;
                maxNeeds=needs;
                continue;
            }
            if (maxNeeds >= needs) {
                sum+=1;
            } else {
                res.add(sum);
                sum=1;
                maxNeeds=needs;
            }
        }
        if (sum > 0) {
            res.add(sum);
        }
        
        int[] answer = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}