package language.java.Baek;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Boj_1406 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        String str = br.readLine();

        // 저장
        for (int i = 0; i < str.length(); i++) {
            iter.add(str.charAt(i));
        }

        // 입력값
        int orderCnt = Integer.parseInt(br.readLine());

        // 로직

        while (orderCnt > 0) {
            String order = br.readLine();
            StringTokenizer st = new StringTokenizer(order, " ");
            switch (st.nextToken()) {
                case "L" :
                    if(iter.hasPrevious())
                        iter.previous();
                    break;

                case "D" :
                    if(iter.hasNext())
                        iter.next();
                    break;

                case "B" :
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;

                case "P" :
                    // 알파벳 문자 하나
                    char c = st.nextToken().charAt(0);
                    iter.add(c);
                    break;
            }
            orderCnt--;
        }

        // 출력값
        for (Character character : list) {
            bw.write(character);
        }
        bw.flush();
        bw.close();
    }
}


/*

    -> 시간초과 코드

    import java.io.*;
    import java.util.StringTokenizer;

        접근방법
        1. 명령어가 수행되기 전 커서는 문장 맨 뒤에 위치하고 있다. => 초기화할 때, N+1
        2. 초기에 편집기에 입력되어 있는 문자열이 주어짐 그 문자열에 삽입이 들어감 => List 자료구조 사용하기
        3. Scanner / BufferedReader  중 어떤 걸로 입력으로 사용할까? => 최대 입력 값은 60만 글자임. 따라서
            Scanner(1KB) 에 비해 더 큰 버퍼(8KB)를 사용하니, 긴 문자열에 포함된 파일을 읽을 시 효과적, 따라서 BufferedReader 로 먼저 사용.
        4. 담을 공간에 대해서 생각해보기 (String, StringBuffer/StringBuilder)  => 단일 쓰레드에 문자열 연산이 많을 수 있고, 특정 위치에 값을 삽입/삭제 가능한 API 존재.
            StringBuilder 사용.
                charAt() - 특정 인덱스 위치의 문자 반환
                indexOf() / lastIndexOf() - 문자열 검색해서 위치 반환
                length() - 문자열 길이 반환
                replace() - 검색된 문자열 교체
                substring() - 특정 인덱스 범위 내 문자열을 복사해서 새로 생성된 인스턴스 반환
                toString() - 문자열 출력
        입력 : 문자열 입력 -> 명령어의 개수(정수M) 입력 -> 명어의 개수만큼 명령어 입력



    public class Main {

        private int cursor;

        public Main1(int cursor) {
            this.cursor = cursor;
        }

        public void moveToTheLeft() {
            if (cursor > 0)
                cursor--;
        }

        public void moveToTheRight(int max) {
            if (cursor != max)
                cursor++;
        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringBuilder sb = new StringBuilder(br.readLine());
            Main1 mn = new Main1(sb.length());

            int orderCnt = Integer.parseInt(br.readLine());

            while (orderCnt > 0) {
                String order = br.readLine();
                StringTokenizer st = new StringTokenizer(order, " ");
                switch (st.nextToken()) {
                    case "L" :
                        mn.moveToTheLeft();
                        break;

                    case "D" :
                        mn.moveToTheRight(sb.length());
                        break;

                    case "B" :
                        if (mn.cursor != 0) {
                            sb.delete(mn.cursor - 1, mn.cursor);
                            mn.cursor--;
                        }
                        break;

                    case "P" :
                        sb.insert(mn.cursor++, st.nextToken());
                        break;
                }
                orderCnt--;
            }
            bw.write(sb.toString()+"\n");
            bw.close(); // 스트림을 닫음
        }
    }
*/