package Gold3.baekjoon_1600;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Point {
        private int x;
        private int y;
        private int remainHorseMoveCount; // 해당 포인트에서 말처럼 움직일 수 있는 횟수 (남은 횟수)
        private int moveCount; // 해당 포인트에 도달할때까지 이동한 횟수

        public Point(int x, int y, int remainHorseMoveCount, int moveCount) {
            this.x = x;
            this.y = y;
            this.remainHorseMoveCount = remainHorseMoveCount;
            this.moveCount = moveCount;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRemainHorseMoveCount() {
            return remainHorseMoveCount;
        }

        public int getMoveCount() {
            return moveCount;
        }
    }

    static int K; // 말처럼 움직일 수 있는 횟수
    static int W; // column
    static int H; // row
    static int[][] map;
    static boolean[][][] visited;
    static int[] horseX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horseY = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] monkeyX = {0, 0, 1, -1};
    static int[] monkeyY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[K + 1][H][W]; // 방문 여부 + 말처럼 이동했는지 여부까지 체크

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(moveProcess());
    }

    private static int moveProcess() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, K, 0));
        visited[K][0][0] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int currentX = currentPoint.getX();
            int currentY = currentPoint.getY();
            int currentRemainHorseMoveCount = currentPoint.getRemainHorseMoveCount();
            int currentMoveCount = currentPoint.getMoveCount();

            if (isTargetReached(currentX, currentY)) { // 목표 지점에 도달 (오른쪽 맨 끝 아래)
                return currentMoveCount;
            }

            for (int i = 0; i < monkeyX.length; i++) { // 1. 원숭이처럼 움직이기
                int nextX = currentX + monkeyX[i];
                int nextY = currentY + monkeyY[i];

                if (isRange(nextX, nextY) && isPossibleToMove(nextX, nextY) && neverVisited(currentRemainHorseMoveCount, nextX, nextY)) {
                    visited[currentRemainHorseMoveCount][nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY, currentRemainHorseMoveCount, currentMoveCount + 1));
                }
            }

            if (currentRemainHorseMoveCount != 0) { // 말처럼 움직일 수 있는 기회가 남아있으면
                for (int i = 0; i < horseX.length; i++) { // 2. 말처럼 움직이기
                    int nextX = currentX + horseX[i];
                    int nextY = currentY + horseY[i];
                    int updateHorseMoveCount = currentRemainHorseMoveCount - 1;

                    if (isRange(nextX, nextY) && isPossibleToMove(nextX, nextY) && neverVisited(updateHorseMoveCount, nextX, nextY)) {
                        visited[updateHorseMoveCount][nextX][nextY] = true;
                        queue.offer(new Point(nextX, nextY, updateHorseMoveCount, currentMoveCount + 1));
                    }
                }
            }
        }

        return -1; // 도달하지 못한 경우
    }

    private static boolean isTargetReached(int x, int y) {
        return x == H - 1 && y == W - 1;
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    private static boolean isPossibleToMove(int x, int y) {
        return map[x][y] == 0;
    }

    private static boolean neverVisited(int horseMoveLevel, int x, int y) {
        return visited[horseMoveLevel][x][y] == Boolean.FALSE;
    }
}