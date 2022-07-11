package Silver2.baekjoon_11053;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int N;
    static int [] list;
    static int [][] Memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        Memoization = new int[N+1][N+2];

        list[0] = Integer.MIN_VALUE; // Sentinel

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int result = DP(list, 0, 1);
        System.out.println(result);
    }

//    static int LIS(int [] list, int pre, int index){
//        if(index == N){
//            return 0;
//        }
//        else if(list[index] <= pre){
//            return LIS(list, pre, index + 1);
//        }
//        else{
//            int with = LIS(list, list[index], index + 1) + 1;
//            int wout = LIS(list, pre, index + 1);
//            return Math.max(with, wout);
//        }
//    }

    static int DP(int [] list, int x, int y){
        // Base Case
        for(int i=0; i<N; i++){
            Memoization[i][N] = 0;
        }

        for(int j=list.length-1; j>=0; j--){
            for(int i=0; i<j; i++){
                int with = Memoization[j][j+1] + 1;
                int wout = Memoization[i][j+1];

                if(list[j] <= list[i]){
                    Memoization[i][j] = wout;
                }
                else{
                    Memoization[i][j] = Math.max(with, wout);
                }
            }
        }

        return Memoization[x][y];
    }
}
