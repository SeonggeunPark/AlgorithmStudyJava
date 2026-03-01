import java.util.*;

public class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int len = elements.length;
        int[] arr = new int[len*2-1];
        
        for (int i=0; i<len; i++) {
            arr[i] = elements[i];
            if (i<len-1) {
                arr[i+len] = elements[i];
            }
        }
        
        for (int i=0; i<len; i++) {
            int sum = 0;
            for (int j=i; j<i+len; j++) {
                sum += arr[j];
                sumSet.add(sum);
            }
        }

        return sumSet.size(); 
    }
} 