class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = (brown+4)/2;
        int prod = brown+yellow;
        
        for (int w=prod; w>=0; w--) {
            if (prod%w!=0) continue;
            int h = prod/w;
            if (w+h==sum) return new int[]{w, h};
        }
            
        return null;        
    }
}