package Silver4.baekjoon_2164;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++)
            dq.offer(i);

        while(dq.size() != 1){
            dq.pollFirst();
            dq.offerLast(dq.pollFirst());
        }
        bw.write(dq.poll() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
