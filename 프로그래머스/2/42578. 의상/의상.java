import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류 이름: key, 해당 종류의 옷 개수: value
        Map<String, Integer> types = new HashMap<>();
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            types.put(type, types.getOrDefault(type,0)+1);
        }
        
        int answer = 1;
        for (String key : types.keySet()) {
            answer *= (types.get(key)+1);
        }        
        
        return answer-1;
    }
}