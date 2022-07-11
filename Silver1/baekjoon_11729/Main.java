package Silver1.baekjoon_11729;

import java.io.*;

public class Main {
    static int K;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        hanoi(K, 1, 2, 3);
        sb.insert(0, count + "\n");

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void hanoi(int K, int A, int B, int C){
        ++count;
        if(K==1){
            sb.append(A).append(" ").append(C).append("\n");
            return;
        }
        hanoi(K-1, A, C, B);
        sb.append(A).append(" ").append(C).append("\n");
        hanoi(K-1, B, A, C);
    }
}
