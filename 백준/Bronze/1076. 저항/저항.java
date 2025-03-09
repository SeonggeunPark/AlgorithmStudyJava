import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> colorMap = new HashMap<>();
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", 
                           "blue", "violet", "grey", "white"};

        for (int i = 0; i < colors.length; i++) {
            colorMap.put(colors[i], i);
        }

        String first = sc.next();
        String second = sc.next();
        String third = sc.next();
        sc.close();

        int value = colorMap.get(first) * 10 + colorMap.get(second);
        long result = value * (long) Math.pow(10, colorMap.get(third));

        System.out.println(result);
    }
}
