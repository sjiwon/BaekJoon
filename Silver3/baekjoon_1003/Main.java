package Silver3.baekjoon_1003;

import java.io.*;
public class Main {
    static int [] zero;
    static int [] one;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int [] result = fibo_DP(N);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int [] fibo_DP(int N){
        if (N == 0)
            return new int[]{1, 0};
        if (N == 1)
            return new int[]{0, 1};

        zero = new int[41];
        one = new int[41];

        zero[0] = 1; zero[1] = 0;
        one[0] = 0; one[1] = 1;

        for(int i=2; i<=N; i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        return new int[]{zero[N], one[N]};
    }
}
