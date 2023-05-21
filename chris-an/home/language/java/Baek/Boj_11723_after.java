package language.java.Baek;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11723_after {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "add" : {
                    S |= (1 << Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove" : {
                    S &= ~(1 << Integer.parseInt(st.nextToken()));
                    break;
                }
                case "check" : {
                    if((S & (1 << Integer.parseInt(st.nextToken()))) > 0) {
                        sb.append("1\n");
                    } else sb.append("0\n");
                    break;
                }
                case "toggle" : {
                    int n = Integer.parseInt(st.nextToken());
                    S ^= (1<<n);
                    break;
                }
                case "all" : {
                    S = (1 << 21) -1;
                    break;
                }
                case "empty" : {
                    S = 0;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}