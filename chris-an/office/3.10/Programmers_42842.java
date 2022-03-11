import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers_42842 {
    
    public static int [] solution(int brown, int yellow) {
        int a = brown/2 + 2;
        int b = yellow + brown;

        double alpha = (a+Math.sqrt(a*a - 4*b)) / 2;
        double beta = a - alpha;

        int [] answer = {(int) alpha, (int) beta};
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] ch = br.readLine().split(" ");
        int b = Integer.parseInt(ch[0]);
        int y = Integer.parseInt(ch[1]);

        System.out.println(solution(b,y)[0] +" " + solution(b,y)[1]);
    }
}
