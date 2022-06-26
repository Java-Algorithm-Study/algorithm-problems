import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [10825] 국영수
 * https://www.acmicpc.net/problem/10825
 *
 * -아이디어
 * 1. 이름, 각 과목당 점수를 받아야 되니까 Class를 생성한다.
 * 2. 점수는 조건에 맞게 리턴문 선언한다.
 * 3. 이름은 String으로 사전순이니까 compareTo를 이용한다.
 *
 */

public class Boj10825 {
    static class Grade {
        String name;
        int korea;
        int english;
        int math;

        public Grade(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Grade> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = String.valueOf(st.nextToken());
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Grade(name, korea, english, math));
        }

        Comparator<Grade> gc = new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                if (o1.korea != o2.korea) {
                    return o2.korea - o1.korea;
                }
                else {
                    if (o1.english == o2.english) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.english - o2.english;
                }
            }
        };

        Collections.sort(students, gc);

        for (Grade g : students) {
            sb.append(g.name).append('\n');
        }

        System.out.println(sb);
    }
}
