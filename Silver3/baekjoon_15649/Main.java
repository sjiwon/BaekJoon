package Silver3.baekjoon_15649;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static boolean [] visited;
    static int [] buffer; // N까지 M개의 수열을 저장해놓는 buffer array
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        buffer = new int[M];

        BackTracking(0);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void BackTracking(int depth){
        if(depth == M){
            for(int n : buffer){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i=0; i<N; i++){
                if(!visited[i]){
                    visited[i] = true;
                    buffer[depth] = (i + 1);
                    // depth는 어차피 backtracking함에 따라 [0, M)사이에서 계속 update된다
                    BackTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
