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
            int[] busStop = new int[busStopNum+1];
            for (int i=0; i<busStopNum; i++) {
                busStop[i] = strToInt(br.readLine());
            }
            int[] answer = new int[5000+1];   // index가 정류장 번호니까
            for (int i=0; i<N; i++) {
                int start = busLine[i][0];
                int end = busLine[i][1];
                for (int p=0; p < busStopNum; p++) {
                    if (start<=busStop[p] && busStop[p]<=end) answer[p]++;
                    //busStop { 10, 4, 30, 96, 100
//                    p 0 -> busStop[0]==10 == 1 -> answer[0] ++;
//                    p 1 -> busStop[1]==4 != 1
//                    p 2 -> busStop[2]==30 != 1
//                    p 3 -> busStop[3]==96 != 1
//                    p 4 -> busStop[4]==100 != 1
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<busStopNum; i++) sb.append(answer[i]).append(" ");
            System.out.println("#"+ tc + " " + sb);
        }
    }
    private static int strToInt(String str) { return Integer.parseInt(str); }
}