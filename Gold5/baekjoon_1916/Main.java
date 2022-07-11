package Gold5.baekjoon_1916;

import java.io.*;
import java.util.*;

public class Main {

    static class Bus implements Comparable<Bus>{
        private int id, cost;
        Bus(int id, int cost){
            this.id = id; this.cost = cost;
        }
        int getId(){return id;}
        int getCost(){return cost;}

        @Override
        public int compareTo(Bus o) {
            return this.getCost() - o.getCost();
        }
    }

    static StringTokenizer st;
    static boolean [] visited;
    static int [] dist;
    static List<Bus> [] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        visited = new boolean[N+1];
        dist = new int[N+1];
        graph = new LinkedList[N+1];

        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++)
            graph[i] = new LinkedList<>();

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine()); // 출발 도시 & 도착 도시
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(start, end) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        visited[start] = true;
        dist[start] = 0;

        while(!pq.isEmpty()){
            Bus v = pq.poll();

            if(dist[v.getId()] < v.getCost()) continue;
            /*
            (Vertex 2 - example)
            어떤 정점 v에 대해서 인접 정점으로 탐색한 Vertex 2에 대해서 그 때 이미 dist를 update했는데
            나중에 Vertex 2에서부터 시작하는 다익스트라 로직에서 굳이 다시 check할 필요가 없다
            >> 중복 거르기
             */

            for(Bus w : graph[v.getId()]){
                if(dist[w.getId()] > dist[v.getId()] + w.getCost()){
                    dist[w.getId()] = dist[v.getId()] + w.getCost();
                    visited[w.getId()] = true;
                    pq.offer(new Bus(w.getId(), dist[w.getId()]));
                }
            }
        }
        return dist[end];
    }
}

