import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         // 선수 수
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            char firstChar = name.charAt(0); // 성 (첫 글자)
            map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
        }

        List<Character> result = new ArrayList<>();
        for (char key : map.keySet()) {
            if (map.get(key) >= 5) {
                result.add(key);
            }
        }

        if (result.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            Collections.sort(result); // 알파벳 순 정렬
            for (char c : result) {
                System.out.print(c);
            }
        }
    }
}
