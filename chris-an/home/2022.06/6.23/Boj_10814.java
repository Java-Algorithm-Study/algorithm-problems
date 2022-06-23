import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Boj_10814 {
    static class OnlineJudgeList {
        int age;
        String name;

        public OnlineJudgeList(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        List<OnlineJudgeList> list = new ArrayList<>();
        String[] line;
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            list.add(new OnlineJudgeList(Integer.parseInt(line[0]), line[1]));
        }

        Collections.sort(list, new Comparator<OnlineJudgeList>() {
            @Override
            public int compare(OnlineJudgeList o1, OnlineJudgeList o2) {
                return o1.age - o2.age;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (OnlineJudgeList member : list) {
            sb.append(member.age).append(' ').append(member.name).append('\n');
        }

        System.out.println(sb);
    }
}
