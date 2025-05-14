import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Balloon {
    int index;
    int move;

    Balloon(int index, int move) {
        this.index = index;
        this.move = move;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Balloon> balloons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int move = Integer.parseInt(st.nextToken());
            balloons.add(new Balloon(i + 1, move));
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (!balloons.isEmpty()) {
            Balloon current = balloons.remove(idx);
            sb.append(current.index).append(" ");
            
            if (balloons.isEmpty()) break;

            int move = current.move;

            // 이동은 현재 위치에서 시작하므로 다음 위치부터
            if (move > 0) {
                idx = (idx + (move - 1)) % balloons.size();
            } else {
                idx = (idx + move) % balloons.size();
                if (idx < 0) {
                    idx += balloons.size();  // 음수 인덱스 보정
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
