import java.util.*;
// 서브트리 개수 계산, 차이의 최소값 저장
// 1이 루트노드라고 임의 지정
class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    int answer;
    public int solution(int n, int[][] wires) {
        adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] wire: wires ) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        answer = 100;
        visited = new boolean[n+1];
        
        countChilds(1, n);
        
        return answer;
    }
    public int countChilds(int root, int n) {
        visited[root] = true;
        int sum = 1;
        for (int child : adjList[root]) {
            if (visited[child]) continue;
            sum += countChilds(child, n);
        }
        answer = Math.min(answer, Math.abs(sum-(n-sum)));
        return sum;
    }
}