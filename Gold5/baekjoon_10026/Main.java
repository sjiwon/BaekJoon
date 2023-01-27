package Gold5.baekjoon_10026;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 백준 10026번 적록색약 : https://www.acmicpc.net/problem/10026
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    final static String RED = "R";
    final static String GREEN = "G";

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }

        int generalCount = 0;
        int colorWeaknessCount = 0;

        // 일반적인 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    getGeneralCount(i, j);
                    generalCount++;
                }
            }
        }
        
        initVisitied(); // 방문 배열 초기화
        changeMap(); // 적록색약 전용 맵 변환

        // 적록색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    getGeneralCount(i, j);
                    colorWeaknessCount++;
                }
            }
        }

        bw.write(generalCount + " " + colorWeaknessCount);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void getGeneralCount(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (isRange(nx, ny) && notVisitedYet(nx, ny) && isSameColor(x, y, nx, ny)) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean notVisitedYet(int nx, int ny) {
        return !visited[nx][ny];
    }

    private static boolean isSameColor(int cx, int cy, int nx, int ny) {
        return map[cx][cy].equals(map[nx][ny]);
    }

    private static void initVisitied() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = Boolean.FALSE;
            }
        }
    }

    private static void changeMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals(GREEN)) {
                    map[i][j] = RED;
                }
            }
        }
    }
}

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
>> 4 3
 */