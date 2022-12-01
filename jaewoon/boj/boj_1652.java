package boj;

import java.io.*;


public class boj_1652 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int row_cnt = 0;
        int col_cnt = 0;

        char room[][] = new char[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                room[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            int cur_row = 0;
            int cur_col = 0;

            //row
            for(int j=0; j<n; j++){
                if(room[i][j] == 'X') { cur_row=0;}
                else cur_row++;

                if(cur_row==2) {
                    row_cnt++;
                }
            }

            //col
            for(int j=0; j<n; j++){
                if(room[j][i] == 'X') { cur_col=0;}
                else cur_col++;

                if(cur_col==2) {
                    col_cnt++;
                }
            }
        }
        System.out.println(row_cnt+" "+col_cnt);
    }
}