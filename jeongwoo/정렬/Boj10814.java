import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [10814] 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 *
 * -아이디어
 * 1. 나이 오름차순으로 정렬하고, 나이가 같을 경우에는 입력 순서대로 정렬한다.
 * 2. 나이와 이름이 한 세트로 진행돼야 해서 클래스를 만들고, Comparator로 정렬 override한다.
 *
 */

public class Boj10814 {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Comparator<Member> mc = new Comparator<>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.age - m2.age;
            }
        };

        Collections.sort(members, mc);

        for (Member m : members) {
            System.out.println(m.age + " " + m.name);
        }
    }
}
