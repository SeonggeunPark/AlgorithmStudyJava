class Solution {
    char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    boolean flag = false;

    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, word);
        return answer;
    }

    public void dfs(StringBuilder sb, String word) {
        if (flag) return;

        if (sb.length() > 0) {
            answer++; 
            if (sb.toString().equals(word)) {
                flag = true;
                return;
            }
        }

        if (sb.length() == 5) return; 

        for (int i = 0; i < 5; i++) {
            sb.append(alphabets[i]);
            dfs(sb, word);
            sb.setLength(sb.length() - 1);
        }
    }
}