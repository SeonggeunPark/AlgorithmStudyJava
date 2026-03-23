import java.util.*;

class Solution {
    char[] opts;
    List<Long> operands; // 피연산자
    List<Character> operators; // 연산자
    long max = 0;
    public long solution(String expression) {
        Set<Character> optSet = new HashSet<>();
        // 연산자, 피연산자 분리
        treatExp(expression, optSet);
        
        opts = new char[optSet.size()];
        int index = 0;
        for (Character c : optSet) {
            opts[index++] = c; 
        }
        
        // 연산자 조합 추출 & 연산
        boolean[] visited = new boolean[opts.length];
        int[] pick = new int[opts.length];
        permutate(0, visited, pick);
        
        return max;
    }
    public void permutate(int idx, boolean[] visited, int[] pick) {
        if (idx >= opts.length) {
            // 계산
            max = Math.max(max, Math.abs(cal(pick)));
            return;
        }
        
        for (int i=0; i<opts.length; i++) {
            if (visited[i]) continue;
            pick[idx] = i;
            visited[i] = true;
            permutate(idx+1, visited, pick);
            visited[i] = false;
        }
    }
    public long cal(int[] pick) {
        // 계산을 위한 임시 복사
        List<Long> tmpOpds = new ArrayList<>(operands);
        List<Character> tmpOpts = new ArrayList<>(operators);
        
        for (int optIdx : pick) {
            char opt = opts[optIdx];
            // 해당 연산자 먼저 계산
            for (int i=0; i<tmpOpts.size(); i++) {
                if (tmpOpts.get(i)!=opt) continue;
                
                long opd1 = tmpOpds.get(i);
                long opd2 = tmpOpds.get(i+1);
                long res = 0;
                switch (opt) {
                    case '+' :
                        res = opd1+opd2;
                        break;
                    case '-' :
                        res = opd1-opd2;
                        break;
                    case '*' :
                        res = opd1*opd2;
                        break;
                    default :
                        break;
                }
                
                tmpOpds.set(i, res);
                tmpOpds.remove(i+1);
                tmpOpts.remove(i);
                i-=1;
            }
        }
        
        return tmpOpds.get(0);
    }
    // 연산자, 피연산자 분리 추출
    public void treatExp(String exp, Set<Character> optSet) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);
            if (c>='0' && c<='9') {
                sb.append(c);
            }
            else {
                operands.add(Long.parseLong(sb.toString()));
                operators.add(c);
                optSet.add(c);
                sb.setLength(0);
            }
        }
        operands.add(Long.parseLong(sb.toString()));
    }
}