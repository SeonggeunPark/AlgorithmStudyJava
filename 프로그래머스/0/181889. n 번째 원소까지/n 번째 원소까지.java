import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            lst.add(num_list[i]);
        }
        
        return lst.stream().mapToInt(i -> i).toArray();
    }
}