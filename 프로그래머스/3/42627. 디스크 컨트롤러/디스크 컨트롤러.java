import java.util.*;

/*
1. 대기큐에 뭐가 있으면 꺼내서 작업 수행
    - 소요시간 짧은순, 요청시간 빠른 순, 번호 작은 순
2. 작업 중간에 변경 X
3. 문맥교환 시간 소요 X
    - 작업 종료 - 새 작업 큐 삽입 - 큐에서 꺼내 새 작업 수행

*/
class Solution {
    public class Task implements Comparable<Task> {
        int num; // 번호
        int loadTime; // 소요시간
        int reqTime; // 요청시간
        int startTime; // 실제 작업 시작시간
        public Task (int num, int loadTime, int reqTime) {
            this.num = num;
            this.loadTime = loadTime;
            this.reqTime = reqTime;
            // this.startTime = startTime;
        }
        @Override
        public int compareTo (Task o) {
            if (this.loadTime==o.loadTime) {
                if (this.reqTime==o.reqTime) {
                    return this.num-o.num;
                }
                return this.reqTime-o.reqTime;
            }
            return this.loadTime-o.loadTime;
        }
    }
    public int solution(int[][] jobs) {
        // 우선순위 대기큐 생성
        PriorityQueue<Task> pq = new PriorityQueue<>();
        
        int[] result = new int[jobs.length];
        int rIdx = 0;
        int jIdx = 0;
        int time= 0;
        // 요청시각마다 요청 큐에 삽입
        // 종료시간마다 종료 태스크 기록(종료시각 - 요청시각)
        Arrays.sort(jobs, (o1, o2) -> {
           return o1[0] - o2[0]; 
        });
        
        // 체크 타이밍: 
        // 1. 진행중인 작업 끝날때
        // 2. 새 작업 추가해야할 때 (job[0])
        // 종료 타이밍: 추가할 작업이 없고, 진행중인 작업도 없을 때
        Task cur = null;
        while (cur!=null || jIdx < jobs.length) {
            // 다음 time으로 넘어가기 => 현재작업이 종료되는 시점 vs 다음 작업 삽입되는 시점 짧은것
            if (cur==null) {
                time = jobs[jIdx][0];
            } else if(jIdx >= jobs.length) {
                time = cur.startTime+cur.loadTime;
            } else {
                time = Math.min(jobs[jIdx][0], cur.startTime+cur.loadTime);
            }
            // System.out.println("현재시간 -> "+time );
            
            // 진행중 작업 체크
            if (cur!=null && cur.startTime+cur.loadTime == time) {
                result[rIdx++] = time-cur.reqTime;
                cur = null; // 작업 해제
            }
            
            // 새 작업 큐 삽입
            while (jIdx<jobs.length && jobs[jIdx][0] == time) {
                pq.offer(new Task(jIdx, jobs[jIdx][1], jobs[jIdx][0]));
                jIdx+=1;
            }
            
            // 작업중인 것이 없고, 대기큐에 뭔가 있으면 작업 시작
            if (cur==null && !pq.isEmpty()) {
                cur = pq.poll();
                cur.startTime=time;
            }
        }
        int sum = 0;
        for (int i=0; i<result.length; i++) {
            sum += result[i];
        }
        
        int answer = sum/result.length;
        return answer;
    }
}