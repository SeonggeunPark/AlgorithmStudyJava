import java.util.*;
import java.io.*;

class Solution {
	static HashMap<String, ArrayList<Integer>> adjMap;
	static Ticket[] myTickets;
    static boolean[] visited;
	static String[] ans;
    // static boolean flag;
    
	class Ticket implements Comparable<Ticket> {
		String start;
		String end;
		
		Ticket(String start, String end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Ticket o) {
			return this.end.compareTo(o.end);
		}
	}
	
	
	
	public String[] solution(String[][] tickets) {
		ans = new String[tickets.length+1];
        
		// Ticket 객체화하여 배열에 저장
		myTickets = new Ticket[tickets.length];
		
		for (int i=0; i<tickets.length; i++) {
			myTickets[i] = new Ticket(tickets[i][0], tickets[i][1]);
		}
		
        // 오름차순정렬 
		Arrays.sort(myTickets);
		
        // Map으로 빠른 접근 유도하도록 인덱싱
        adjMap = new HashMap<>();
        for (int i=0; i<tickets.length; i++) {
            Ticket t = myTickets[i];
            if (adjMap.get(t.start) == null) {
                adjMap.put(t.start, new ArrayList());
                adjMap.get(t.start).add(i);
            } else {
                adjMap.get(t.start).add(i);
            }
        }
        
        // 티켓 사용 여부 확인 위한 방문배열 선언
        visited = new boolean[tickets.length];
        
        // ICN부터 탐색 시작
        ans[0] = "ICN";
        DFS("ICN", 1);
		
		return ans;
	}
	
	boolean DFS(String start, int idx) {
        if (idx > visited.length) {
            // flag = true;
            return true;
        }
        
        if (adjMap.get(start)==null) return false;
        
		// 시작점 인접리스트 탐색
        for (int tIdx : adjMap.get(start)) {
            // if (flag) return;
            if (visited[tIdx]) continue;
            
            // 경로 체크 후 dfs 탐색
            ans[idx] = myTickets[tIdx].end;
            visited[tIdx] = true;
            
            if (DFS(myTickets[tIdx].end, idx+1)) return true;
            
            visited[tIdx] = false;
        }
        
        return false;
	}
}