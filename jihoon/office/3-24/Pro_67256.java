import java.util.Arrays;

public class Pro_67256 {
    
    private static int[][] board = new int[3][3];
    private static int[] rPointer = {3, 2};
    private static int[] lPointer = {3, 0};
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }
    
    public static String solution(int[] numbers, String hand) {
        makeBoard();
    
        for (int num : numbers) {
            System.out.println(Arrays.toString(rPointer) + " RIGHT POINTER");
            System.out.println(Arrays.toString(lPointer) + " LEFT POINTER");
            System.out.println("------------------------- " + num);
            
            String result = checkPosition(num);
            
            // 오른쪽 키패드이나 왼쪽 키패드에 속하면 바로 움직인다
            if (result.equals("R") || result.equals("L")) {
                moveHand(result, num);
            }
            
            // 누르고자 하는 숫자가 중간 키패드에 위치 할 때
            else {
                String closest = getClosest(getPosition(num));
                
                // 손가락 위치가 둘 중 하나가 더 가까운 위치가 나온 경우 가까운 손가락을 움직인다
                if (closest.equals("R") || closest.equals("L")) {
                    moveHand(closest, num);
                }
                
                // 손가락 위치가 같은 경우 왼손잡이인지 오른손잡이인지 구분해서 움직인다
                else {
                    if (hand.equals("right"))
                        moveHand("R", num);
                    else
                        moveHand("L", num);
                }
            }
            
        }
        
        return sb.toString();
    }
    
    public static void moveHand(String position, int num) {
        if (position.equals("R")) {
            sb.append(position);
            rPointer = getPosition(num);
        }
        else if (position.equals("L")) {
            sb.append(position);
            lPointer = getPosition(num);
        }
    }
    
    public static String getClosest(int[] num) {
        int rDistance = Math.abs(num[0] - rPointer[0]) + Math.abs(num[1] - rPointer[1]);
        int lDistance = Math.abs(num[0] - lPointer[0]) + Math.abs(num[1] - lPointer[1]);
        
        if (rDistance < lDistance)
            return "R";
        else if (rDistance > lDistance)
            return "L";
        else
            return "M";
    }
    
    public static String checkPosition(int n) {
        if (n == 0) return "M";
        
        if (n % 3 == 0)
            return "R";
        if (n % 3 == 1)
            return "L";
        
        return "M";
    }
    
    public static void makeBoard() {
        int number = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = number++;
            }
        }
    }
    
    public static int[] getPosition(int n) {
        
        if (n == 0) return new int[] {3, 1};
        
        int[] position = new int[2];
        int row = 0;
        int col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (n == board[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        position[0] = row;
        position[1] = col;
        return position;
    }
    
}
