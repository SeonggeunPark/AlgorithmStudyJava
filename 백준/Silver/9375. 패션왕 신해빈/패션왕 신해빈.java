import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                String kind = sc.next();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }
            
            int result = 1;
            for (int cnt : map.values()) {
                result *= (cnt + 1);
            }
            System.out.println(result - 1);
        }
    }
}
