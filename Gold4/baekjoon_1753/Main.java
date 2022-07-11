package Gold4.baekjoon_1753;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        private int id, w;
        Node(int id, int w){
            this.id = id; this.w = w;
        }
        int getId(){return id;}
        int getW(){return w;}

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getW(), o.getW());
        }
    }

    static StringTokenizer st;
    static LinkedList<Node> [] graph;
    static boolean [] visited;
    static int [] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];
        dist = new int[V+1];
        graph = new LinkedList[V+1];

        for(int i=0; i<=V; i++)
            graph[i] = new LinkedList<>();

        Arrays.fill(dist, INF);

        int K = Integer.parseInt(br.readLine()); // 시작 Vertex #

        while(E-- >0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, w));
        }

        dijkstra(K);

        for(int i=1; i<dist.length; i++){
            if(dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int K){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        visited[K] = true;
        dist[K] = 0;

        while(!pq.isEmpty()){
            Node v = pq.poll(); // 어느 한 정점

            for(Node w : graph[v.getId()]){
                // w : v의 인접 정점
                if(dist[w.getId()] > dist[v.getId()] + w.getW()){
                    dist[w.getId()] = dist[v.getId()] + w.getW();
                    pq.offer(new Node(w.getId(), dist[w.getId()]));
                    visited[w.getId()] = true;
                }
            }
        }
    }
}

