package Silver3.baekjoon_2579;

import java.io.*;
public class Main {
    static int [] step;
    static int [] dp;
    static int T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        step = new int[T+1];
        dp = new int[T+1];
        step[0] = 0;
        dp[0] = 0;

        for(int i=1; i<=T; i++)
            step[i] = Integer.parseInt(br.readLine());

        dp[1] = step[1];

        bw.write(dp(T) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int T){
        if(T<=1)
            return dp[T];

        dp[2] = step[1] + step[2];

        for(int i=3; i<=T; i++)
            dp[i] = Math.max(dp[i-2], dp[i-3] + step[i-1]) + step[i];
        /*
        (1) 2칸 전에서 뛰어올라서 현재 칸에 도착 -> 2칸 전 = 누적된 값으로
        (2) 3칸 전에서 뛰어올라서 현재-1 칸에 도착하고, 그리고 1칸 더 올라와서 도착 -> 3칸 전 = 누적값, 1칸 전 = 원래 비용
         */

        return dp[T];
    }
}
