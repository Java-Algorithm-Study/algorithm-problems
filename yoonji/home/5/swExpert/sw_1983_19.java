package swExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 조교의 성적매기기
public class sw_1983_19 {
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        String[] credit = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        Float[] students;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = strToInt(br.readLine());
        for (int t=1; t<=T; t++) {
            String[] line = br.readLine().split(" ");
            int N = strToInt(line[0]);
            int K = strToInt(line[1]);
            students = new Float[N];
            for (int i=0; i<N; i++) {
                String[] scores = br.readLine().split(" ");
                float midTest = (float) (strToInt(scores[0]) * 0.35);
                float finalTest = (float) (strToInt(scores[1]) * 0.45);
                float assignment = (float) (strToInt(scores[2]) * 0.2);
                students[i] = midTest + finalTest + assignment;
            }
            float scoreOfK = students[K-1];
            // 2. 정렬
            Arrays.sort(students, Collections.reverseOrder());
            int rankOfK = 0;
            for (int i=0; i<students.length; i++) {
                if (students[i] == scoreOfK) {
                    rankOfK = i;
                    break;
                }
            }
            int creditCutLine = N/10;
            int creditIdxOfK = rankOfK/creditCutLine;
            answer.append("#"+t+" " + credit[creditIdxOfK]).append("\n");
        }
        System.out.println(answer);
    }
    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}

