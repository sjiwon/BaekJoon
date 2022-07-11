package Silver2.baekjoon_1912;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int [] Memoization;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] list = new int[n];
        Memoization = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }


        int result = Solution(list, list.length - 1);

        System.out.println(result);
    }

    static int Solution(int [] list, int N){
        /*
        Solution(N) : [0, N] 구간 내에 존재하는 최대합 (Contiguous)
         */

        Memoization[0] = list[0];
        int maxSum = Memoization[0];

        for(int i=1; i<=N; i++){
            Memoization[i] = Math.max(list[i], Memoization[i-1] + list[i]);

            maxSum = Math.max(maxSum, Memoization[i]);
        }

        return maxSum;
    }

//    static int Solution(int [] list, int N){
//        int maxSum = list[0];
//
//        for(int i=1; i<N; i++){
//            list[i] = Math.max(list[i], list[i-1] + list[i]);
//
//            maxSum = Math.max(maxSum, list[i]);
//        }
//
//        return maxSum;
//    }
}
