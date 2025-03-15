import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken()); // 집합 A 크기
        int bSize = Integer.parseInt(st.nextToken()); // 집합 B 크기

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> union = new HashSet<>(aSet);
        union.addAll(bSet); // A ∪ B

        Set<Integer> intersection = new HashSet<>(aSet);
        intersection.retainAll(bSet); // A ∩ B

        int symmetricDifferenceSize = union.size() - intersection.size();

        System.out.println(symmetricDifferenceSize);
    }
}
