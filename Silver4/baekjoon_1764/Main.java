package Silver4.baekjoon_1764;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> listen = new HashSet<>();
        Set<String> see = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            listen.add(br.readLine());
        for(int i=0; i<M; i++)
            see.add(br.readLine());

        listen.retainAll(see); // 교집합 생성
        TreeSet<String> tree = new TreeSet<>(listen);
        // TreeSet을 통해서 자동 사전순 정렬 (오름차순)

        bw.write(tree.size() + "\n");
        for(String s : tree)
            bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
