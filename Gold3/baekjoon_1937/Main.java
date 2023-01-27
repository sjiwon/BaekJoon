package Gold3.baekjoon_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1937번 욕심쟁이 판다 : https://www.acmicpc.net/problem/1937
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] map;
    static int[][] dp; // (x, y)에 최대한 많은 칸을 이동해서 도달헀을 경우 이동한 칸 개수
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                result = Math.max(result, pandaMove(x, y));
            }
        }
        System.out.println(result);
    }

    private static int pandaMove(int x, int y) { // (x, y)에서 시작해서 가능할때까지 대나무 먹기
        if (dp[x][y] != 0) { // 이미 Memoization
            return dp[x][y];
        }

        dp[x][y] = 1; // 현재 위치한 곳은 방문 한거니까

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && isMoreBamboo(x, y, nx, ny)) { // 영역 내 + 대나무가 더 많이 있으면
                int compareValue = pandaMove(nx, ny) + 1; // (x, y)에서 시작해서 갔다가 최종적으로 가져온 최대 이동 칸 결과
                dp[x][y] = Math.max(dp[x][y], compareValue); // 더 큰 값으로 업데이트
            }
        }

        return dp[x][y];
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean isMoreBamboo(int cx, int cy, int nx, int ny) {
        return map[cx][cy] < map[nx][ny];
    }
}

/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
>> 4
 */