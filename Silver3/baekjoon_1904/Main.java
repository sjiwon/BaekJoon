package Silver3.baekjoon_1904;

import java.io.*;
public class Main {
    static int [] dp = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        bw.write(tile_dp(N)%15746 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int tile_dp(int N){
        for(int i=3; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[N];
    }
}
