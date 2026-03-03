import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean[] hasSkill = new boolean[26];
        int[] parents = new int[26];
        Arrays.fill(parents, -1);
        for (int i=skill.length()-1; i>=1; i--) {
            char c = skill.charAt(i);
            char p = skill.charAt(i-1);
            parents[c-'A']=p-'A';
        }
        
        out:
        for (String tree : skill_trees) {
            Arrays.fill(hasSkill, false); // 방문체크 배열 초기화
            for (int i=0; i<tree.length(); i++) {
                char c = tree.charAt(i);
                // 부모가 있지만 부모 스킬을 안배웠다면 PASS
                if (parents[c-'A']!=-1 && !hasSkill[parents[c-'A']]) continue out;
                hasSkill[c-'A'] = true; // 방문 체크
            }
            answer += 1;
        }
        return answer;
    }
}