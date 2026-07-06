import java.util.*;

class Solution {
    public class Job implements Comparable<Job> {
        int n, rt, tt;
        public Job(int n, int rt, int tt) {
            this.n = n;
            this.rt = rt;
            this.tt= tt;
        }
        @Override
        public int compareTo(Job o) {
            if (o.tt == this.tt) {
                if (o.rt == this.rt) {
                    return this.n - o.n;
                }
                return this.rt - o.rt;
            }
            return this.tt - o.tt;
        }
    } 
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        // 1. 시작순서대로 job 정렬
        Job[] jobArr = new Job[len];
        for (int i=0; i<len; i++) {
            jobArr[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(jobArr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.rt - o2.rt;
            }
        });

        // 2. job 순차처리
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int idx = 0;
        int time = 0;
        int cnt = 0;
        // 이벤트단위 점프: (1) 현재 작업 종료, (2) 다음 작업 삽입
        while (cnt < len) {
            // 대기큐 삽입
            while (idx<len && jobArr[idx].rt<=time) {
                pq.offer(jobArr[idx++]);
            }
            
            // 대기큐에 작업 없으면 다음 작업 시작시간까지 시간 경과
            if (pq.isEmpty()) {
                time = jobArr[idx].rt;
                continue;
            }
            
            // 작업 시작
            Job curJob = pq.poll();
            answer += (time+curJob.tt)-curJob.rt;
            cnt+=1;
            time += curJob.tt;
        }
        
        return answer/len;
    }
}