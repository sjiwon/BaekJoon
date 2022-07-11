package Gold3.baekjoon_1238;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;

    static class Node implements Comparable<Node>{
        private int id, cost;
        // 시작점은 인덱스로 구현, id = 도착점, cost = 비용
        Node(int id, int cost){
            this.id = id;
            this.cost = cost;
        }
        int getId(){return id;}
        int getCost(){return cost;}

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getCost(), o.getCost());
        }
    }

    static List<Node> [] map_toX, map_fromX;
    /*
    map_toX : 각 정점 ~ X까지
    map_fromX : X ~ 각 정점까지
     */
    static int [] dist_toX; // 각 정점 ~ X까지의 비용
    static int [] dist_fromX; // X ~ 각 정점까지의 비용
    static int N, M, X;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수 (Vertex)
        M = Integer.parseInt(st.nextToken()); // 간선 수 (Edge) :: 단방향 간선
        X = Integer.parseInt(st.nextToken()); // 파티가 열리는 장소
        // 각 정점으로부터 X까지의 비용 + X로부터 각 정점까지의 비용

        map_toX = new LinkedList[N+1];
        map_fromX = new LinkedList[N+1];
        for(int i=0; i<=N; i++){
            map_toX[i] = new LinkedList<>();
            map_fromX[i] = new LinkedList<>();
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            /*
            주어진 입력대로 저장 : X ~ 각 정점 = map_fromX
            reverse 저장 : 각 정점 ~ X = map_toX
             */
            map_fromX[start].add(new Node(end, cost));
            map_toX[end].add(new Node(start, cost));
        }

        dist_toX = dijkstra(map_toX, X);
        dist_fromX = dijkstra(map_fromX, X);

        int max = 0;
        for(int i=0; i<=N; i++){
            if(max < (dist_toX[i] + dist_fromX[i]))
                max = dist_toX[i] + dist_fromX[i];
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int [] dijkstra(List<Node> [] map, int start){
        boolean [] visited = new boolean[N+1]; // 방문 여부 배열
        int [] dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        visited[start] = true;
        dist[start] = 0;

        while(!q.isEmpty()){
            Node v = q.poll(); // 현재 정점

            for(Node w : map[v.getId()]){
                // w : v의 인접 정점
                if(dist[w.getId()] < dist[v.getId()] + w.getCost())
                    continue;
                if(dist[w.getId()] > dist[v.getId()] + w.getCost()){
                    dist[w.getId()] = dist[v.getId()] + w.getCost();
                    q.offer(new Node(w.getId(), w.getCost()));
                    visited[w.getId()] = true;
                }
            }
        }

        return dist;
    }
}
