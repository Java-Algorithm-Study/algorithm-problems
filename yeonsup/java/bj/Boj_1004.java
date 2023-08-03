package yeonsup.java.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Location {

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x, y;
}

class Planet {

    int x, y, r;

    public Planet(int[] xyr) {
        this.x = xyr[0];
        this.y = xyr[1];
        this.r = xyr[2];
    }
}

class Starship {
    Location start;
    Location end;

    public void setLocation(int[] xy) {
        start = new Location(xy[0], xy[1]);
        end = new Location(xy[2], xy[3]);
    }

    public int isInThePlanet(Planet planet) {
        boolean isStart = Math.pow(start.x - planet.x, 2) + Math.pow(start.y - planet.y, 2) < Math.pow(planet.r, 2);
        boolean isEnd = Math.pow(end.x - planet.x, 2) + Math.pow(end.y - planet.y, 2) < Math.pow(planet.r, 2);

        if(isStart && isEnd) return 0;
        if(isStart || isEnd) return 1;

        return 0;
    }
}

public class Boj_1004 {

    public static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Starship ship = new Starship();

        int testCnt = Integer.parseInt(br.readLine());
        result = new int[testCnt];

        int t = 0;
        while(t < testCnt) {
            ship.setLocation(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            int n = Integer.parseInt(br.readLine());

            result[t] = 0;
            for (int i = 0; i < n; i++) {
                Planet planet = new Planet(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
                result[t] += ship.isInThePlanet(planet);
            }
            t++;
        }

        for (int cnt : result) {
            System.out.println(cnt);
        }
    }
}
