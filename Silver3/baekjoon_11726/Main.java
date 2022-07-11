package Silver3.baekjoon_11726;

import java.io.*;
public class Main {
    static int [] dp = new int[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++)
            dp[i] = (dp[i-1] + dp[i-2])%10007;

        System.out.println(dp[N]);
        //bw.write(dp[N] + "\n");
        //bw.flush();
        //bw.close();
        br.close();
    }
}
/*
BufferedWriter : 15904KB / 148ms
System.out.println : 14296KB / 132ms
 */
