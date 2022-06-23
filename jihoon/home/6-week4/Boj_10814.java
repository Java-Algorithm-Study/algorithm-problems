import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10814 {
    private static class Person implements Comparable<Person> {
        int age;
        String name;
    
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return age + " " + name;
        }
    
        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age, name);
        }
    
        Arrays.sort(people);
        
        var sb = new StringBuilder();
        for (Person person : people) {
            sb.append(person).append("\n");
        }
        System.out.println(sb);
    }
}
