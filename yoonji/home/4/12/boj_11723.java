import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 집합
public class boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder answerSB = new StringBuilder();
        while (M-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            String order = inputLine[0];
            int num = 0;
            if (inputLine.length>1) num = Integer.parseInt(inputLine[1]);
            switch(order) {
                case "add" :
                    set.add(num);
                    break;
                case "remove" :
                    set.remove(num);    // if (set.contains(num))
                    break;
                case "toggle" :
                    if (!set.remove(num)) set.add(num); // 있으면 제거, 없으면 추가
                    break;
                case "all" :
                    set = new HashSet<>();
                    for (int i = 1; i <= 20; i++) set.add(i);
                    break;
                case "empty" :
                    set = new HashSet<>();
                    break;
                default:
                    if (set.contains(num)) answerSB.append(1);
                    else answerSB.append(0);
                    answerSB.append("\n");
            }
        }
        System.out.println(answerSB);
    }
}
