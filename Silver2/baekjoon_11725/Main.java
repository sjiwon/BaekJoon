package Silver2.baekjoon_11725;

import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        private int id; // 노드 본인의 id
        private int parent; // 해당 노드의 부모노드
        private ArrayList<Node> list; // 해당 노드의 자식 노드들 저장 list
        Node(int id){
            this.id = id;
            this.parent = 0;
            list = new ArrayList<>();
        }
        int getID(){
            return id;
        }
        int getParent(){
            return parent;
        }
        ArrayList<Node> getList(){
            return list;
        }
        void setParent(int p){
            parent = p;
        }
    }
    static int N;
    static boolean [] visited;
    static Node [] node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        node = new Node[N+1];

        for(int i=1; i<=N; i++)
            node[i] = new Node(i);
            // 각 노드들 생성

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            node[node1].getList().add(node[node2]);
            node[node2].getList().add(node[node1]);
            // 각 노드들의 list에 연결된 node를 추가
        }

        bfs(1);

        for(int i=2; i<=N; i++)
            sb.append(node[i].getParent()).append("\n");

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Node> q = new LinkedList<>();
        q.offer(node[start]);
        visited[node[start].getID()] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            for(Node ch : now.getList()){
                // node(now)와 연결된 node(ch)들
                if(!visited[ch.getID()]){
                    visited[ch.getID()] = true;
                    ch.setParent(now.getID());
                    q.offer(ch);
                    // node(ch)의 부모노드를 node(now)로 설정
                }
            }
        }
    }
}
