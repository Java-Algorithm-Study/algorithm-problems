package language.java.SW;

public class Sw_대각선출력하기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) sb.append('#');
                else sb.append('+');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
