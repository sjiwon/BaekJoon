package Silver5.baekjoon_1010;

import java.io.*;
import java.util.*;
public class Main {
    static int [][] dp = new int[30][30];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i=0; i<30; i++){
                dp[i][i] = 1;
                dp[i][0] = 1;
            }

            bw.write(Combi(M, N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int Combi(int a, int b){
        // a개 중 b개 뽑기
        if(dp[a][b] != 0)
            return dp[a][b];

        return dp[a][b] = Combi(a-1, b) + Combi(a-1, b-1);
    }
}
