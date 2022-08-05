package Gold5.baekjoon_2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    static int N;
    static int[][] graph;
    static int presidentScore;
    static int presidentCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i != j) {
                    graph[i][j] = 987654321;
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A == -1 && B == -1){
                break;
            }

            graph[A - 1][B - 1] = graph[B - 1][A - 1] = 1;
        }

        floydWashall();
        getPresident();
    }

    static void floydWashall(){
        for (int k = 0; k < N; k++) { // 경유하는 node
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    static void getPresident(){
        int[] result = new int[N];

        for (int j = 0; j < N; j++) {
            int score = 0;
            for (int i = 0; i < N; i++) {
                score = Math.max(score, graph[i][j]);
            }
            result[j] = score;
        }

        int minimumScore = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            minimumScore = Math.min(minimumScore, result[i]);
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == minimumScore) {
                list.add(i + 1);
                count++;
            }
        }

        presidentScore = minimumScore;
        presidentCount = count;

        StringBuilder sb = new StringBuilder();
        sb.append(presidentScore).append(" ").append(presidentCount).append("\n");
        for (Integer idx : list) {
            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }
}