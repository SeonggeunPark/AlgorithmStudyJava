import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> athletes = new HashMap<>();
        for (String p : participant) {
            athletes.put(p, athletes.getOrDefault(p, 0)+1);
        }
        for (String c : completion) {
            athletes.put(c, athletes.getOrDefault(c, 0)-1);
        }
        
        List<String> target = new ArrayList<>();
        for (String key : athletes.keySet()) {
            if (athletes.get(key) > 0) return key;
        }
        
        return "NONE";
    }
}