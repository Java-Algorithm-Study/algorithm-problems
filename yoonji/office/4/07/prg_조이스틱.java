import static java.lang.Math.min;

public class prg_조이스틱 {
    public static void main(String[] args) {
        prg_조이스틱 t = new prg_조이스틱();
        int ret = t.solution("JAN");
        System.out.println(ret);
    }
    public int solution(String name) {
        int answer = 0;
        // 상하
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            // A인지 체크
            if (ch != 'A') {
                answer+= min(ch - 'A', Math.abs('Z' - ch) + 1); // Z=26
            }
        }
        // 좌우
//        int stright = name.length()-1;
        int move = 0;
        for (int i=0; i<name.length()-1; i++) {
            char ch = name.charAt(i);
            int idx = i+1;
            // 'A'이면 while문 실행
            while (name.charAt(idx) == 'A') {
                idx+=1;
            }
            move += min(idx-i, i + 1 + (name.length() - idx));
        }
        return answer+move;
    }
}