import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
        PriorityQueue<Integer> p1 = new PriorityQueue<Integer>();    
        PriorityQueue<Integer> p2 = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String com = st.nextToken();
            if (com.equals("I")) {
            	int n = Integer.parseInt(st.nextToken());
            	p1.offer(n);
            	p2.offer(n);
            } else {
            	if (p1.size()<=0) continue;
                if (Integer.parseInt(st.nextToken())==1) {
                	int poll = p2.poll();
                	p1.remove(poll);
                } else {
                	int poll = p1.poll();
                	p2.remove(poll);
                }
            }
        }
        int[] answer = {};
        if (p1.size()==0) {
        	answer = new int[] {0, 0};
        } else if (p1.size()<=1) {
            int n = p1.poll();
            answer = new int[] {n, n};
        } else {
        	answer = new int[] {p2.poll(), p1.poll()};
        }
        	
        return answer;
        
    }
}