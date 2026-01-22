import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        List<String> cache = new ArrayList<>();
        int answer = 0;
        
        out: 
        for (String city: cities) {
            String treated = city.toLowerCase();
            // 캐시에서 우선 탐색
            for (int i=cache.size()-1; i>=0; i--) {
                String cur = cache.get(i);
                if (cur.equals(treated)) {
                    answer += 1;
                    cache.remove(i);
                    cache.add(treated);
                    continue out;
                }
            }
            answer += 5;
            if (cache.size() >= cacheSize) {
                cache.remove(0);
            } 
            cache.add(treated);
        }
        
        return answer;
    }
}