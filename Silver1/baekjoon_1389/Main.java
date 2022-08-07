package Silver1.baekjoon_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N; // 유저 수
    static int M; // 관계 수
    static int[][] graph;
    static final int INIT_GRAPH = 987654321;

    static int minKevinNum = Integer.MAX_VALUE;
    static List<Integer> userList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    graph[i][j] = INIT_GRAPH;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A - 1][B - 1] = graph[B - 1][A - 1] = 1;
        }

        floydWashall();
        getResult();
    }

    static void floydWashall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    static void getResult() {
        int[] result = new int[N];

        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += graph[i][j];
            }
            result[j] = count;
        }

        for (int i = 0; i < N; i++) {
            if (minKevinNum > result[i]) {
                minKevinNum = result[i];
            }
        }

        for (int i = 0; i < N; i++) {
            if (result[i] == minKevinNum) {
                userList.add(i + 1);
            }
        }

        Collections.sort(userList);
        System.out.println(userList.get(0));
    }
}
