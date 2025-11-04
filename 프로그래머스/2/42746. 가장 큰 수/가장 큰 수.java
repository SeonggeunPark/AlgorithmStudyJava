import java.util.*;
class Solution {
    class Number implements Comparable<Number> {
        int idx;
        String val;
        Number(int idx, String val) {
            this.idx = idx;
            this.val = val+val+val;
        }
        @Override
        public int compareTo(Number o) {
            return o.val.compareTo(this.val);
        }
    }
    public String solution(int[] numbers) {
        Number[] sorted = new Number[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            sorted[i] = new Number(i, String.valueOf(numbers[i]));
        }
        
        Arrays.sort(sorted);
        
        String answer = "";
        for (int i=0; i<numbers.length; i++) {
            answer += numbers[sorted[i].idx];
        }
        
        if (answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}