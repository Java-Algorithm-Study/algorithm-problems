package swExpert;

import java.io.*;

public class sw_6485_16 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = strToInt(br.readLine());
        int[][] busLine;
        for(int tc = 1; tc <= T; tc++)
        {
            int N = strToInt(br.readLine());
            busLine = new int[N][2];
            for (int i=0; i<N; i++) {
                String line = br.readLine();
                busLine[i][0] = strToInt(line.split(" ")[0]);
                busLine[i][1] = strToInt(line.split(" ")[1]);
            }
            int busStopNum = strToInt(br.readLine());
            int[] busStop = new int[busStopNum];
            for (int i=0; i<busStopNum; i++) {
                busStop[i] = strToInt(br.readLine());
            }
            int[] answer = new int[5001];
            for (int i=0; i<N; i++) {
                int start = busLine[i][0];
                int end = busLine[i][1];
                for (int j=start; j<=end; j++) {
                    answer[j]++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<busStopNum; i++) sb.append(answer[busStop[i]]).append(" ");
            System.out.print("#"+ tc + " " + sb);
        }
    }
    private static int strToInt(String str) { return Integer.parseInt(str); }
}