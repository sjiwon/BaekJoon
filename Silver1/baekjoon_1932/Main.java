package Silver1.baekjoon_1932;

import java.io.*;
import java.util.*;
public class Main {
    static int [][] dp; // 누적 합계 저장
    static int [][] cost; // 각 단계별 cost저장
    static int T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        cost = new int[T][T];
        dp = new int[T][T];

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<T; i++)
            dp[T-1][i] = cost[T-1][i];
        // Bottom - Up으로 밑에서부터 위로 값이 큰거 더해가기

        dp();

        bw.write(dp[0][0] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dp(){
        for(int i=T-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = cost[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
   }
}
