class Solution {
    public int[] solution(int n, int s) {
        int share = s/n;
        if (share <= 0) return new int[] {-1};
        
        int[] answer = new int[n];
        int remain = s%n;
        for (int i=n-1; i>=0; i--){
            if (remain >0) {
                answer[i] = share+1;
                remain-=1;
            } else {
                answer[i] = share;
            }
        }
        
        return answer;
    }
}