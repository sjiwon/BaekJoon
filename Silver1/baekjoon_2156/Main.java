package Silver1.baekjoon_2156;

import java.io.*;
import java.util.*;
public class Main {
    static int [] grape;
    static int [] dp;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grape = new int[n+1];
        dp = new int[n+1];

        for(int i=1; i<=n; i++)
            grape[i] = Integer.parseInt(br.readLine());

        dp[1] = grape[1];

        bw.write(dp(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int n){
        if(n<=1)
            return dp[n];

        dp[2] = grape[1] + grape[2];

        for(int i=3; i<=n; i++){
            /*
            i번째 잔을 마시냐 안마시냐? -> 이득이 되지 않으면 안마시고 넘기기
            -> 그러면 이전까지의 누적값을 그대로 가져오기?
             */
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + grape[i], dp[i-3] + grape[i-1] + grape[i]));
        }

        return dp[n];
    }
}
