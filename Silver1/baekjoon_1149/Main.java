package Silver1.baekjoon_1149;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] cost = new int[N][3];
        // 각 집의 색칠비용
        // 0 = R
        // 1 = G
        // 2 = B


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++){
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }

        int result = Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
