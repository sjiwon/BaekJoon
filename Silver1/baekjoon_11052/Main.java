package Silver1.baekjoon_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int [] Memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().strip());
        int [] P = new int[N+1];
        Memoization = new int[N+1];
        P[0] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        int result = Solution(P, N);
//        System.out.println(Arrays.toString(Memoization));
        System.out.println(result);
    }

    static int Solution(int [] P, int N){
        /*
        Solution(i) : 카드 i개를 max_cost로 살 때 비용
         */
        Memoization[0] = 0;
        Memoization[1] = P[1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                Memoization[i] = Math.max(
                        Memoization[i],
                        Memoization[i - j] + P[j]
                );
            }
        }

        return Memoization[N];
    }
}
