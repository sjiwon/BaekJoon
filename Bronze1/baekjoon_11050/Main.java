package Bronze1.baekjoon_11050;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int top = factorial(N);
        int bottom = factorial(N-K)*factorial(K);

        int result = top/bottom;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static int factorial(int a){
        if(a<=1)
            return 1;
        else
            return a*factorial(a-1);
    }
}
