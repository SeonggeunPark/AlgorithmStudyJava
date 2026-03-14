import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalW = sc.nextInt();
        int totalH = sc.nextInt();

        List<Integer> widths = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();

        widths.add(0);
        widths.add(totalW);
        heights.add(0);
        heights.add(totalH);

        int cutCount = sc.nextInt();
        for (int i = 0; i < cutCount; i++) {
            int direction = sc.nextInt(); 
            int pos = sc.nextInt();

            if (direction == 0) {
                heights.add(pos); 
            } else {
                widths.add(pos); 
            }
        }

        Collections.sort(widths);
        Collections.sort(heights);

        int maxW = 0;
        for (int i = 1; i < widths.size(); i++) {
            maxW = Math.max(maxW, widths.get(i) - widths.get(i - 1));
        }

        int maxH = 0;
        for (int i = 1; i < heights.size(); i++) {
            maxH = Math.max(maxH, heights.get(i) - heights.get(i - 1));
        }

        System.out.println(maxW * maxH);

    }
}