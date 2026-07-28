import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int s = 0;
        int e = people.length-1;
        int answer = 0;
        while (s<=e) {
            if (people[s]+people[e]<=limit) {
                s+=1;
            }
            e-=1;
            answer+=1;
        }
        return s==e?answer+1:answer;
    }
}