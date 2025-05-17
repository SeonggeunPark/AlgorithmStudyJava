import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] origin = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		Stack<Character> st = new Stack<>();
		Stack<Integer> record   = new Stack<>();  // ⬅️ pIdx 기록용 스택
		
		int pIdx = 0;
		
		for (int i=0; i<origin.length; i++) {
            char c = origin[i];
            st.push(c);

            // 1) pIdx 갱신
            if (c == pattern[pIdx]) {
                pIdx++;
            } else {
                // 새로운 문자로부터 부분 매칭 시작 여부만 보고
                pIdx = (c == pattern[0]) ? 1 : 0;
            }
            
            // 2) record에도 현재 pIdx를 push
            record.push(pIdx);
            
            // 3) pIdx가 폭발문자열 길이와 같아지면 폭발
            if (pIdx == pattern.length) {
                // 스택과 record에서 패턴 길이만큼 pop
                for (int k = 0; k < pattern.length; k++) {
                    st.pop();
                    record.pop();
                }
                // 남은 스택 최상단의 pIdx로 복원
                pIdx = record.isEmpty() ? 0 : record.peek();
            }
		}
		
		if (st.isEmpty()) {
			System.out.println("FRULA");
		} else {
            StringBuilder sb = new StringBuilder();
            for (char ch : st) sb.append(ch);
            System.out.println(sb);
		}
	}
}