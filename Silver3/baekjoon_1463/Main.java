package Silver3.baekjoon_1463;

import java.io.*;
public class Main {
    static Integer [] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        dp[0] = 0; dp[1] = 0;

        bw.write(dp(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int N){
        if(N <= 1)
            return 0;

        if(dp[N] == null){
            if(N%6 == 0)
                dp[N] = Math.min(dp(N-1), Math.min(dp(N/3), dp(N/2))) + 1;
            else if(N%3 == 0)
                dp[N] = Math.min(dp(N/3), dp(N-1)) + 1;
            else if(N%2 == 0)
                dp[N] = Math.min(dp(N/2), dp(N-1)) + 1;
            else
                dp[N] = dp(N-1) + 1;
        }

        return dp[N];
    }
}
