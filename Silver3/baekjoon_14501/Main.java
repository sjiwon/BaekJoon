package Silver3.baekjoon_14501;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static StringTokenizer st;
    static int N;
    static int [] Memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int [] time = new int[N+1];
        int [] pay = new int[N+1];
        Memoization = new int[N+1];

        time[0] = pay[0] = Memoization[0];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int result = Solution(time, pay);
//        System.out.println(Arrays.toString(Memoization));
        System.out.println(result);
    }

    static int Solution(int [] time ,int [] pay){
        /*
        Solution(i) : i일부터 시작해서 이후 MAX 이익
         */
        int MaxReward = 0;

        for(int i=N; i>=1; i--){
            if(i + time[i] - 1 > N){
                Memoization[i] = 0;
//                System.out.println(i + " : " + Memoization[i]);
            }
            else if(i + time[i] - 1 == N){
                Memoization[i] = pay[i];
//                System.out.println(i + " : " + Memoization[i]);
            }
            else{
                Memoization[i] = pay[i] + AfterFindMax(Memoization, i + time[i]);
//                System.out.println(i + " : " + Memoization[i]);
            }

            MaxReward = Math.max(MaxReward, Memoization[i]);
        }

        return MaxReward;
    }

    static int AfterFindMax(int [] M, int k){
        int max = 0;

        for(int i=k; i<M.length; i++){
            if(M[i] > max){
                max = M[i];
            }
        }

        return max;
    }
}
