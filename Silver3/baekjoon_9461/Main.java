package Silver3.baekjoon_9461;

import java.io.*;
public class Main {
    static long [] dp = new long[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            bw.write(p(N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long p(int N){
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for(int i=5; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-5];

        return dp[N];
    }
}
