import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>() {
           @Override
            public int compare(String o1, String o2) {
                // if (o1.length() == o2.length()) {
                //     return Integer.parseInt(o1) - Integer.parseInt(o2);
                // }
                return o1.length() - o2.length();
            }
        });
        Map<String, Boolean> prefixes = new HashMap<>();
        for (String s : phone_book) {
            if (check(s, prefixes)) return false;
            prefixes.put(s, true);
        }
        
        return true;
    }
    public boolean check(String s, Map<String, Boolean> prefixes) {
        String candid = "";
        for (int i=0; i<s.length(); i++) {
            candid += s.charAt(i);
            if (prefixes.containsKey(candid)) return true;
        }
        return false;
    }
}