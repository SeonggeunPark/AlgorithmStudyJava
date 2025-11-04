import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int aIdx = 0;
        
        for (int[] com : commands) {
            int size = com[1]-com[0]+1;
            int[] tmp = new int[size];
            int tIdx=0;
            
            for (int i=com[0]-1; i<=com[1]-1; i++) {
                tmp[tIdx++] = array[i];
            }
            
            Arrays.sort(tmp);
            
            answer[aIdx++] = tmp[com[2]-1];
        }
        
        return answer;
    }
}