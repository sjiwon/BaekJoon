package Bronze2.baekjoon_2747;

import java.io.*;
public class Main {
    static int [] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-2];

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}