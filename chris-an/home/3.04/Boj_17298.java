import java.io.*;
import java.util.Stack;

public class Boj_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(bf.readLine());

        int[] seq = new int[cnt];
        int[] result = new int[cnt];
        String[] temp = bf.readLine().split(" ");

        for (int i = 0; i < cnt; i++) {
            seq[i] = Integer.parseInt(temp[i]);
        }
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < cnt; i++) {
            if (s.isEmpty()) {
                s.push(i);
            }
            while (!s.isEmpty() && seq[s.peek()] < seq[i]) {
                result[s.pop()] = seq[i];
            }
            s.push(i);
        }

        while (!s.empty()) {
            result[s.pop()] = -1;
        }

        for (int i = 0; i < cnt; i++) bw.write(result[i] + " ");

        bw.flush();
        bw.close();
    }
}


/*


    여러가지 예외처리에 걸려서 틀림. 수정은 추후에
    테스트 케이스에 너무 집중한 거 같았음.

import java.io.*;
import java.util.Stack;

public class Boj_17298_failed {
    public static void main(String[] args) throws IOException {

        Stack<Integer> sk = new Stack(); // 스택을 쓰는 이유? 특징인 선입선출을 이용하여 받은 수열 뒤부터 값의 로직비교를 위해 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Scanner sc = new Scanner(System.in); // 입력은 빈번하지 않으니 Scanner 사용
        int seqCnt = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");

        // 받은 입력 값을 스택에 담아 두기
        for (int i = 0; i < input.length; i++) {
            sk.push(Integer.parseInt(input[i]));
        }

        int [] resultArray = new int[seqCnt];
        int idx = 1;
        int max = 0;
        int target = 0;
        int peek = 0;

        while (seqCnt-- > 1) {
            if (resultArray[0] == 0) {
                 resultArray[0] = -1;
                 if (!sk.isEmpty()) peek = sk.pop();
            }else peek = target;
                 if (!sk.isEmpty()) target = sk.pop();


            if (peek < target) {
                if (max > target) resultArray[idx++] = max;
                else {
                    if (seqCnt == 1) resultArray[idx++] = -1;
                    else resultArray[idx++] = target;
                }

            }else if (peek > target){
                resultArray[idx++] = peek;
                if(max < peek) max = peek; // 가장 큰 값 더해주기
            }
        }
        for (int i = 0; i < resultArray.length; i++) bw.write(resultArray[i] + " ");

        bw.flush();
        br.close();
        bw.close();


    }
}


 */