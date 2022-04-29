public class prg_괄호변환 {
    public String solution(String p) {
        // step1. 조건(""이거나 이미 올바른 문자열이면)
        if (p.length() == 0 || isVps(p)) return p;
        StringBuilder answerSB = new StringBuilder();   // 메서드 내에 둬야한다.★
        // step2. 분리
        String[] separatedP = seperate(p);
        String first = separatedP[0];
        String sec = separatedP[1];

        // step3. if first is VPS? sec를 다시 분리해서 수행하고, first에 대해서는 answerSB에 저장.
        if (isVps(first)) {
            answerSB.append(first);
            // 재귀로 보낸 p의 first가 올바른 괄호 문자열이면 또 다시 그때의 sec를 재귀!
            answerSB.append(solution(sec));   // "덧붙인다"
        }
        // if no? start step 4
        else {
            answerSB.append('(');
            answerSB.append(solution(sec));
            answerSB.append(')');
            // first의 앞뒤문자 제거 & 괄호방향 뒤집 (리팩토링 후 8->4줄)
            for (int i=1; i< first.length()-1; i++) {
                if (first.charAt(i) == '(') answerSB.append(')');
                else answerSB.append('(');
            }
        }
        return answerSB.toString();
    }
    private boolean isVps(String str) {
        boolean isVps = true;
        int parenthesisCheck=0;
        for (int i=0; i<str.length(); i++) {
            if ('(' == str.charAt(i)) parenthesisCheck++;
            else parenthesisCheck--;
            if (parenthesisCheck<0) {
                isVps=false;
                break;
            }
        }
        return isVps;
    }
    private String[] seperate(String p) {
        int parenthesisCheck=0;
        String first = "";
        String sec = "";
        for (int i=0; i<p.length(); i++) {
            if ('(' == p.charAt(i)) parenthesisCheck++;
            else parenthesisCheck--;
            if (parenthesisCheck==0) {
                first = p.substring(0, i+1);
                if (p.length() == i+1) sec="";
                else sec = p.substring(i+1, p.length());
                break;
            }
        }
        return new String[]{first, sec};
    }
    public static void main(String[] args) {
        prg_괄호변환 t = new prg_괄호변환();
        String solution = t.solution("(()())()");
        String solution1 = t.solution(")(");
        String solution2 = t.solution("()))((()");

        System.out.println(solution);
        System.out.println(solution1);
        System.out.println(solution2);
    }
}
