package Implementation.String;
// IDE없이 1h..
public class prg_문자열압축 {
    public static int solution(String s) {
        int strLen = s.length();
        int answer = strLen;
        if (strLen == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int size = 1; size <= strLen/2; size++) {
            int remainStrLen = strLen % size;
            int lastCursor = strLen - remainStrLen - size*2;
            int duplCnt = 1;
            sb.setLength(0);
            // 커서
            for (int cursor = 0; cursor<=lastCursor; cursor+=size) {
                String now = s.substring(cursor, cursor+size);
                String next = s.substring(cursor+size, cursor+2*size);
                // System.out.println("비교1:"+ now+ ", 비교2:"+next);
                if (now.equals(next)) {
                    duplCnt++;
                    if (cursor == lastCursor) sb.append(duplCnt).append(now);
                } else {
                    if (duplCnt>1) {
                        sb.append(duplCnt);
                    }
                    sb.append(now);
                    if (cursor == lastCursor) sb.append(next);
                    duplCnt = 1;
                }
            }
            // System.out.println(sb);
            int totalLen = sb.length() + (remainStrLen>0? remainStrLen : 0);
            answer = Math.min(totalLen, answer);
        }
        return answer;
    }
}