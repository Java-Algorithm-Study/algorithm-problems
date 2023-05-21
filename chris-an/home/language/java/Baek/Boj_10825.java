package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10825
 * sorting - 국영수(10825)
 *
 */
public class Boj_10825 {

    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static int strToInt (String input) {
        return Integer.parseInt(input);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> list = new ArrayList<>();
        int N = strToInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), strToInt(st.nextToken()), strToInt(st.nextToken()), strToInt(st.nextToken())));
        }


        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.kor == o2.kor) {

                    if(o1.eng == o2.eng) {

                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }else {
                            return o2.math - o1.math;
                        }
                    }else{
                        return o1.eng - o2.eng;
                    }
                }else {
                    return o2.kor - o1.kor;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : list) {
            sb.append(student.name).append('\n');
        }
        System.out.println(sb);
    }
}
