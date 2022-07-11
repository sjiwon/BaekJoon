package Silver2.baekjoon_11724;

import java.io.*;
import java.util.*;
public class Main {
    static int N; // 정점 개수
    static int M; // 간선 개수
    static List<Integer> [] graph;
    static boolean [] visited;
    static StringTokenizer st;
    static int count = 0; // 연결 요소 개수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new LinkedList<>();
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
            // Because graph doesn't have any direction
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int v){
        visited[v] = true;

        for(int i=0; i<graph[v].size(); i++){
            int w = graph[v].get(i);

            if(!visited[w]){
                visited[w] = true;
                dfs(w);
            }
        }
    }
}
