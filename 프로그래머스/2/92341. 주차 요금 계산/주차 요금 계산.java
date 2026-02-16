import java.util.*;
class Solution {
    Map<String, String> incars; // 차량별 입차시간 기록
    Map<String, Integer> stayingTimes;   // 출차 차량 최종 요금 기록
    public int[] solution(int[] fees, String[] records) {
        incars = new HashMap<>();
        stayingTimes = new TreeMap<>();
        // 기록 처리
        for (String record : records) {
            treatRecord(record, fees);
        }
        
        // 미출차 차량 처리
        for (String key : incars.keySet()) {
            stayingTimes.put(key, stayingTimes.getOrDefault(key, 0)+(convertToMinute("23:59")-convertToMinute(incars.get(key))));
        }
        
        // 반환 자료형 변환
        int[] answer = new int[stayingTimes.keySet().size()];
        int idx = 0;
        for (String key : stayingTimes.keySet()) {
            answer[idx++] = calFee(stayingTimes.get(key), fees);
        }
        return answer;
    }
    public void treatRecord(String record, int[] fees) {
        String[] splitedRecord = record.split(" ");
        String time = splitedRecord[0];
        String num = splitedRecord[1];
        String type = splitedRecord[2];
        
        // 입차 기록
        if (type.equals("IN")) {
            incars.put(num, time);
        }
        // 출차 계산
        else {
            stayingTimes.put(num, stayingTimes.getOrDefault(num, 0)+(convertToMinute(time)-convertToMinute(incars.get(num))));
            // 입차기록 제거
            incars.remove(num);
        }
    }
    public int calFee(int timeTaken, int[] fees) {
        timeTaken -= fees[0];
        
        int res = fees[1];
        // 기본시간 이내이면 기본요금만 청구
        if (timeTaken <= 0) return res;
        int unitTime = timeTaken%fees[2]==0 ? timeTaken/fees[2] : timeTaken/fees[2]+1;
        res += unitTime * fees[3];
        return res;
    }
    public int convertToMinute(String input) {
        String[] time = input.split(":");
        return 60*Integer.parseInt(time[0])+Integer.parseInt(time[1]);
    }
}