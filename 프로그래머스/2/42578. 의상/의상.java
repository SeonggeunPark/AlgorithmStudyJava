import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cs : clothes) {
            String type = cs[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        int answer = 1;
        for (String type : map.keySet()) {
            answer *= (map.get(type)+1);
        }
        
        return answer -1;
    }
}