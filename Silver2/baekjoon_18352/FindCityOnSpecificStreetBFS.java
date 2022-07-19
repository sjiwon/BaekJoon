package Silver2.baekjoon_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

// BFS

public class FindCityOnSpecificStreetBFS {

    static StringTokenizer st;
    static int N;
    static int M;
    static int K;
    static int X;
    static int[] distance;
    static List<List<Integer>> graph = new ArrayList<>(); // 도시별 Mapping 정보 (단방향 매핑)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수 (Vertex)
        M = Integer.parseInt(st.nextToken()); // 도로 개수 (Edge)
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
        distance = new int[N];

        for(int i=0; i<N; i++){
            distance[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A-1).add(B-1);
        }

        findCity(graph, distance, X - 1);
    }

    static void findCity(List<List<Integer>> graph, int[] distance, int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        distance[startNode] = 0; // 시작지점 거리 = 0

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            for(int i=0; i<graph.get(poll).size(); i++){
                Integer neighbor = graph.get(poll).get(i);

                if(distance[neighbor] == Integer.MAX_VALUE){
                    distance[neighbor] = distance[poll] + 1;
                    queue.offer(neighbor);
                    /*
                    distance[neighbor]가 Integer.MAX_VALUE가 아닌 neighbor은 queue에 안넣어도 되고 넣으면 메모리 초과 발생
                    -> 어차피 시작위치가 X로 고정되어 있기 때문에 X에서 이미 check한 node에 대해서 neighbor가 다시 조회할 필요가 없다
                     */
                }
            }
        }

        boolean isFind = false;
        for(int i=0; i<N; i++){
            if(distance[i] == K){
                System.out.println(i + 1);
                isFind = true;
            }
        }

        if(!isFind){
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
