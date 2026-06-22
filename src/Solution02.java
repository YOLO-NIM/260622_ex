public class Solution02 {
    public String solution(String s) {
        System.out.println("s = " + s);
        // 오답케이스
        // 첫 문자는 대문자화 하고, 나머지를 소문자로
//        for (char c : s.toCharArray()) {
        String answer = "";
//        for (int i = 0; i < s.length(); i++) {
        for (int i = 0, p = 0; i < s.length(); i++, p++) {
            char c = s.charAt(i);
            if (c == ' ') {
                p = -1;
                answer += " ";
                continue;
            }
//            if (i == 0) {
            if (p == 0) {
//                c = Character.toUpperCase(c); // toLowerCase
                if (c >= 'a' && c <= 'z') {
                    c = (char) (c - 32);
                }
//                System.out.println((int) 'A'); // 65
//                System.out.println((int) 'a'); // 97
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c + 32);
                }
            }
            answer += c;
//            System.out.println("c = " + c);
        }

//        return "";
        return answer;
    }

    public static void main(String[] args) {
        Solution02 sol = new Solution02();

        // [테스트 입력값, 기대되는 결과값]
        String[] testCases = {
                "3people unFollowed me",            // 1. 기본 케이스 1
                "for the last week",                // 2. 기본 케이스 2
                "3people  unFollowed   me",         // 3. 엣지: 연속된 공백 포함
                "for the last week ",               // 4. 엣지: 맨 마지막 문자가 공백
                "  for the last week",              // 5. 엣지: 맨 처음 문자가 공백
                "a",                                // 6. 엣지: 길이가 1인 문자열 (소문자)
                "A",                                // 7. 엣지: 길이가 1인 문자열 (대문자)
                "5",                                // 8. 엣지: 길이가 1인 문자열 (숫자)
                "good   mornIng  EveryOne  ",       // 9. 엣지: 무작위 대소문자 + 다중 공백 + 끝 공백
                " "                                 // 10. 엣지: 공백 한 개만 있는 경우
        };

        String[] expected = {
                "3people Unfollowed Me",
                "For The Last Week",
                "3people  Unfollowed   Me",
                "For The Last Week ",
                "  For The Last Week",
                "A",
                "A",
                "5",
                "Good   Morning  Everyone  ",
                " "
        };

        System.out.println("====== JadenCase 테스트 시작 ======");
        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            String result = sol.solution(testCases[i]);
            if (result.equals(expected[i])) {
                System.out.printf("[Pass] Case %d%n", i + 1);
            } else {
                System.out.printf("[FAIL] Case %d%n", i + 1);
                System.out.printf("   - 입력값: \"%s\"%n", testCases[i]);
                System.out.printf("   - 기대값: \"%s\"%n", expected[i]);
                System.out.printf("   - 결과값: \"%s\"%n", result);
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("=> 모든 테스트 케이스를 통과했습니다!");
        }
    }
}
