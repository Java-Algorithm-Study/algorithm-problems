import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//오등큰수
public class boj_17299 {
    public static void main(String[] args) throws IOException {
//        solvingButTimeout();
        // 스택을 이용하고, map 대신 배열의 인덱스를 활용하자.
        solving();
    }

    private static void solving() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];   // 수열
        int[] cnt = new int[1000001];  // 등장횟수 배열 (A는 1,000,000 이하)
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            cnt[A[i]] += 1;
        }
        int[] NGF = new int[N];
        Stack<Integer> stack = new Stack<>();   // "인덱스"를 쌓을 스택
        for (int i=0; i<N; i++) {
            // 스택에 값이 있고, 스택에 값이 cnt[A[i]]보다 등장횟수가 많은게 있으면 꺼내서 해당 인덱스에 등장횟수 많은 수열을 지정
            // 스택에 있는 인덱스는 현재보다 앞의 인덱스들. 앞 인덱스의 cnt보다 현재 인덱스의 cnt가 더 크면 현재 값을 NGF로 지정.
            while (!stack.isEmpty() && cnt[A[stack.peek()]] < cnt[A[i]]) {
                NGF[stack.pop()] = A[i];
            }
            // 고려되어야할 인덱스는 모두 push
            stack.push(i);
        }
        // 자신보다 등장횟수가 많은 인덱스를 찾지 못한 인덱스들이 스택에 들어가있음
        while (!stack.isEmpty())
            NGF[stack.pop()] = -1;
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i : NGF) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static void solvingButTimeout() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> F = new HashMap<>();    // F 구하기위한 map 생성
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열 생성 및 F 구하기
//        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            F.put(A[i], F.getOrDefault(A[i], 0) + 1);
        }
        // NGF 구하기
        int[] NGF = new int[N];
        for (int i=0; i<N; i++) {
            int Ai= A[i];
            NGF[i]=-1;  // if문에 안걸리면 -1 유지
            for (int j=i+1; j<N; j++) {
                if (F.get(Ai) < F.get(A[j])) {
                    NGF[i] = A[j];
                    break;
                }
            }
        }
        for (int i : NGF) {
            System.out.print(i + " ");
        }
    }
}
