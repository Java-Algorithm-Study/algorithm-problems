package language.java.Baek;

public class Boj_62048 {
    public static long solution(int w, int h) {
        long count = 0;
        for (int i = 1; i <= w; i++) {
            double prevY =  (double) (i - 1) * h / w;
            double currentY = (double) i * h / w;

            if (currentY % 1 == 0) currentY--;

            count += 1 + (long) currentY - (long) prevY;
        }
        return (long) w * h - count;
    }
}
