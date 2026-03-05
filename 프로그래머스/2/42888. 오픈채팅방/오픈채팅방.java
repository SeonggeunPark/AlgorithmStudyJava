// Map을 통해 uid 저장
// 메세지 별도 관리. id와 입출력 여부 별도 저장
import java.util.*;

class Solution {
    Map<String, String> users;
    List<String[]> msgs;
    public String[] solution(String[] record) {
        users = new HashMap<>();
        msgs = new ArrayList<>();
        
        // 기록 처리
        for (String rec : record) {
            String[] com = rec.split(" ");
            treatRecord(com);
        }
        
        // 최종 메세지 반영
        String[] answer = new String[msgs.size()];
        int idx = 0;
        for (String[] msg : msgs) {
            answer[idx] = users.get(msg[0]);
            if (msg[1].equals("Enter")) {
                answer[idx]+="님이 들어왔습니다.";
            } else {
                answer[idx]+="님이 나갔습니다.";
            }
            idx+=1;
        }
        
        return answer;
    }
    public void treatRecord(String[] com) {
        // 입장
        // 1. 기존에 있던 유저인지 체크
        //  - 있으면 닉네임 변경
        //  - 없으면 새롭게 추가
        // 2. 메세지 추가
        if (com[0].equals("Enter")) {
            users.put(com[1], com[2]);
            msgs.add(new String[] {com[1], "Enter"});
        }
        // 퇴장
        // 1. 메세지 추가
        else if (com[0].equals("Leave")) {
            msgs.add(new String[]{com[1], "Leave"});
        }
        // 닉네임 변경
        // 1. 기존 유저 닉네임 수정
        else {
            users.put(com[1], com[2]);
        }
    }
}