package Silver2.baekjoon_1260;

import java.io.*;
import java.util.*;
public class Main {
    static boolean [] visited;
    static int [][] matrix;
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int v; // 시작 정점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        v = Integer.parseInt(st.nextToken()); // 시작 정점

        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];
        init_visited(visited);

        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            matrix[start][end] = matrix[end][start] = 1;
        }
        dfs(v);
        System.out.println();
        init_visited(visited);
        bfs(v);
        br.close();

    }

    static void init_visited(boolean [] visited){
        Arrays.fill(visited, false);
    }

    static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for(int i=1; i<=N; i++){
            if(!visited[i] && matrix[v][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for(int i=1; i<=N; i++){
                if(!visited[i] && matrix[tmp][i] == 1 && !queue.contains(i)){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
