package Silver5.baekjoon_11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<Integer>();
        int index = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while(N>1){
            index = (index+K-1)%N;
            sb.append(list.remove(index)).append(", ");
            N--;
        }
        sb.append(list.remove()).append(">");

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
