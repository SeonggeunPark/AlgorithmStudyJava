import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }

        Map<String, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);
        }

        if (isMatch(targetMap, currentMap)) answer++;

        for (int i = 10; i < discount.length; i++) {
            // 이전 윈도우의 첫 번째 요소 제거
            String removeKey = discount[i - 10];
            currentMap.put(removeKey, currentMap.get(removeKey) - 1);
            if (currentMap.get(removeKey) == 0) currentMap.remove(removeKey);

            // 새로운 요소 추가
            String addKey = discount[i];
            currentMap.put(addKey, currentMap.getOrDefault(addKey, 0) + 1);

            if (isMatch(targetMap, currentMap)) answer++;
        }

        return answer;
    }

    private boolean isMatch(Map<String, Integer> target, Map<String, Integer> current) {
        for (String key : target.keySet()) {
            if (!current.getOrDefault(key, 0).equals(target.get(key))) {
                return false;
            }
        }
        return true;
    }
}