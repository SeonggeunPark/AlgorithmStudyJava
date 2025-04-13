import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            suffixes.add(s.substring(i));
        }

        Collections.sort(suffixes);

        for (String suffix : suffixes) {
            System.out.println(suffix);
        }
    }
}
