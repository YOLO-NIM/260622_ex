import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution01_1 {
    public int solution(String s) {
        // 숫자를 판정하는 것
        Set<String> set = new HashSet();
        set.add("0");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        // 글자 -> 숫자 변경
        Map<String, String> map = new HashMap();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        String answerStr = "";
        String tmp = "";
        for (String v : s.split("")) {
            if (set.contains(v)) {
                answerStr += v; // 그냥 숫자니까.
                continue;
            }
            tmp += v;
            if (map.containsKey(tmp)) {
                answerStr += map.get(tmp);
                tmp = ""; // 정확한 숫자가 한 번 감지되면 임시를 비워줌
            }
        }
        int answer = Integer.parseInt(answerStr);
        return answer;
    }
}
