import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10825 {
    private static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;
        
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        
        @Override
        public String toString() {
            return name;
        }
        
        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                // 국어점수가 같으면
                if (this.english == o.english) {
                    // 영어점수도 같으면
                    if (this.math == o.math) {
                        // 모든 점수가 같으면
                        
                        return this.name.compareTo(o.name);
                    }
                    // 수학점수가 감소하는 순서로
                    return o.math - this.math;
                }
                
                
                // 영어 점수가 증가하는 순서로
                return this.english - o.english;
            }
            // 국어 점수가 감소하는 순서로
            return o.korean - this.korean;
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, korean, english, math);
        }
        
        Arrays.sort(students);
        
        var sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
