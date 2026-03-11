import java.util.*;
/*
최악의 경우 : 396*10000 = 3,960,000

모든 쿼리에 대해
1. 회전
2. 최소값 기록
*/
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 행렬 생성
        int[][] matrix = new int[rows+1][columns+1];
        int num = 1;
        for (int r=1; r<rows+1; r++ ) {
            for (int c=1; c<columns+1; c++) {
                matrix[r][c] = num++;
            }
        }
        
        // 쿼리 순회하며 작업
        for (int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            
            // 회전
            answer[i] = rotate(query[0], query[1], query[2], query[3], matrix);
        }
        
        return answer;
    }
    public int rotate(int x1, int y1, int x2, int y2, int[][] matrix) {
        int tmp = matrix[x1][y1];
        int min = tmp;
        for (int x=x1; x<x2; x++) {
            min = Math.min(min, matrix[x+1][y1]);
            matrix[x][y1] = matrix[x+1][y1];
        }
        for (int y=y1; y<y2; y++) {
            min = Math.min(min, matrix[x2][y+1]);
            matrix[x2][y] = matrix[x2][y+1];
        }
        for (int x=x2; x>x1; x--) {
            min = Math.min(min, matrix[x-1][y2]);
            matrix[x][y2] = matrix[x-1][y2];
        }
        for (int y=y2; y>y1+1; y--) {
            min = Math.min(min, matrix[x1][y-1]);
            matrix[x1][y] = matrix[x1][y-1];
        }
        matrix[x1][y1+1] = tmp;
        
        return min;
    }
}