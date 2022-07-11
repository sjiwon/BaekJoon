package Silver3.baekjoon_2193;

import java.io.*;
import java.util.*;
public class Main {
    static long [] dp = new long[91];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        /*
        :: 이진수 조건
        (1) 0으로 시작 X
        (2) 1이 2번 연속으로 X

        -> 숫자 범위 = 0 ~ 2^(N) - 1 -> Integer.toBinaryString();

        int count = 0;
        for(int i=0; i<Math.pow(2, N); i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            while(sb.length()!=N)
                sb.insert(0, "0");

            if(!(sb.toString().startsWith("0")) && !(sb.toString().contains("11"))) {
                count++;
            }
        }
         */
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-2];


        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
