import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 배열 추출하기
        s = s.substring(1,s.length()-1);
        List<List<Integer>> set = new ArrayList<>();
        
        int idx = 0;
        String tmp = "";
        // 각 집합을 배열에 담고 길이 기준 오름차순 정렬
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='{') {
                set.add(new ArrayList<>());
            } else if (c=='}') {
                set.get(idx++).add(Integer.parseInt(tmp));
                i+=1;
                tmp = "";
            } else if (c==','){
                set.get(idx).add(Integer.parseInt(tmp));
                tmp = "";
            } else {
                tmp+=c;
            }
        }
        // 길이순 정렬
        Collections.sort(set, (o1, o2) -> {
            return o1.size() - o2.size();
        });
        
        int[] answer = new int[set.size()];
        Map<Integer, Boolean> fixed = new HashMap<>();
        for (int i=0; i<set.size(); i++) {
            // 확정되지 않은 원소를 해당 인덱스로 확정
            for (int num : set.get(i)) {
                if (fixed.get(num)==null) {
                    fixed.put(num, true);
                    answer[i] = num;
                    break;
                }
            }
        }
        return answer;
    }
}