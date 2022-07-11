package Silver2.baekjoon_18352;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, K, X; // 도시 개수(Vertex), 도로 개수(Edge), 거리 정보(Edge 연결), 출발 도시 번호(Start Vertex)
    static int [] distance; // 출발 도시로부터 각 도시까지 거리 저장 배열
    static boolean [] visited; // 각 도시 방문여부 체크 (Start Vertex : "true")

    static class Node implements Comparable<Node>{
        private int id, w;
        // LinkedList<Node> [] 배열을 만들어서 Start Vertex는 배열의 index로 사용
        Node(int id, int w){
            this.id = id; this.w = w;
        }
        int getId(){return id;}
        int getW(){return w;}

        @Override
        public int compareTo(Node o) {
            return Integer.compare(getW(), o.getW());
        }
    }
    static List<Node> [] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N+1]; // 이 상태는 LinkedList 배열에 대한 레퍼런스 배열만 생성한 상태
        distance = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++) {
            graph[i] = new LinkedList<>(); // graph 배열마다 LinkedList 객체 생성
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, 1));
            // Start Vertex를 배열의 index로 사용, 배열의 값에 Node(End Vertex, Weight)
        }

        dijkstra(X);

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<distance.length; i++){
            if(distance[i] == K) {
                sb.append(i).append("\n");
                flag = true;
            }
        }

        if(flag)
            bw.write(sb + "\n");
        else
            bw.write(-1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int X){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(X, 0));
        visited[X] = true;
        distance[X] = 0;
        // Start Vertex의 distance는 자기자신이니까 0으로 설정

        while(!q.isEmpty()){
            Node v = q.poll();

            for(Node w : graph[v.getId()]){
                // w : v의 인접 정점
                if(!visited[w.getId()]){
                    if(distance[w.getId()] > distance[v.getId()] + w.getW())
                        distance[w.getId()] = distance[v.getId()] + w.getW();
                    // Start Vertex ~ Vertex(w) @@ Start ~ Vertex(v) + Vertex(v) ~ Vertex(w)
                    visited[w.getId()] = true;
                    q.offer(new Node(w.getId(), distance[w.getId()]));
                }
            }
        }
    }
}

