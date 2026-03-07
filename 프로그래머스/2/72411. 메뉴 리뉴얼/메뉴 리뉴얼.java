import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> ansList = new ArrayList<>(); // 최종 결과 저장

        // 1. 주문들을 비트마스크 배열로 미리 변환
        int[] orderMasks = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            orderMasks[i] = StringToInt(orders[i]);
        }

        // 개수별 체크
        for (int cSize : course) {
            Map<Integer, Integer> countMap = new HashMap<>(); // 조합별 등장 횟수
            int maxFreq = 0;

            // 2. 각 주문에서 해당 크기(cSize)의 모든 조합을 생성하여 카운팅
            for (int mask : orderMasks) {
                generateComb(0, 0, 0, cSize, mask, countMap);
            }

            // 3. 해당 크기에서 최대 빈도수(maxFreq) 찾기
            for (int count : countMap.values()) {
                maxFreq = Math.max(maxFreq, count);
            }

            // 4. 최소 2번 이상 등장했고, 최대 빈도와 일치하는 조합만 결과에 추가
            if (maxFreq >= 2) {
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() == maxFreq) {
                        ansList.add(IntToString(entry.getKey()));
                    }
                }
            }
        }

        // 결과 정렬 후 반환
        String[] answer = ansList.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    private void generateComb(int start, int current, int count, int k, int origin, Map<Integer, Integer> map) {
        if (count == k) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((origin & (1 << i)) != 0) {
                generateComb(i + 1, current | (1 << i), count + 1, k, origin, map);
            }
        }
    }

    public int StringToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res |= (1 << (c - 'A'));
        }
        return res;
    }

    public String IntToString(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) { 
            if ((n & (1 << i)) != 0) { 
                res.append((char) (i + 'A'));
            }
        }
        return res.toString();
    }
}