import java.util.*;
/*
최소거리 d를 만들기 위해 지워야하는 바위의 최소 개수를 구해보기

2 11 14 17 21

d = 12
2 11 

*/
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 오름차순 정렬
        Arrays.sort(rocks);
        
        int answer = binarySearch(0, distance, rocks, n, -1, distance);
        
       
        return answer;
    }
    public int binarySearch(int start, int end, int[] rocks, int n, int answer, int distance) {
        if (start > end) {
            return answer;
        }
       int mid = (start+end)/2;
        
       boolean isPossible = check(mid, rocks, distance) <= n;
       if (isPossible) {
           answer = Math.max(answer, mid);
           return binarySearch(mid+1, end, rocks, n, answer, distance);
        } else {
           return binarySearch(start, mid-1, rocks, n, answer, distance);
       }
    }
    public int check(int d, int[] rocks, int distance) {
        int prevRock = 0; // 시작점부터 거리체크
        int idx = 0;
        int removeCnt = 0;
        while (idx<rocks.length) {
            int diff = rocks[idx]-prevRock;
            // 주어진 최소거리보다 작으면 제거
            if (diff < d) {
                removeCnt += 1;
            } else {
                prevRock = rocks[idx];
            }
            idx += 1;
        }
        // 마지막 돌 체크
        int diff = distance-prevRock;
        if (diff < d) {
            removeCnt += 1;
        }
        
        return removeCnt;
    }     
}