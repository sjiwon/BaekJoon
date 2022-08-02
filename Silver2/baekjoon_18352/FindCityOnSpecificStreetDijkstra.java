package Silver2.baekjoon_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindCityOnSpecificStreetDijkstra {
    static StringTokenizer st;
    static int N; // 도시 개수 (Vertex)
    static int M; // 도로 개수 (Edge)
    static int K; // 거리 정보
    static int X; // 출발 도시 번호

    static class NodeInfo {
        private int node; // 노드 번호
        private int weight; // (모든 도로의 weight는 1)

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        public NodeInfo(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int[] distance; // X에서 각 도시까지의 거리
    static boolean[] visited;
    static List<List<NodeInfo>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        distance = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            distance[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<NodeInfo>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A-1).add(new NodeInfo((B-1), 1)); // (A-1) ~> (B-1)
        }

        dijkstra(X - 1); // X - 1을 해야 로직 정상 (node를 graph에 넣을 때 1씩 빼서 넣었기 때문)
    }

    static void dijkstra(int X){
        PriorityQueue<NodeInfo> queue = new PriorityQueue<>(new Comparator<NodeInfo>() {
            @Override
            public int compare(NodeInfo o1, NodeInfo o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        visited[X] = true;
        distance[X] = 0;
        queue.offer(new NodeInfo(X, 0));

        while(!queue.isEmpty()){
            NodeInfo poll = queue.poll();

            for(int w=0; w<graph.get(poll.getNode()).size(); w++){
                NodeInfo neighbor = graph.get(poll.getNode()).get(w);

                if(!visited[neighbor.getNode()]){
                    if(distance[neighbor.getNode()] > distance[poll.getNode()] + neighbor.getWeight()){
                        distance[neighbor.getNode()] = distance[poll.getNode()] + neighbor.getWeight();
                    }

                    visited[neighbor.getNode()] = true;
                    queue.offer(new NodeInfo(neighbor.getNode(), distance[neighbor.getNode()]));

                    /*
                    queue.offer(neighbor);
                    >> 이거는 neighbor의 Weight가 distance[neighbor.getNode()]로 update되지 않았기 때문에 이렇게 queue에 넣으면 틀린다
                        -> new NodeInfo(neighbor.getNode(), distance[neighbor.getNode()]) :: 이렇게 update된 weight를 새로 넣어줘야 한다
                     */
                }
            }
        }

        boolean flag = false;

        for(int i=0; i<distance.length; i++){
            if(distance[i] == K){
                flag = true;
                System.out.println((i + 1)); // 기준 노드에서 -1로 풀이했기 때문에 출력할 때는 +1 해주기
            }
        }

        if(!flag){
            System.out.println("-1");
        }
    }
}

/*
4 4 2 1
1 2
1 3
2 3
2 4
>> 4

4 3 2 1
1 2
1 3
1 4
>> -1

4 4 1 1
1 2
1 3
2 3
2 4
>> 2, 3
 */