import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        Set<String> nohear = new HashSet<>(); // 듣도 못한 사람 저장
        List<String> ans = new ArrayList<>(); // 결과 저장 리스트
        
        for (int i = 0; i < N; i++) {
            nohear.add(sc.next()); // 듣도 못한 사람 Set에 추가
        }
        
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if (nohear.contains(str)) { // 보도 못한 사람 중 듣도 못한 사람 찾기
                ans.add(str);
            }
        }
        
        Collections.sort(ans); // 결과를 사전순으로 정렬
        System.out.println(ans.size()); // 듣보잡 수 출력
        for (String name : ans) {
            System.out.println(name); // 듣보잡 명단 출력
        }
        
        sc.close();
    }
}
