import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int len = numbers.length();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[len];

        countPrime(0, sb, numbers, visited, len);

        int answer = 0;

        for (int num : set) {
            if (checkPrime(num)) answer++;
        }

        return answer;
    }

    public void countPrime(int cnt, StringBuilder sb, String numbers, boolean[] visited, int len) {
        if (cnt >= len) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;

            sb.append(numbers.charAt(i));
            visited[i] = true;

            set.add(Integer.parseInt(sb.toString()));

            countPrime(cnt + 1, sb, numbers, visited, len);

            sb.setLength(sb.length() - 1);
            visited[i] = false;
        }
    }

    public boolean checkPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}