package kakao.a2018;


/**
 * [17679] 프렌즈4블록
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 *
 * -아이디어
 * 1. 블록이 지워지는 경우를 체크한다. 체크하기 위해서 boolean 배열을 사용한다.
 * 2. 체크된적이 한번도 없는경우 종료
 * 3. 체크가 한번이라도 있는 경우 블록배열 재갱신한다.
 *
 * -시간복잡도
 * O(n^2)
 */
public class Pro_17679 {
    public static void main(String[] args) {
        int m=4, n=5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int answer = 0;
        char[][] chr = new char[m][n];
        for(int i=0; i<m; i++){
            chr[i] = board[i].toCharArray();
        }

        boolean[][] check;
        while(true){
            check = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    char ch = chr[i][j];
                    if(ch == '.' || i>=m-1 || j>=n-1) continue;
                    four_check(ch, i, j, check, chr);
                }
            }

            boolean flag = true;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(check[i][j] == true) {
                        chr[i][j] = '.';
                        answer++;
                        flag = false;
                    }
                }
            }
            if(flag) break;

            //chr 업데이트
            for(int i=0; i<n; i++){
                for(int j=m-1; j>=1; j--){

                    if(chr[j][i] == '.'){
                        for(int k=j-1; k>=0; k--){
                            if(chr[k][i] != '.'){
                                chr[j][i] = chr[k][i];
                                chr[k][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
//        return answer;
        System.out.println(answer);
    }
    static public void four_check(char ch, int i, int j, boolean[][] check, char[][] chr){
        if(chr[i][j+1] == ch && chr[i+1][j] == ch && chr[i+1][j+1] == ch){
            check[i][j] = true;
            check[i][j+1] = true;
            check[i+1][j] = true;
            check[i+1][j+1] = true;
        }
    }
}

/*
테스트 1 〉	통과 (0.04ms, 82.2MB)
테스트 2 〉	통과 (0.04ms, 72MB)
테스트 3 〉	통과 (0.03ms, 75.5MB)
테스트 4 〉	통과 (0.75ms, 78MB)
테스트 5 〉	통과 (16.65ms, 83.3MB)
테스트 6 〉	통과 (3.85ms, 73.5MB)
테스트 7 〉	통과 (0.43ms, 77.4MB)
테스트 8 〉	통과 (0.45ms, 75.6MB)
테스트 9 〉	통과 (0.05ms, 78.7MB)
테스트 10 〉	통과 (0.32ms, 75.8MB)
테스트 11 〉	통과 (1.64ms, 90.8MB)
 */