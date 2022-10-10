import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [20061] 모노미노도미노 2
 * https://www.acmicpc.net/problem/20061
 *
 * -아이디어
 * 1.6*4, 4*6 배열을 green, blue로 나눈다.
 * 2. 블록 타입은 세 개가 있다.
 * 3. 어떤 타입이 왔는지 확인 후, blue에는 x(행)을 확인, green에는 y(열)을 확인한다.
 * 4. 한 블럭씩 놓을 때마다 그린은 행, 블루는 열 체크해서 다 찼으면 점수++
 * 5. 그후 한 칸씩 밀어주기
 * 6. 연한 칸 체크해서 0에 있으면 4,5 지우고 밀고, 1에 있으면 5 지우고 민다.
 *
 */

public class Boj20061 {
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] blue = new int[4][6];
        int[][] green = new int[6][4];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            // 1. 블록을 떨어트린다.
            dropBlockAtBlue(type, x, blue);
            dropBlockAtGreen(type, y, green);
//            System.out.println("==blue==");
//            print(blue);
//            System.out.println("==green==");
//            print(green);

            // 2. 한 행 or 열이 다 찼는지 확인한다. -> 찼으면 점수 올리고 삭제한 부분 쪽으로 옮기기
            checkBlue(blue);
            checkGreen(green);
//            System.out.println("==blue==");
//            print(blue);
//            System.out.println("==green==");
//            print(green);

            // 3. 연한 부분이 다 찼는지 확인한다. -> 1에 찼으면 5, 0에 찼으면 4,5 삭제
            checkLightBlue(blue);
            checkLightGreen(green);
//            System.out.println("==blue==");
//            print(blue);
//            System.out.println("==green==");
//            print(green);
        }

        // 점수 출력
        System.out.println(count);
        // 전체 칸의 개수 출력
        System.out.println(countOfBlock(green) + countOfBlock(blue));
    }

    private static void print(int[][] arr) {
        for (int[] ar : arr) {
            for (int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void dropBlockAtBlue(int t, int x, int[][] blue) {
        int temp = 0;

        // type 1 = 1*1
        if (t == 1) {
            for (int i = 0; i < 6; i++) {
                if (blue[x][i] != 0) {
                    break;
                }
                temp = i;
            }
            blue[x][temp] = 1;
        }


        // type 2 = 1*2
        else if (t == 2) {
            for (int j = 1; j < 6; j++) {
                if (blue[x][j - 1] != 0 || blue[x][j] != 0) {
                    break;
                }
                temp = j;
            }
            blue[x][temp] = 1;
            blue[x][temp-1] = 1;
        }
        // type 3 = 2*1
        else {
            for (int j = 0; j < 6; j++) {
                if(blue[x][j] != 0 || blue[x+1][j] != 0) {
                    break;
                }
                temp = j;
            }
            blue[x][temp] = 1;
            blue[x+1][temp] = 1;
        }
    }

    private static void dropBlockAtGreen(int t, int y, int[][] green) {
        int temp = 0;

        if (t == 1) {
            for (int i = 0; i < 6; i++) {
                if (green[i][y] != 0) {
                    break;
                }
                temp = i;
            }
            green[temp][y] = 1;
        }

        else if (t == 3) {
            for (int i = 1; i < 6; i++) {
                if (green[i][y] != 0 || green[i-1][y] != 0) {
                    break;
                }
                temp = i;
            }
            green[temp][y] = 1;
            green[temp-1][y] = 1;
        }

        else {
            for (int i = 0; i < 6; i++) {
                if (green[i][y] != 0 || green[i][y+1] != 0) {
                    break;
                }
                temp = i;
            }
            green[temp][y] = 1;
            green[temp][y+1] = 1;
        }
    }

    private static void checkBlue(int[][] blue) {
        // 칸 찼는지 확인
        // i = 0; i < 6
        for (int i = 0; i < blue[0].length; i++) {
            boolean flag = true;
            // 한 열 확인
            for (int j = 0; j < blue.length; j++) {
                if (blue[j][i] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 한 칸 찼으면 count++
                count++;
                removeBlue(blue, i);
            }
        }

        // 빈칸을 오른쪽으로 이동 (4열을 치웠으면 0 ~ 3열에 있던 블록들을 4열까지 옮긴다.
        // 0열 -> 1열, 1열 -> 2열, 2열 -> 3열, 3열 -> 4열
    }

    private static void checkGreen(int[][] green) {
        for (int i = 2; i < 6; i++) {
            boolean flag = true;

            // 한 행씩 확인한다 (4,0), (4,1) (4,2) (4,3)이 찼는지.
            // 한 행에 한 칸이라도 0이면 다 찬 건 아니어서 다음 행 검사
            for (int j = 0; j < 4; j++) {
                if (green[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                removeGreen(green, i);
            }
        }
    }

    private static void removeBlue(int[][] blue, int y) {
        // 삭제된 열 0 처리
        for (int i = 0; i < 4; i++) {
            blue[i][y] = 0;
        }

        // y는 삭제된 열, y가 3이면 삭제된 열은 3열이고, 옮기는 거 시작은 2열부터
        for (int i = y - 1; i >= 0; i--) {
            for (int j = 0; j < blue.length; j++) {
                blue[j][i+1] = blue[j][i];
            }
        }
    }

    private static void removeGreen(int[][] green, int x) {
        // 삭제된 행 0 처리
        for (int i = 0; i < 4; i++) {
            green[x][i] = 0;
        }

        // 3행이 삭제됐다면 2행부터 시작.
        for (int i = x - 1; i >= 0; i--) {
            for (int j = 0; j < green[i].length; j++) {
                green[i+1][j] = green[i][j];
            }
        }
    }

    private static void checkLightBlue(int[][] blue) {
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (blue[j][i] == 1) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 1) {
            removeLightBlue(blue);
        }
        else if (cnt == 2) {
            removeLightBlue(blue);
            removeLightBlue(blue);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                blue[j][i] = 0;
            }
        }
    }

    private static void removeLightBlue(int[][] blue) {
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < blue.length; j++) {
                blue[j][i+1] = blue[j][i];
                blue[j][i] = 0;
            }
        }
    }

    private static void checkLightGreen(int[][] green) {
        int cnt = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (green[i][j] == 1) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 1) {
            removeLightGreen(green);
        }
        else if (cnt == 2) {
            removeLightGreen(green);
            removeLightGreen(green);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                green[i][j] = 0;
            }
        }
    }

    private static void removeLightGreen(int[][] green) {
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < green[i].length; j++) {
                green[i+1][j] = green[i][j];
                green[i][j] = 0;
            }
        }
    }

    private static int countOfBlock(int[][] arr) {
        int cnt = 0;
        for (int[] arrs : arr) {
            for (int ar : arrs) {
                if(ar == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
